package it.cs.sia.adapter;

import it.cs.sia.common.enums.SiaType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class SiaTypeAdapter extends XmlAdapter<String, SiaType> {

    @Override
    public String marshal(SiaType v) throws Exception {
        return v.toString();
    }

    @Override
    public SiaType unmarshal(String v) throws Exception {
        return SiaType.valueOf(v);
    }
}
