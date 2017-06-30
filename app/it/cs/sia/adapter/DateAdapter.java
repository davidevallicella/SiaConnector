package it.cs.sia.adapter;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */

import it.cs.sia.config.SiaConfig;
import org.apache.commons.lang.time.DateUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static it.cs.sia.config.SiaConfig.Key.TIMESTAMP_PATTERN;

public class DateAdapter extends XmlAdapter<String, Date> {

    private String[] patterns = {SiaConfig.properties.get(TIMESTAMP_PATTERN), "yyyy-MM-dd'T'HH:mm:ss"};
    private SimpleDateFormat dateFormat = new SimpleDateFormat(patterns[0]);

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return DateUtils.parseDate(v, patterns);
    }
}