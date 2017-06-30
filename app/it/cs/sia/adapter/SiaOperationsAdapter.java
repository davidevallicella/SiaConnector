package it.cs.sia.adapter;

import it.cs.sia.common.enums.SiaOperations;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class SiaOperationsAdapter extends XmlAdapter<String, SiaOperations> {

    @Override
    public String marshal(SiaOperations v) throws Exception {
        return v.toString();
    }

    @Override
    public SiaOperations unmarshal(String v) throws Exception {
        return SiaOperations.valueOfByName(v);
    }
}
