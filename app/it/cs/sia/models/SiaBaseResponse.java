package it.cs.sia.models;

import it.cs.sia.adapter.DateAdapter;
import it.cs.sia.common.enums.SiaStatusCode;
import it.cs.sia.http.SiaRichiestaAutorizzazioneOnline;
import it.cs.sia.utils.JaxbUtil;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public abstract class SiaBaseResponse implements SiaResponse {

    @XmlElement(name = "Timestamp")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date timestamp;

    @XmlElement(name = "Esito")
    private String esito;

    @XmlElement(name = "MAC")
    private String mac;

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public SiaStatusCode getEsito() {
        return SiaRichiestaAutorizzazioneOnline.StatusCode.valueOfByCode(esito);
    }

    @Override
    public String getMac() {
        return mac;
    }

    public static <T> T load(InputStream is) throws JAXBException, IOException {

        Object result;

        try {
            Unmarshaller unmarshaller = JaxbUtil.createUnmarshaller();
            result = unmarshaller.unmarshal(is);
        } finally {
            is.close();
        }

        return (T) result;
    }

    public static <T> T load(URL url) throws JAXBException {

        Unmarshaller unmarshaller = JaxbUtil.createUnmarshaller();

        return (T) unmarshaller.unmarshal(url);
    }

    public static <T> T load(Document document) throws JAXBException {

        Unmarshaller unmarshaller = JaxbUtil.createUnmarshaller();

        return (T) unmarshaller.unmarshal(document);
    }

    /**
     * @return true if the status code is 00, false otherwise
     */
    public boolean success() {
        return SiaStatusCode.OK.equals(this.esito);
    }
}
