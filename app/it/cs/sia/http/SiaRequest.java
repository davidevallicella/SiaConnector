package it.cs.sia.http;


import it.cs.sia.common.enums.SiaParameters;
import it.cs.sia.exceptions.SiaException;

import java.util.List;

/**
 * Created by Davide Vallicella on 17/05/2017.
 */
public interface SiaRequest {

    List<SiaParameters> getRequiredFields();

    List<SiaParameters> getOptionalFields();

    List<SiaParameters> getAllFields();

    SiaBaseRequest add(SiaParameters key, Object value);

    void clear();

    String getMac() throws SiaException;
}
