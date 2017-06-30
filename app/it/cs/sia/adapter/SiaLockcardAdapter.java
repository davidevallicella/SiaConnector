package it.cs.sia.adapter;

import it.cs.sia.common.enums.SiaLockcard;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class SiaLockcardAdapter extends XmlAdapter<String, SiaLockcard> {

    @Override
    public String marshal(SiaLockcard v) throws Exception {
        return v.toString();
    }

    @Override
    public SiaLockcard unmarshal(String v) throws Exception {
        return SiaLockcard.valueOfByName(v);
    }
}
