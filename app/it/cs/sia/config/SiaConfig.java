package it.cs.sia.config;

import play.Logger;
import play.Play;
import play.i18n.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static it.cs.sia.config.SiaConfig.Key.MAC_ALGORITHM;

/**
 * Created by Davide Vallicella on 31/05/2017.
 */

public enum SiaConfig implements Config {
    properties("sia.properties");

    public static final String mac_algorithm = properties.get(MAC_ALGORITHM);
    public static final String VERSION = "2";

    private final Properties config;

    SiaConfig(String path) {
        config = new Properties();
        try {
            config.load(Play.classloader.getResourceAsStream(path));
        } catch (Exception e) {
            Logger.error(Messages.get("Sia invalid config path", path));
        }
    }

    @Override
    public String get(Config.Key key) {
        return config.getProperty(key.toString());
    }

    @Override
    public String get(Config.Key key, String defaultValue) {
        return config.getProperty(key.toString(), defaultValue);
    }

    @Override
    public List<String> getList(Config.Key key) {
        return Arrays.asList(get(key).split("\\s*,\\s*"));
    }

    @Override
    public Integer getInt(Config.Key key) {
        try {
            return Integer.parseInt(get(key));
        } catch (NumberFormatException ignored) {
            Logger.warn("Sia invalid number: %s", get(key));
            return -1;
        }
    }

    @Override
    public List<Integer> getIntList(Config.Key key) {
        List<String> items = getList(key);
        List<Integer> results = new ArrayList<Integer>(items.size());
        for (String item : items) {
            try {
                results.add(Integer.parseInt(item));
            } catch (NumberFormatException ignored) {
                Logger.warn("Sia invalid number for list: %s", item);
            }
        }

        return results;
    }

    public enum Key implements Config.Key {
        PAN_MAX_LENGTH("sia.panMaxLength"),
        PAN_MIN_LENGTH("sia.panMinLength"),
        EMAIL_MAX_LENGTH("sia.emailMaxLength"),
        EMAIL_MIN_LENGTH("sia.emailMinLength"),
        USER_ID_MAX_LENGTH("sia.userIDMaxLength"),
        USER_ID_MIN_LENGTH("sia.userIDMinLength"),
        COMMIS_MAX_LENGTH("sia.commisMaxLength"),
        COMMIS_MIN_LENGTH("sia.commisMinLength"),
        IMPORTO_MIN_VALUE("sia.importoMinValue"),
        IMPORTO_MAX_VALUE("sia.importoMaxValue"),
        VALUTA_CURRENCIES("sia.valutaCurrencies"),
        ID_NEGOZIO_LENGTH("sia.idNegozioLength"),
        REQREFNUM_LENGTH("sia.reqRefNumLength"),
        RELEASE_LENGTH("sia.releaseLength"),
        ACQUIRER_LENGTH("sia.acquirerLength"),
        CVV2_MIN_LENGTH("sia.cvv2MinLength"),
        CVV2_MAX_LENGTH("sia.cvv2MaxLength"),
        MAC_LIST_LENGTH("sia.macListLegth"),
        ID_ORDINE_MIN_LENGTH("sia.idOrdineMinLength"),
        ID_ORDINE_MAX_LENGTH("sia.idOrdineMaxLength"),
        ID_OPERATORE_MIN_LENGTH("sia.idOperatoreMinLength"),
        ID_OPERATORE_MAX_LENGTH("sia.idOperatoreMaxLength"),
        TIMESTAMP_PATTERN("sia.timestampPattern"),
        NUMERO_ORDINE_MIN_LENGTH("sia.numOrdineMinLength"),
        NUMERO_ORDINE_MAX_LENGTH("sia.numOrdineMaxLength"),
        TIPO_CONTAB_LIST("sia.tipoContabList"),
        TIPO_AUTORIZZAZIONE_LIST("sia.tautorList"),
        LINGUA_LIST("sia.linguaList"),
        LOCKCARD_LIST("sia.lockcardList"),
        ID_TRANSAZIONE_LENGTH("sia.idTransLength"),
        DATA_SCADENZA_PATTERN("sia.dataScadPattern"),
        URL_MIN_LENGTH("sia.urlMinLength"),
        URL_BACK_MAX_LENGTH("sia.urlBackMaxLength"),
        URL_DONE_MAX_LENGTH("sia.urlDoneMaxLength"),
        URL_MS_MAX_LENGTH("sia.urlMSMaxLength"),
        ID_VS_LENGTH("sia.idVSLength"),
        DESC_ORDINE_LENGTH("sia.descrOrdLength"),
        DESC_OPERAZIONE_LENGTH("sia.descrOpLength"),
        CODICE_CIRCUITO_MAX_LENGTH("sia.codiceCircuitoMaxLength"),
        NOME_MIN_LENGTH("sia.nomeMinLength"),
        NOME_MAX_LENGTH("sia.nomeMaxLength"),
        COGNOME_MIN_LENGTH("sia.cognomeMinLength"),
        COGNOME_MAX_LENGTH("sia.cognomeMaxLength"),
        MAC_ALGORITHM("sia.macAlgorithm"),
        PAGE_LIST("sia.pageList"),
        // ambiente produzione
        GATEWAY_URL("sia.gatewayURL"),
        API_URL("sia.apiURL"),
        // ambiente test
        GATEWAY_URL_TEST("sia.gatewayURLTest"),
        API_URL_TEST("sia.apiURLTest");

        private final String name;

        Key(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}