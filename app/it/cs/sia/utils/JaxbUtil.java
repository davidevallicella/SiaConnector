package it.cs.sia.utils;

import it.cs.sia.models.JaxbObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class JaxbUtil {

    private static JAXBContext jaxbCtx = null;

    private JaxbUtil() {
    }

    static public Marshaller createMarshaller() throws JAXBException {
        return createMarshaller(getJAXBContext());
    }

    static public Marshaller createMarshaller(JAXBContext jaxbCtx) throws JAXBException {
        Marshaller marshaller = jaxbCtx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller;
    }

    static public Unmarshaller createUnmarshaller() throws JAXBException {
        return createUnmarshaller(getJAXBContext());
    }

    static public Unmarshaller createUnmarshaller(JAXBContext jaxbCtx) throws JAXBException {
        Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

        return unmarshaller;
    }

    static private JAXBContext getJAXBContext() throws JAXBException {

        if (JaxbUtil.jaxbCtx == null) {
            JaxbUtil.jaxbCtx = JAXBContext.newInstance(JaxbObjectFactory.class);
        }

        return JaxbUtil.jaxbCtx;
    }
}