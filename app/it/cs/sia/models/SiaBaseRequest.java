package it.cs.sia.models;

import it.cs.sia.utils.JaxbUtil;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class SiaBaseRequest {
    @XmlElement(name = "Release", defaultValue = "2")
    private String release;

    public static <T> void store(Object jaxbElement, OutputStream os) throws IOException, JAXBException {
        try {
            Marshaller marshaller = JaxbUtil.createMarshaller();
            marshaller.marshal(jaxbElement, os);
        } finally {
            os.close();
        }
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
