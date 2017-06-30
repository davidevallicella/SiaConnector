package it.cs.sia.validation;

import java.util.regex.Pattern;

/**
 * Created by Davide Vallicella on 01/06/2017.
 */
public class Ipv4Validation extends BaseValidation {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public boolean isValid(Object value) {
        return PATTERN.matcher(objToString(value)).matches();
    }
}
