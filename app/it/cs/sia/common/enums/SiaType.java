package it.cs.sia.common.enums;

/**
 * Created by Davide Vallicella on 16/06/2017.
 */
public enum SiaType implements SiaCommonInterface {

    /**
     * Immediata
     */
    I("I"),

    /**
     * Differita
     */
    D("D");

    private final String name;

    SiaType(String name) {
        this.name = name;
    }

    @Override
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}