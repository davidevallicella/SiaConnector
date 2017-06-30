package it.cs.sia.common.enums;

/**
 * Created by Davide Vallicella on 17/05/2017.
 * <p>
 * <p>Le funzionalità messe a disposizione dei merchant system sono le seguenti:</p>
 * <p>
 * <table>
 * <tr>
 * <th>Funzione</th><th>Descrizione</th>
 * </tr>
 * <tr><td>Conferma di autorizzazione differita</td><td>Permette di inoltrare richieste di autorizzazione a conferma di pagamenti con autorizzazioni differite.</td></tr>
 * <tr><td>Richiesta di autorizzazione online</td><td>Permette di inoltrare le autorizzazioni verso i circuti autorizzativi.</td></tr>
 * <tr><td>Richiesta di autorizzazione differita</td><td>Permette il caricamento di un ordine sul servizio @POS. Tale ordine dovrà poi essere confermato tramite una richiesta di conferma autorizzazione differita.</td></tr>
 * <tr><td>Chiusura autorizzazione differita</td><td>Viene resa non più utilizzabile la autorizzazione differita per ulteriori conferme.</td></tr>
 * <tr><td>Richiesta di storno di un pagamento</td><td>La richiesta di storno viene applicata dal sistema @POS ad un pagamento (autorizzazione), indifferentemente dal suo stato.</td></tr>
 * <tr><td>Richiesta di contabilizzazione</td><td>Permette di inoltrare a @POS la richiesta per contabilizzare una autorizzazione con carta di credito precedentemente concessa con contabilizzazine differita.</td></tr>
 * <tr><td>Annullamento richiesta di contabilizzazione</td><td>Annulla una richiesta di contabilizzazione e rende l’autorizzazione con carta di credito nuovamente contabilizzabile.</td></tr>
 * <tr><td>Split(divisione e/o riduzione) ordine con autorizzazione immediata</td><td>Rende possibile lo split shipment (divisione e/o riduzione) per un ordine che era stato eseguito con autorizzazione immediata: storna la autorizzazione immediata e piazza una nuova autorizzazine differita da confermare in pezzi.</td></tr>
 * <tr><td>Verifica esito messaggio di richiesta</td><td>Fornendo il numero identificativo della richiesta voluta, restituisce l’esito del messaggio precedentemente inoltrato.</td></tr>
 * <tr><td>Elenco operazioni contabili</td><td>Ricava l’elenco delle operazioni di carattere contabile. Contiene quelle richieste e quelle già inviate agli acquirer distinte con uno stato.</td></tr>
 * <tr><td>Elenco autorizzazioni richieste</td><td>Vengono visualizzate le richieste di autorizzazione inoltrate al sistema:
 * <ol>
 * <li><p>Con esito positivo</p></li>
 * <li><p>Con esito negativo</p></li>
 * <li><p>Autorizzazioni stornate</p></li>
 * <li><p>Tutte</p></li>
 * </ol></td></tr>
 * <tr><td>Richiesta situazione di un ordine</td><td>Restituisce la situazione attuale di un ordine con tutte le operazioni di autorizzazione ad esso legate.</td></tr>
 * </table>
 */
public enum SiaOperations implements SiaCommonInterface {

    // OPERAZIONI DI RICHIESTA ------------------------------------//

    /**
     * <b>AUTORIZZAZIONEONLINE</b> - Richiesta di autorizzazione online.
     * <p>Il messaggio di richiesta di autorizzazione online permette di inoltrare ai circuiti richieste di autorizzazione.</p>
     */
    AUTORIZZAZIONE_ONLINE("AUTORIZZAZIONEONLINE"),

    /**
     * <b>AUTORIZZAZIONEDIFFERITA</b> - Richiesta di autorizzazione differita.
     * <p>Il messaggio di richiesta di autorizzazione differita permette di inoltrare ai circuiti richieste di autorizzazione.</p>
     */
    AUTORIZZAZIONE_DIFFERITA("AUTORIZZAZIONEDIFFERITA"),

    /**
     * <b>AUTORIZZAZIONEONLINEVBV</b> - Richiesta di autorizzazione online VBV.
     * <p>Il messaggio di richiesta di autorizzazione online permette di inoltrare ai circuiti richieste di autorizzazione.
     * Nel caso di carte Visa, Masterdard/Maestro o Amex VBV la richiesta può essere di tipo VBV.</p>
     */
    AUTORIZZAZIONE_ONLINE_VBV("AUTORIZZAZIONEONLINEVBV"),

    /**
     * <b>AUTORIZZAZIONEONLINEVBV2</b> - Richiesta di autorizzazione online VBV step 2.
     * <p>Il messaggio di richiesta di autorizzazione online VBV step 2 permette di inoltrare ai circuiti
     * richieste di autorizzazione VBV una volta ottenuta l’autenticazione dell’utente da parte del sito ACS
     * dell’issuer della carta.</p>
     * <p>
     * <p>Nota: <b>Il messaggio AUTORIZZAZIONEONLINEVBV2 deve arrivare entro 8 minuti da quando è stato inviato
     * il messaggio AUTORIZZAZIONEONLINEVBV originale.</b></p>
     */
    AUTORIZZAZIONE_ONLINE_VBV2("AUTORIZZAZIONEONLINEVBV2"),

    /**
     * <b>RICHIESTAAUTORIZZAZIONE</b> - Richiesta di conferma autorizzazione.
     * <p>Il messaggio di richiesta di autorizzazione permette di inoltrare ai circuiti richieste di autorizzazione
     * a conferma di pagamenti che erano stati effettuati con la modalità di autorizzazione differita.
     * Nel messaggio di richiesta occorre indicare se seguiranno nuove richieste, oppure se quella presentata conclude l'ordine.
     * Tramite questo messaggio è possibile effettuare richieste di autorizzazione fino ad un importo massimo
     * complessivo pari a quello originariamente specificato nella transazione di autorizzazione differita effettuata online dal cliente.</p>
     */
    RICHIESTA_AUTORIZZAZIONE("RICHIESTAAUTORIZZAZIONE"),

    /**
     * <b>CHIUSURADIFFERITA</b> - Chiusura autorizzazione differita.
     * <p>L'operazione di chiusura di una autorizzazione differita rende non più utilizzabile per ulteriori
     * autorizzazioni la transazione di autorizzazione differita indicata.
     * In definitiva comunica al sistema che l'ordine in questione è da considerarsi chiuso.</p>
     */
    CHIUSURA_DIFFERITA("CHIUSURADIFFERITA"),

    /**
     * <b>CONTABILIZZAZIONE</b> - Richiesta di contabilizzazione.
     * <p>L'operazione di richiesta di contabilizzazione fa si che il sistema @POS inoltri all'acquirer di competenza
     * la richiesta di contabilizzazione di una autorizzazione precedentemente concessa con contabilizzazione differita.
     * Le richieste contabili vengono mandate agli acquirer in modo batch durante le elaborazioni notturne.
     * Le richieste di contabilizzazioni per la giornata corrente sono inoltrabili fino alle ore 24:00.
     * Le richieste di contabilizzazione riguardano i pagamenti tramite carta di credito.</p>
     */
    CONTABILIZZAZIONE("CONTABILIZZAZIONE"),

    /**
     * <b>ANNULLAMENTOCONTABILIZZAZIONE</b> - Annullamento richiesta di contabilizzazione.
     * <p>L'operazione di annullamento di una richiesta di contabilizzazione può avvenire entro le ore 24:00
     * della giornata nella quale è stata inoltrata la richiesta in oggetto.
     * Questa operazione annulla la richiesta di contabilizzazione e rende l’autorizzazione nuovamente contabilizzabile.
     * Le richieste di annullamento contabilizzazione riguardano i pagamenti tramite carta di credito.</p>
     */
    ANNULLAMENTO_CONTABILIZZAZIONE("ANNULLAMENTOCONTABILIZZAZIONE"),

    /**
     * <b>STORNO</b> - Richiesta di storno di un pagamento.
     * <p>La richiesta di storno di un pagamento viene applicata dal sistema @POS ad una autorizzazione concessa.
     * Le transazioni che si nascondono dietro questa operazione sono differenti a seconda dello stato della autorizzazione in oggetto.
     * Se l'autorizzazione non è ancora stata contabilizzata avverrà una transazione di ripristino plafond;
     * se l'autorizzazione è stata contabilizzata nella giornata corrente, e non è quindi ancora stata inviata all'acquirer,
     * avverranno le transazioni di ripristino plafond ed annullamento contabilizzazione.
     * <p>Se l'autorizzazione è già stata contabilizzata dall'acquirer avverranno le operazioni di ripristino plafond e di credit del titolare.</p>
     * <p>Dopo uno storno parziale del pagamento saranno possibili solo ulteriori storni parziali fino al raggiungimento
     * del massimo importo stornabile.</p>
     * In questo caso si tratterà di storni multipli.
     * <p>Gli storni multipli non sono consentiti sui circuiti di debito (Pagobancomat).</p></p>
     */
    STORNO("STORNO"),

    /**
     * <b>SPLIT</b> - Richiesta di split (divisione e/o riduzione) ordine.
     * <p>L’operazione rende possibile lo split (divisione e/o riduzione) shipment per un ordine che era stato eseguito
     * con autorizzazione immediata:
     * annulla la autorizzazione immediata e piazza una nuova autorizzazione differita da confermare in pezzi.</p>
     */
    SPLIT("SPLIT"),

    // OPERAZIONI DI CONSULTAZIONE ----------------------------------//

    /**
     * <b>VERIFICA</b> - Richiesta verifica esito richiesta.
     * <p>Fornendo il numero identificativo della richiesta voluta, restituisce l’esito del messaggio precedentemente inoltrato.</p>
     */
    VERIFICA("VERIFICA"),

    /**
     * <b>ELENCOCONTABILE</b> - Elenco operazioni contabili.
     * <p>Questa operazione permette di ricavare l’elenco delle operazioni di carattere contabile.
     * Con tale termine si intendono le richieste di contabilizzazione e di credit inoltrate al sistema.
     * Vengono elencate sia quelle già inviate agli acquirer sia quelle ancora da inoltrare.
     * Queste ultime si distinguono per la data di elaborazione non valorizzata.</p>
     */
    ELENCO_CONTABILE("ELENCOCONTABILE"),

    /**
     * <b>ELENCOAUTORIZZAZIONI</b> - Elenco autorizzazioni.
     * <p>Questa operazione permette di ricavare l’elenco delle richieste di autorizzazione inoltrate dal sistema @POS
     * ai circuiti di pagamento internazionali o nazionali in un dato periodo.
     * E' possibile indicare se si desidera ottenere tutte le autorizzazioni, solo quelle autorizzate,
     * solo quelle negate, oppure solo quelle stornate.</p>
     */
    ELENCO_AUTORIZZAZIONI("ELENCOAUTORIZZAZIONI"),

    /**
     * <b>SITUAZIONEORDINE</b> - Richiesta situazione di un ordine.
     * <p>Questa operazione restituisce la situazione attuale di un ordine con tutte le operazioni di autorizzazione ad esso legate.
     * Lo scopo principale di questo messaggio è quello di rendere possibile ai merchant system la verifica
     * dello stato di eventuali ordini rimasti "pending" durante il pagamento.</p>
     */
    SITUAZIONE_ORDINE("SITUAZIONEORDINE"),

    /**
     * <b>RECUPERAALIASPAN</b> - Richiesta di recupero alias pan.
     * <p>Questa operazione restituisce l'alias pan generato dall'autorizzazione di un determinato ordine del negozio.</p>
     */
    RECUPERA_ALIAS_PAN("RECUPERAALIASPAN"),

    /**
     * Interfacciamento tra il negozio virtuale ed il sistema @POS avviene per mezzo di semplici messaggi http.
     * Una volta che l’utente finale ha terminato la fase di acquisto il negozio virtuale reindirizza il browser verso il sistema @POS
     */
    REDIRECT_AVVIO_PAGAMENTO("REDIRECT_AVVIO_PAGAMENTO");

    private final String name;

    SiaOperations(String name) {
        this.name = name;
    }

    public static SiaOperations valueOfByName(String name) {
        for (SiaOperations o : values()) {
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