package it.cs.sia.models;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
@XmlRegistry
public class JaxbObjectFactory {

    public static SiaRispostaAutorizzazioneOnlineJaxbDao createSiaRispostaAutorizzazioneOnline() {
        return new SiaRispostaAutorizzazioneOnlineJaxbDao();
    }

    public static SiaAuthorizationJaxbDao createSiaAuthorization() {
        return new SiaAuthorizationJaxbDao();
    }
}