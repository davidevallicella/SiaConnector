package it.cs.sia.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
@XmlRootElement(name = "Dati")
public class SiaDatiJaxbDao {

    @XmlElement(name = "Autorizzazione", type = SiaAuthorizationJaxbDao.class)
    private SiaAuthorizationJaxbDao autorizzazione;

    public SiaAuthorizationJaxbDao getAutorizzazione() {
        return autorizzazione;
    }
}
