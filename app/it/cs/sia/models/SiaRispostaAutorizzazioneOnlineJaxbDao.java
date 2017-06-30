package it.cs.sia.models;

import it.cs.sia.utils.JaxbUtil;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
@XmlRootElement(name = "BPWXmlRisposta")
public class SiaRispostaAutorizzazioneOnlineJaxbDao extends SiaBaseResponse {

    @XmlElement(name = "Dati", type = SiaDatiJaxbDao.class)
    private SiaDatiJaxbDao data;

    @Override
    public SiaDatiJaxbDao getData() {
        return data;
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        try {
            Marshaller marshaller = JaxbUtil.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, sw);
        } catch (Exception ignore) {
            // donothing
        }

        return sw.toString();
    }
}
