package it.cs.sia.validation;

/**
 * Created by Davide Vallicella on 15/06/2017.
 */
public class TypeValidation<T> extends BaseValidation {
    protected final Class<T> persistentClass;

    public TypeValidation(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public boolean isValid(Object value) {
        return Object.class.isAssignableFrom(persistentClass);
    }
}