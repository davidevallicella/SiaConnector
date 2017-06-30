package it.cs.sia.validation;

import it.cs.sia.config.SiaConfig;

/**
 * Created by Davide Vallicella on 31/05/2017.
 */
public class LengthValidation extends BaseValidation {
    private SiaConfig.Key key1;
    private SiaConfig.Key key2;
    private Operation op;

    public LengthValidation(SiaConfig.Key key, Operation op) {
        this.key1 = key;
        this.op = op;
    }

    public LengthValidation(SiaConfig.Key key1, SiaConfig.Key key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public LengthValidation(SiaConfig.Key key) {
        this(key, Operation.EQ);
    }

    @Override
    public boolean isValid(Object value) {
        if (key2 != null) {
            return new RangeValidation(key1, key2).isValid(objSize(value));
        }

        switch (op) {
            case BIG:
                return objSize(value) >= SiaConfig.properties.getInt(key1);
            case MIN:
                return objSize(value) <= SiaConfig.properties.getInt(key1);
            default:
                return objSize(value).equals(SiaConfig.properties.getInt(key1));
        }
    }

    public enum Operation {
        EQ, BIG, MIN
    }
}
