package it.cs.sia.http;

import it.cs.sia.common.enums.SiaParameters;
import it.cs.sia.common.enums.SiaStatusCode;
import it.cs.sia.exceptions.SiaException;

import java.util.Arrays;
import java.util.List;

import static it.cs.sia.common.enums.SiaOperations.AUTORIZZAZIONE_DIFFERITA;
import static it.cs.sia.common.enums.SiaParameters.*;

/**
 * Created by Davide vallicella on 17/05/2017.
 * <p>
 * <p>
 * Richiesta di autorizzazione online
 * <p>
 * Il messaggio di richiesta di autorizzazione online permette di inoltrare ai circuiti richieste di autorizzazione.
 * <p>
 * <p>
 * I campi da specificare nel messaggio HTTP di richiesta sono i seguenti:
 * <table>
 * <tr>
 * <th align="left">Campo</th><th align="center">Obbligatorio</th><th align="center">Dimensione</th><th>Tipo</th><th>Descrizione</th>
 * </tr>
 * <tr>
 * <td>OPERAZIONE</td><td align="center">Y</td><td align="center"></td><td align="center">A</td><td>Operazione richiesta: valorizzato con "AUTORIZZAZIONEONLINE"</td>
 * </tr>
 * <tr>
 * <td>TIMESTAMP</td><td align="center">Y</td><td align="center">23</td><td align="center">AN</td><td>Timestamp locale del tipo yyyy-MM-ggTHH:mm:ss.SSS</td>
 * </tr>
 * <tr>
 * <td>IDNEGOZIO</td><td align="center">Y</td><td align="center">15</td><td align="center">AN</td><td>Identificatore del negozio del merchant assegnato da SIA, Merchant ID (MID)</td>
 * </tr>
 * <tr>
 * <td>IDORDINE</td><td align="center">Y</td><td align="center">Min. 1<br/>Max. 50</td><td align="center">AN</td><td>Identificatore univoco dell’ordine</td>
 * </tr>
 * <tr>
 * <td>IDOPERATORE</td><td align="center">Y</td><td align="center">Min. 8<br/>Max. 18</td><td align="center">AN</td><td>Indica chi ha richiesto l’operazione. Deve essere passata la User ID di un operatore valido.</td>
 * </tr>
 * <tr>
 * <td>REQREFNUM</td><td align="center">Y</td><td align="center">32</td><td align="center">N</td><td>Identificatore univoco della richiesta gestito dall’esercente . Può essere usato per il recupero delle informazioni in merito alla richiesta fatta anche nel caso di mancata risposta. I primi 8 caratteri devono avere il formato yyyyMMdd con la data della richiesta.</td>
 * </tr>
 * <tr>
 * <td>PAN</td><td align="center">Y</td><td align="center">Min. 10<br/>Max. 19</td><td align="center">AN</td><td>Numero della carta</td>
 * </tr>
 * <tr>
 * <td>CVV2</td><td align="center">N</td><td align="center">Min. 3<br/>Max. 4</td><td align="center">N</td><td>Codice di controllo associato al numero della carta (opzionale)</td>
 * </tr>
 * <tr>
 * <td>DATASCAD</td><td align="center">Y</td><td align="center">4</td><td align="center">N</td><td>Data di scadenza della carta – yyMM-</td>
 * </tr>
 * </table>
 */
public class SiaRichiestaAutorizzazioneDifferita extends SiaBaseRequest {

    public SiaRichiestaAutorizzazioneDifferita(String startKey) {
        super(AUTORIZZAZIONE_DIFFERITA, startKey);
    }

    @Override
    public List<SiaParameters> getRequiredFields() {
        return Arrays.asList(
                TIMESTAMP,
                ID_NEGOZIO,
                ID_ORDINE,
                ID_OPERATORE,
                REQ_REF_NUM,
                PAN,
                DATA_SCAD,
                IMPORTO,
                VALUTA,
                CODICE_CIRCUITO);
    }

    @Override
    public List<SiaParameters> getOptionalFields() {
        return Arrays.asList(
                CVV2,
                EMAIL_TIT,
                USER_ID,
                ACQUIRER,
                IP_ADDRESS,
                RELEASE);
    }

    @Override
    public String getMac() throws SiaException {
        List<SiaParameters> params = Arrays.asList(
                OPERAZIONE,
                TIMESTAMP, ID_NEGOZIO, ID_ORDINE, ID_OPERATORE, REQ_REF_NUM, PAN,
                CVV2, // se presente
                DATA_SCAD, IMPORTO, VALUTA, CODICE_CIRCUITO,
                EMAIL_TIT, // se presente
                USER_ID, // se presente
                ACQUIRER, // se presente
                IP_ADDRESS // se presente
        );

        return buildMAC(params);
    }

    @Override
    public void validate() throws SiaException {
        super.validate();
        this.fields.put(MAC, getMac());
    }

    public enum StatusCode implements SiaStatusCode {

        /**
         * Successo
         */
        OK("00", "Successo"),

        /**
         * ReqRefNum duplicato od errato.
         */
        REQ_REF_NUM_ERROR("02", "ReqRefNum duplicato od errato"),

        /**
         * Formato messaggio errato, campo mancante o errato.
         */
        FORMAT_ERROR("03", "Formato messaggio errato, campo mancante o errato"),

        /**
         * Formato messaggio errato, campo mancante o errato.
         */
        AUTHENTICATION_ERROR("04", "Formato messaggio errato, campo mancante o errato"),

        /**
         * Errore imprevisto durante l’elaborazione della richiesta.
         */
        UNEXPECTED_ERROR("06", "Errore imprevisto durante l’elaborazione della richiesta"),

        /**
         * CVV2 mancante.
         */
        CVV2_ERROR("37", "CVV2 mancante"),

        /**
         * Xml vuoto o parametro ‘data’ mancante.
         */
        XML_DATA_ERROR("40", "Xml vuoto o parametro ‘data’ mancante"),

        /**
         * Xml non parsabile.
         */
        XML_PARSER_ERROR("41", "Xml non parsabile"),

        /**
         * Errore applicativo.
         */
        APPLICATION_ERROR("98", "Errore applicativo"),

        /**
         * Operazione fallita, vedere l'esito specifico allegato all'elemento <Dati> della risposta.
         */
        FAILED("99", "Operazione fallita, vedere l'esito specifico allegato all'elemento <Dati> della risposta");

        private final String code;
        private final String description;

        StatusCode(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public static SiaStatusCode valueOfByCode(String code) {
            for (SiaStatusCode o : values()) {
                if (o.equalsCode(code)) {
                    return o;
                }
            }

            return null;
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        @Override
        public boolean equalsCode(String otherCode) {
            return this.code.equals(otherCode);
        }

        @Override
        public String toString() {
            return String.format("Error: %s - %s", this.code, this.description);
        }
    }
}