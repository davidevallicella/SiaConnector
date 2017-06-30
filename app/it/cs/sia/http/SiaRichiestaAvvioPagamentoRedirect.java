package it.cs.sia.http;

import it.cs.sia.common.enums.SiaParameters;
import it.cs.sia.common.enums.SiaStatusCode;
import it.cs.sia.exceptions.SiaException;
import org.apache.commons.collections.ListUtils;

import java.util.Arrays;
import java.util.List;

import static it.cs.sia.common.enums.SiaParameters.*;


/**
 * Created by Cristian Bertuzzi on 05/06/2017.
 * <p>
 * <p>
 * Richiesta di autorizzazione online
 * <p>
 * Il primo passo che il merchant system deve compiere è far generare al browser del cliente un messaggio di avvio del
 * processo di pagamento verso SIA. Questo può essere fatto sia con una redirezione, od un link, (utilizzando quindi il
 * metodo HTTP GET) sia attraverso l’invio di una form con campi nascosti (che può utilizzare il metodo HTTP POST).
 * <p>
 * <p>
 * Il messaggio di avvio della transazione che arriva a SIA dal browser dell’utente deve contenere i seguenti campi:
 * <table>
 * <tr>
 * <th align="left">Campo</th><th align="center">Obbligatorio</th><th align="center">Dimensione</th><th>Tipo</th><th>Descrizione</th>
 * </tr>
 * <tr>
 * <td>PAGE</td><td align="center">Y</td><td align="center">6</td><td align="center">N</td><td>Costante per il redirect della pagina</td>
 * </tr>
 * <tr>
 * <td>IMPORTO</td><td align="center">Y</td><td align="center">Min. 2<br/>Max. 8</td><td align="center">N</td><td>Importo espresso nell’unità minima della valuta (centesimi di euro). Lunghezza minima 2 massima 8</td>
 * </tr>
 * <tr>
 * <td>VALUTA</td><td align="center">Y</td><td align="center">3</td><td align="center">AN</td><td>Valuta: codice ISO (EUR = 978)</td>
 * </tr>
 * <tr>
 * <td>IDORDINE</td><td align="center">Y</td><td align="center">Max. 50</td><td align="center">AN</td><td>Identificativo univoco dell’ordine: deve essere un codice alfanumerico lungo al massimo 50 caratteri. La sua univocità deve essere garantita per almeno 5 anni. I caratteri ammessi sono lettere, cifre, “-“ e “_”. Viene applicata la regular expression [a-zA-Z0-9\-_]</td>
 * </tr>
 * <tr>
 * <td>IDNEGOZIO</td><td align="center">Y</td><td align="center"><br/></td><td align="center">AN</td><td>Identificatore del negozio del merchant assegnato dalla BANCA, Codice Riconoscimento Negozio(CRN)</td>
 * </tr>
 * <tr>
 * <td>URLBACK</td><td align="center">Y</td><td align="center">Max. 254</td><td align="center">AN</td><td>URL completa verso la quale eseguire una redirect per rimandare l’utente al negozio (può comprendere tutti gli eventuali parametri da passare) nel caso di annullamento del processo di pagamento. Lunghezza massima 254 caratteri</td>
 * </tr>
 * <tr>
 * <td>URLDONE</td><td align="center">Y</td><td align="center">Max. 254</td><td align="center">AN</td><td>URL completa verso la quale redirigere il browser del cliente a transazione avvenuta con successo (può comprendere tutti gli eventuali parametri da passare). Il sistema appende ad essa i parametri dell'esito. Lunghezza massima 254 caratteri</td>
 * </tr>
 * <tr>
 * <tr>
 * <td>URLMS</td><td align="center">Y</td><td align="center">Max. 400</td><td align="center">AN</td><td>URL del merchant system verso la quale SIA effettua la GET o POST di conferma dell’avvenuto pagamento. (può contenere eventuali parametri impostati dal negozio). Il sistema appende ad essa i parametri dell'esito. Lunghezza massima 400 caratteri</td>
 * </tr>
 * <td>TCONTAB</td><td align="center">Y</td><td align="center">Min. 1<br/>Max. 1</td><td align="center">A</td><td>Tipo di contabilizzazione da utilizzare per questo ordine:
 *  D differita
 *  I immediata
 * Vedi appendice E</td>
 * </tr>
 * <tr>
 * <td>TAUTOR</td><td align="center">Y</td><td align="center">Min. 1<br/>Max. 1</td><td align="center">A</td><td>Tipo di autorizzazione da utilizzare per questo ordine:
 *  D differita
 *  I immediata
 * Vedi appendice E</td>
 * </tr>
 * <tr>
 * <td>LINGUA</td><td align="center">N</td><td align="center"></td><td align="center">AN</td><td>Lingua nella quale devono essere mostrati i messaggi di interazione con l’utente finale. Il campo è facoltativo; di default la lingua è quella Italiana.</td>
 * </tr>
 * <tr>
 * <td>EMAILESERC</td><td align="center">N</td><td align="center">Min. 7<br/>Max. 50</td></td><td align="center">AN</td><td>Contiene l'indirizzo e-mail al quale inviare la e-mail di esito della transazione. Se non è presente viene utilizzato quello disponibile nella anagrafica SIA del negozio. Lunghezza minima 7 caratteri alfanumerici massima 50</td>
 * </tr>
 * <tr>
 * <td>OPTIONS</td><td align="center">N</td><td align="center">Min. 1<br/>Max. 1</td></td><td align="center">AN</td><td>Contiene gli indicatori delle opzioni aggiuntive che si intende attivare per il pagamento in corso. L’ordine con il quale appaiono le opzioni e’ indifferente. Il contenuto del campo non e’ case sensitive.</td>
 * </tr>
 * <tr>
 * <td>LOCKCARD</td><td align="center">N</td><td align="center">Min. 2<br/>Max. 2</td></td><td align="center">AN</td><td>Contiene il codice circuito corrispondente al tipo di strumento di pagamento con cui l’esercente desidera che venga effettuato il pagamento.</td>
 * </tr>
 * <tr>
 * <td>COMMIS</td><td align="center">N</td><td align="center">Min. 1<br/>Max. 8</td></td><td align="center">N</td><td>Importo della commissione sul servizio espresso nell’unità minima della valuta (centesimi di euro). Si tenga presente che il parametro IMPORTO è comprensivo della commissione. NOTA BENE: il parametro COMMIS, se presente, è significativo se e solo se è stata impostata anche l’opzione aggiuntiva OPTIONS = F (pagamento con commissione su servizio). Lunghezza minima 1 massima 8.</td>
 * </tr>
 * <tr>
 * <td>EMAIL</td><td align="center">N</td><td align="center">Min. 7<br/>Max. 50</td></td><td align="center">AN</td><td>Indirizzo di e-mail del cliente. Se il campo non è presente verrà richiesto all’utente insieme ai dati della carta di credito. Lunghezza minima 7 caratteri alfanumerici massima 50.</td>
 * </tr>
 * <tr>
 * <td>DESCRORD</td><td align="center">N</td><td align="center">Max. 140</td></td><td align="center">AN</td><td>Descrizione ordine (vedere OPTIONS O). Lunghezza massima 140.</td>
 * </tr>
 * <tr>
 * <td>IDVS</td><td align="center">N</td><td align="center">Max. 35</td></td><td align="center">AN</td><td>Identificativo validation service per transazioni mybank. Se presente fa saltare la pagina di scelta della banca mybank redirigendo l'utente sulla home banking associata all'identificativo ricevuto. Lunghezza massima 35.</td>
 * </tr>
 * <tr>
 * <td>DESCROP</td><td align="center">N</td><td align="center">Max. 100</td></td><td align="center">AN</td><td>Descrizione aggiuntiva dell'operazione di contabilizzazione, a discrezione dell'esercente (solo per contabilizzazione immediata). Lunghezza massima 100.</td>
 * </tr>
 * </table>
 */
public class SiaRichiestaAvvioPagamentoRedirect extends SiaBaseRequest {

    public SiaRichiestaAvvioPagamentoRedirect(String startKey) {
        super(startKey);
    }

    public List<SiaParameters> getRequiredFields() {
        return Arrays.asList(
                IMPORTO,
                VALUTA,
                NUM_ORD,
                ID_NEGOZIO,
                URL_BACK,
                URL_DONE,
                URL_MS,
                TIPO_CONTAB,
                TIPO_AUTOR
        );
    }

    public List<SiaParameters> getOptionalFields() {
        return Arrays.asList(
                LINGUA,
                EMAIL_ESERC,
                OPTIONS,
                LOCK_CARD,
                COMMIS,
                EMAIL,
                DESCR_ORD,
                ID_VS,
                DESCR_OP
        );
    }

    public List<SiaParameters> getAllFields() {
        return ListUtils.union(getRequiredFields(), getOptionalFields());
    }

    public String getMac() throws SiaException {
        List<SiaParameters> params = Arrays.asList(
                URL_MS,
                URL_DONE,
                NUM_ORD,
                ID_NEGOZIO,
                IMPORTO,
                VALUTA,
                TIPO_CONTAB,
                TIPO_AUTOR,
                OPTIONS,//(se presente)
                NOME, //(se presente per OPTIONS B)
                COGNOME, // (se presente per OPTIONS B)
                LOCK_CARD, // (se presente)
                COMMIS, // (se presente per OPTIONS F)
                DESCR_ORD,// (se presente per OPTIONS O)
                ID_VS, // (se presente)
                DESCR_OP //(se presente)
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
        SYSTEM_DENIED("01", "Negata dal sistema"),
        STORE_DENIED("02", "Negata per problemi sull'anagrafica negozio"),
        AUTHORIZATION_DENIED("03", "Negata per problemi di comunicazione con i circuiti autorizzativi"),
        CARD_ISSUE_DENIED("04", "Negata dall'emittente della carta"),
        CARD_NUMBER_ERROR("05", "Negata per numero carta errato"),
        UNEXPECTED_ERROR("06", "Errore imprevisto durante l’elaborazione della richiesta"),
        DUPLICATE_ORDER("07", "Ordine duplicato");

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