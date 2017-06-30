package it.cs.sia.common.enums;

/**
 * Created by Davide Vallicella on 20/06/2017.
 */
public interface SiaStatusCode {

    public static final String OK = "00";

    String getCode();

    String getDescription();

    boolean equalsCode(String otherCode);

    String toString();
}
