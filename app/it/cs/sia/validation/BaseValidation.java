package it.cs.sia.validation;

/**
 * Created by valli on 05/06/2017.
 */
public abstract class BaseValidation implements SiaValidationStrategy {
    static Integer objToInt(Object value) {
        try {
            return Integer.parseInt(objToString(value));
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    static String objToString(Object value) {
        return String.valueOf(value);
    }

    static Integer objSize(Object value) {
        return objToString(value).length();
    }
}
