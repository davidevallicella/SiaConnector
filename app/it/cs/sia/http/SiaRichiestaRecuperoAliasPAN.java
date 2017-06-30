package it.cs.sia.http;

import it.cs.sia.common.enums.SiaParameters;
import it.cs.sia.exceptions.SiaException;

import java.util.Arrays;
import java.util.List;

import static it.cs.sia.common.enums.SiaOperations.RECUPERA_ALIAS_PAN;
import static it.cs.sia.common.enums.SiaParameters.*;

/**
 * Created by Davide Vallicella on 15/06/2017.
 */
public class SiaRichiestaRecuperoAliasPAN extends SiaBaseRequest {

    public SiaRichiestaRecuperoAliasPAN(String startKey) {
        super(RECUPERA_ALIAS_PAN, startKey);
    }

    @Override
    public List<SiaParameters> getRequiredFields() {
        return Arrays.asList(TIMESTAMP, ID_NEGOZIO, ID_OPERATORE, REQ_REF_NUM, ID_ORDINE);
    }

    @Override
    public List<SiaParameters> getOptionalFields() {
        return Arrays.asList(RELEASE);
    }

    @Override
    public String getMac() throws SiaException {
        List<SiaParameters> params = Arrays.asList(OPERAZIONE, TIMESTAMP, ID_NEGOZIO, ID_OPERATORE, REQ_REF_NUM, ID_ORDINE);

        return buildMAC(params);
    }
}
