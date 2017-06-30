package it.cs.sia.models;

import it.cs.sia.common.enums.SiaStatusCode;

import java.util.Date;

/**
 * Created by Davide vallicella on 27/06/2017.
 */

public interface SiaResponse {

    public Date getTimestamp();

    public SiaStatusCode getEsito();

    public String getMac();

    public SiaDatiJaxbDao getData();
}
