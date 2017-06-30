package it.cs.sia.validation;

import it.cs.sia.config.SiaConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Davide vallicella on 31/05/2017.
 */
public class DateValidation extends BaseValidation {
    private SiaConfig.Key key;

    public DateValidation(SiaConfig.Key key) {
        this.key = key;
    }

    public static boolean validate(String date, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ITALY);
            formatter.setLenient(false);
            formatter.parse(date);
            return formatter.toPattern().replace("'", "").length() == date.length();
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public boolean isValid(Object value) {
        return validate(objToString(value), SiaConfig.properties.get(key));
    }
}
