package it.cs.sia.validation;

import it.cs.sia.config.SiaConfig;
import play.Logger;

/**
 * Created by Davide vallicella on 31/05/2017.
 */
public class ListValidation<T> extends TypeValidation {
    private SiaConfig.Key key;

    public ListValidation(Class<T> persistentClass, SiaConfig.Key key) {
        super(persistentClass);
        this.key = key;
    }

    public ListValidation(SiaConfig.Key key) {
        this((Class<T>) String.class, key);
    }

    @Override
    public boolean isValid(Object value) {
        try {
            if (super.isValid(value)) {
                if (value instanceof Integer) {
                    return SiaConfig.properties.getIntList(key).contains(objToInt(value));
                } else {
                    return SiaConfig.properties.getList(key).contains(objToString(value));
                }
            }
        } catch (Exception ignored) {
            Logger.warn("Sia invalid value: %s", objToInt(value));
        }

        return false;
    }
}
