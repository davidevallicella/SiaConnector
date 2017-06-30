package it.cs.sia.validation;

import it.cs.sia.config.SiaConfig;
import org.apache.commons.lang.math.IntRange;
import play.Logger;

/**
 * Created by Davide Vallicella on 31/05/2017.
 */
public class RangeValidation extends BaseValidation {
    private SiaConfig.Key key1;
    private SiaConfig.Key key2;

    public RangeValidation(SiaConfig.Key key1, SiaConfig.Key key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public boolean isValid(Object value) {
        try {
            return new IntRange(SiaConfig.properties.getInt(key1), SiaConfig.properties.getInt(key2)).containsInteger(objToInt(value));
        } catch (IllegalArgumentException ignored) {
            Logger.warn("Sia invalid value for range: %s", objToInt(value));
            return false;
        }
    }
}
