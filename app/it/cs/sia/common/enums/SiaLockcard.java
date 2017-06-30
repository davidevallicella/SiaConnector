package it.cs.sia.common.enums;

/**
 * Created by Davide Vallicella on 16/06/2017.
 */
public enum SiaLockcard implements SiaCommonInterface {

    VISA("01"),
    MASTERCARD("02"),
    MAESTRO("04"),
    CIRRUS("05"),
    AMERICAN_EXPRESS("06"),
    DINERS("07"),
    JCB("08"),
    AURA("10"),
    PAYPASS("49"),
    POSTEPAY("94"),
    MY_BANK("96"),
    PAYPAL("97"),
    CARTE_DI_CREDITO("CC"),
    ALTRO("NC");

    private final String name;

    SiaLockcard(String name) {
        this.name = name;
    }

    public static SiaLockcard valueOfByName(String name) {
        for (SiaLockcard o : values()) {
            if (o.equalsName(name)) {
                return o;
            }
        }

        return null;
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