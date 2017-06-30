package it.cs.sia.http;

import it.cs.sia.common.enums.SiaOperations;
import it.cs.sia.common.enums.SiaParameters;
import it.cs.sia.config.SiaConfig;
import it.cs.sia.exceptions.SiaException;
import org.apache.commons.collections.ListUtils;
import play.Logger;
import play.i18n.Messages;
import play.libs.WS;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import static it.cs.sia.common.enums.SiaParameters.*;

/**
 * Created by Davide Vallicella on 17/05/2017.
 */
public abstract class SiaBaseRequest implements SiaRequest {

    public Map<SiaParameters, Object> fields;
    protected String startKey;
    /**
     * MD5 | SHA-1 default set to MD5
     */
    protected String macAlgorithm = SiaConfig.mac_algorithm;
    WS.WSRequest request;

    public SiaBaseRequest(String startKey) {
        fields = new HashMap<SiaParameters, Object>();
        this.startKey = startKey;
    }

    public SiaBaseRequest(SiaOperations operazione, String startKey) {
        this(startKey);

        SimpleDateFormat df = new SimpleDateFormat(SiaConfig.properties.get(SiaConfig.Key.TIMESTAMP_PATTERN), Locale.ITALY);
        // default parameters
        fields.put(OPERAZIONE, operazione);
        fields.put(TIMESTAMP, df.format(new Date()));
    }

    @Override
    public SiaBaseRequest add(SiaParameters key, Object value) {
        this.fields.put(key, value);
        return this;
    }

    public void invalidate() {
        fields.remove(MAC);
    }

    public void validate() throws SiaException {
        for (Map.Entry<SiaParameters, Object> e : fields.entrySet()) {
            SiaParameters field = e.getKey();

            if (!field.validate(e.getValue())) {
                invalidate();
                Logger.error("%s:\t%s\t ERRORE", field, e.getValue());

                throw new SiaException(Messages.get("Sia invalid parameters", field));
            }
        }
    }

    @Override
    public void clear() {
        this.fields.clear();
    }

    @Override
    public List<SiaParameters> getAllFields() {
        return ListUtils.union(getRequiredFields(), getOptionalFields());
    }

    public void setMacAlgorithm(String algorithm) throws SiaException {
        try {
            this.macAlgorithm = MessageDigest.getInstance(algorithm).getAlgorithm();
        } catch (NoSuchAlgorithmException e) {
            throw new SiaException(Messages.get("Sia invalid algorithm", algorithm));
        }
    }

    protected String buildMAC(List<SiaParameters> params) throws SiaException {
        StringBuilder mac = new StringBuilder();

        for (SiaParameters k : params) {
            if (fields.containsKey(k) && fields.get(k) != null) {
                mac.append(String.format("%s=%s&", k, fields.get(k)));
            }
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(macAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new SiaException(Messages.get("Sia invalid algorithm", macAlgorithm));
        } finally {
            md.reset();
            md.update(mac.append(startKey).toString().getBytes());
        }

        return new HexBinaryAdapter().marshal(md.digest());
    }

    public WS.HttpResponse get(String url) {
        request = WS.url(url).setHeader("Content-Type", "application/xml");
        for (Map.Entry<SiaParameters, Object> field : fields.entrySet()) {
            if (field.getValue() != null) {
                request.setParameter(field.getKey().toString(), field.getValue());
            }
        }

        return request.get();
    }
}
