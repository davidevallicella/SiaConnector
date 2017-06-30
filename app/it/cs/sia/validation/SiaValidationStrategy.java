package it.cs.sia.validation;

/**
 * Created by Davide vallicella on 31/05/2017.
 */

public interface SiaValidationStrategy {
    boolean isValid(Object value);
}