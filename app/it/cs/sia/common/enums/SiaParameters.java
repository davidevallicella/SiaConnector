package it.cs.sia.common.enums;

import it.cs.sia.validation.*;

import static it.cs.sia.config.SiaConfig.Key.*;

/**
 * Created by Davide Vallicella on 17/05/2017.
 * <p>
 * <p>Elenco di tutti i possibili campi da specificare nei messaggi HTTP di richiesta e consultazione.</p>
 */
public enum SiaParameters implements SiaCommonInterface {

    /**
     * <ul>
     * <li>
     * Identificatore del negozio del merchant assegnato da SIA, Merchant ID (MID) per:
     * <ul>
     * <li>
     * Richiesta di autorizzazione online
     * </li>
     * <li>
     * Richiesta di autorizzazione differita
     * </li>
     * <li>
     * Richiesta di autorizzazione online VBV
     * </li>
     * <li>
     * Richiesta di autorizzazione online VBV step 2
     * </li>
     * <li>
     * Richiesta di conferma autorizzazione
     * </li>
     * <li>
     * Chiusura autorizzazione differita
     * </li>
     * <li>
     * Richiesta di contabilizzazione
     * </li>
     * <li>
     * Annullamento richiesta di contabilizzazione
     * </li>
     * <li>
     * Richiesta di storno di un pagamento
     * </li>
     * <li>
     * Richiesta di split (divisione e/o riduzione) ordine
     * </li>
     * <li>
     * Richiesta verifica esito richiesta
     * </li>
     * <li>
     * Elenco operazioni contabili
     * </li>
     * <li>
     * Elenco autorizzazioni
     * </li>
     * <li>
     * Richiesta situazione di un ordine
     * </li>
     * <li>
     * Richiesta di recupero alias pan
     * </li>
     * </ul>
     * </li>
     * <li>
     * Identificatore del negozio del merchant assegnato dalla BANCA, Codice Riconoscimento Negozio (CRN) per:
     * <ul>
     * <li>
     * Redirect di avvio pagamento @POS
     * </li>
     * <li>
     * Messaggio di conferma/esito dell’avvenuto pagamento
     * </li>
     * </ul>
     * </li>
     * </ul>
     */
    ID_NEGOZIO("IDNEGOZIO", new LengthValidation(ID_NEGOZIO_LENGTH)),

    /**
     * Operazione richiesta:
     * <p>
     * <ul>
     * <li>
     * <b>AUTORIZZAZIONEONLINE</b> - Richiesta di autorizzazione online.
     * <p>Il messaggio di richiesta di autorizzazione online permette di inoltrare ai circuiti richieste di autorizzazione.</p>
     * </li>
     * <p>
     * <li>
     * <b>AUTORIZZAZIONEDIFFERITA</b> - Richiesta di autorizzazione differita.
     * <p>Il messaggio di richiesta di autorizzazione differita permette di inoltrare ai circuiti richieste di autorizzazione.</p>
     * </li>
     * <p>
     * <li>
     * <b>AUTORIZZAZIONEONLINEVBV</b> - Richiesta di autorizzazione online VBV.
     * <p>Il messaggio di richiesta di autorizzazione online permette di inoltrare ai circuiti richieste di autorizzazione.
     * Nel caso di carte Visa, Masterdard/Maestro o Amex VBV la richiesta può essere di tipo VBV.</p>
     * </li>
     * <p>
     * <li>
     * <b>AUTORIZZAZIONEONLINEVBV2</b> - Richiesta di autorizzazione online VBV step 2.
     * <p>Il messaggio di richiesta di autorizzazione online VBV step 2 permette di inoltrare ai circuiti
     * richieste di autorizzazione VBV una volta ottenuta l’autenticazione dell’utente da parte del sito ACS
     * dell’issuer della carta.</p>
     * <p><b>Il messaggio AUTORIZZAZIONEONLINEVBV2 deve arrivare entro 8 minuti da quando è stato inviato
     * il messaggio AUTORIZZAZIONEONLINEVBV originale.</b></p>
     * </li>
     * <p>
     * <li>
     * <b>RICHIESTAAUTORIZZAZIONE</b> - Richiesta di conferma autorizzazione.
     * <p>Il messaggio di richiesta di autorizzazione permette di inoltrare ai circuiti richieste di autorizzazione
     * a conferma di pagamenti che erano stati effettuati con la modalità di autorizzazione differita.
     * Nel messaggio di richiesta occorre indicare se seguiranno nuove richieste, oppure se quella presentata conclude l'ordine.
     * Tramite questo messaggio è possibile effettuare richieste di autorizzazione fino ad un importo massimo
     * complessivo pari a quello originariamente specificato nella transazione di autorizzazione differita effettuata online dal cliente.</p>
     * </li>
     * <p>
     * <li>
     * <b>CHIUSURADIFFERITA</b> - Chiusura autorizzazione differita.
     * <p>L'operazione di chiusura di una autorizzazione differita rende non più utilizzabile per ulteriori
     * autorizzazioni la transazione di autorizzazione differita indicata.
     * In definitiva comunica al sistema che l'ordine in questione è da considerarsi chiuso.</p>
     * </li>
     * <p>
     * <li>
     * <b>CONTABILIZZAZIONE</b> - Richiesta di contabilizzazione.
     * <p>L'operazione di richiesta di contabilizzazione fa si che il sistema @POS inoltri all'acquirer di competenza
     * la richiesta di contabilizzazione di una autorizzazione precedentemente concessa con contabilizzazione differita.
     * Le richieste contabili vengono mandate agli acquirer in modo batch durante le elaborazioni notturne.
     * Le richieste di contabilizzazioni per la giornata corrente sono inoltrabili fino alle ore 24:00.
     * Le richieste di contabilizzazione riguardano i pagamenti tramite carta di credito.</p>
     * </li>
     * <p>
     * <li>
     * <b>ANNULLAMENTOCONTABILIZZAZIONE</b> - Annullamento richiesta di contabilizzazione.
     * <p>L'operazione di annullamento di una richiesta di contabilizzazione può avvenire entro le ore 24:00
     * della giornata nella quale è stata inoltrata la richiesta in oggetto.
     * Questa operazione annulla la richiesta di contabilizzazione e rende l’autorizzazione nuovamente contabilizzabile.
     * Le richieste di annullamento contabilizzazione riguardano i pagamenti tramite carta di credito.</p>
     * </li>
     * <p>
     * <li>
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
     * </li>
     * <p>
     * <li>
     * <b>SPLIT</b> - Richiesta di split (divisione e/o riduzione) ordine.
     * <p>L’operazione rende possibile lo split (divisione e/o riduzione) shipment per un ordine che era stato eseguito
     * con autorizzazione immediata:
     * annulla la autorizzazione immediata e piazza una nuova autorizzazione differita da confermare in pezzi.</p>
     * </li>
     * </ul>
     * <p>
     * Operazioni di consultazione:
     * <ul>
     * <li>
     * <b>VERIFICA</b> - Richiesta verifica esito richiesta.
     * <p>Fornendo il numero identificativo della richiesta voluta, restituisce l’esito del messaggio precedentemente inoltrato.</p>
     * </li>
     * <p>
     * <li>
     * <b>ELENCOCONTABILE</b> - Elenco operazioni contabili.
     * <p>Questa operazione permette di ricavare l’elenco delle operazioni di carattere contabile.
     * Con tale termine si intendono le richieste di contabilizzazione e di credit inoltrate al sistema.
     * Vengono elencate sia quelle già inviate agli acquirer sia quelle ancora da inoltrare.
     * Queste ultime si distinguono per la data di elaborazione non valorizzata.</p>
     * </li>
     * <p>
     * <li>
     * <b>ELENCOAUTORIZZAZIONI</b> - Elenco autorizzazioni.
     * <p>Questa operazione permette di ricavare l’elenco delle richieste di autorizzazione inoltrate dal sistema @POS
     * ai circuiti di pagamento internazionali o nazionali in un dato periodo.
     * E' possibile indicare se si desidera ottenere tutte le autorizzazioni, solo quelle autorizzate,
     * solo quelle negate, oppure solo quelle stornate.</p>
     * </li>
     * <p>
     * <li>
     * <b>SITUAZIONEORDINE</b> - Richiesta situazione di un ordine.
     * <p>Questa operazione restituisce la situazione attuale di un ordine con tutte le operazioni di autorizzazione ad esso legate.
     * Lo scopo principale di questo messaggio è quello di rendere possibile ai merchant system la verifica
     * dello stato di eventuali ordini rimasti "pending" durante il pagamento.</p>
     * </li>
     * <p>
     * <li>
     * <b>RECUPERAALIASPAN</b> - Richiesta di recupero alias pan.
     * <p>Questa operazione restituisce l'alias pan generato dall'autorizzazione di un determinato ordine del negozio.</p>
     * </li>
     * </ul>
     */
    OPERAZIONE("OPERAZIONE", new TypeValidation<SiaOperations>(SiaOperations.class)),

    /**
     * <p>Importo espresso nell’unità minima della valuta (centesimi di euro).</p>
     * <p>Lunghezza minima 2 massima 8.</p>
     * <p>L’importo minimo è 10 centesimi.</p>
     * <p>L’importo non deve essere preceduto da zeri.</p>
     */
    IMPORTO("IMPORTO", new RangeValidation(IMPORTO_MIN_VALUE, IMPORTO_MAX_VALUE)),

    /**
     * Valuta: codice ISO (EUR = 978)
     */
    VALUTA("VALUTA", new ListValidation<Integer>(Integer.class, VALUTA_CURRENCIES)),

    /**
     * <p>
     * Identificativo univoco dell’ordine: deve essere un codice alfa-numerico lungo al massimo 50 caratteri.
     * </p>
     * <p>
     * I caratteri ammessi sono lettere, cifre, “-“ e “_”. Viene applicata la regular expression [a-zA-Z0-9\-_]
     * </p>
     * <p>
     * <p>
     * Nota: <b>La sua univocità deve essere garantita per almeno 5 anni.</b>
     * </p>
     */
    NUM_ORD("NUMORD", new LengthValidation(NUMERO_ORDINE_MIN_LENGTH, NUMERO_ORDINE_MAX_LENGTH)),

    /**
     * Campo di firma della transazione.
     * <p>
     * La funzione di hash può essere scelta dall’esercente a piacere fra due algoritmi standard:
     * <ul>
     * <li>
     * SHA-1 (detto anche SHA)
     * </li>
     * <li>
     * MD5
     * </li>
     * </ul>
     * <p>
     * Dato che i due algoritmi producono un diverso numeri di bit (160 il primo, 128 il secondo)
     * il sistema è in grado di riconoscere automaticamente il tipo di funzione utilizzato per la generazione del MAC</p>
     * <p>
     * Nota:
     * <p>
     * <b>Il MAC, essendo il risultato di un hash, per essere trasmesso in HTTP deve essere codificato opportunamente.
     * A tale scopo si deve utilizzare una conversione in esadecimale.
     * <p>Il risultato di tale conversione e’ una stringa di 32 caratteri se la funzione di hash usata è MD5.
     * Se invece si è utilizzato SHA-1 il risultato sarà una stringa di 40 caratteri.</p></b>
     * </p>
     */
    MAC("MAC", new ListValidation<Integer>(Integer.class, MAC_LIST_LENGTH)),

    /**
     * <p>l campo OPTIONS permette di attivare varie opzioni aggiuntive per il pagamento in corso.</p>
     * <p>Le opzioni sono indicate tramite una lettera dell’alfabeto.</p>
     * <p>
     * Le opzioni oggi disponibili sono:
     * <ul>
     * <li>
     * <b>B</b> – Il sistema accetta due ulteriori campi nel messaggio in ingresso: NOME e COGNOME.
     * Il valore di tali campi, se presenti, viene memorizzato associato all’ordine in corso.
     * I campi non sono modificabili dal cliente e non sono visualizzati.
     * Per garantire la non modificabilità dei valori i campi entrano a par parte della stringa per il calcolo del MAC.
     * I campi NOME e COGNOME non sono comunque obbligatori.
     * </li>
     * <p>
     * <li>
     * <b>F</b> – Il sistema accetta la valorizzazione del campo COMMIS indicante l’importo della commissione sul servizio.
     * </li>
     * <p>
     * <li>
     * <b>G</b> – In caso di autorizzazione concessa il sistema invece di mostrare l’esito della transazione
     * al consumatore effettua la redirezione immediata presso URLDONE in modo che il negozio virtuale possa
     * mostrare un proprio “scontrino” personalizzato.
     * In caso di autorizzazione negata all’utente viene riproposta la schermata di inserimento carta.
     * </li>
     * <p>
     * <li>
     * <b>I</b> – Nel caso di autorizzazione concessa, il sistema aggiunge alle informazioni già presenti nell’URLMS
     * e nell’URLDONE anche il campo BPW_ISSUER_COUNTRY che contiene l’informazione della nazione di provenienza dell’issuer.
     * </li>
     * <p>
     * <li>
     * <b>L</b> – Nel caso di ordine duplicato il sistema invia una URLMS con codice di esito 07.
     * </li>
     * <p>
     * <li>
     * <b>M</b> – L’utilizzo della OPTION M è associata alla abilitazione al servizio di ALIAS PAN (a discrezione della banca aderente).
     * Nel caso di autorizzazione concessa viene generato un Alias Pan che viene restituito nella URLMS ed URLDONE nel campo ALIASPAN.
     * Per i dettagli relativi a tale funzionalità aggiuntiva fare riferimento al manuale specifico di integrazione.
     * </li>
     * <p>
     * <li>
     * <b>N</b> – In caso di autorizzazione negata il sistema, invece di mostrare l’esito della transazione al consumatore,
     * effettua la redirezione immediata verso URLDONE.
     * </li>
     * <p>
     * <li>
     * <b>O</b> – Richiede, nelle transazioni myBank, di inserire nel campo D13 (remittance information)
     * il valore del campo DESCRORD (descrizione ordine) invece del NUMORD (numero d'ordine), come da comportamento ordinario.
     * </li>
     * <p>
     * <li>
     * <b>P</b> – Viene restituito, in URLMS E URDONE, il campo RESPONSE_CODE_AUT che rappresenta il codice di risposta ritornato dal backend autorizzativo.
     * </li>
     * <p>
     * <li>
     * <b>Q</b> – per i pagamenti effettuati con Paypal il sistema aggiunge nelle URLMS e URLDONE anche le seguenti informazioni aggiuntive: PAYERID, PAYER e PAYERSTATUS.
     * </li>
     * <p>
     * <li>
     * <b>R</b> – Il MAC viene calcolato ed inviato negli URLMS e URLDONE anche in caso di esito negativo.
     * Le regole di maccatura sono le medesime adottate dallo scenario positivo.
     * </li>
     * </ul>
     */
    OPTIONS("OPTIONS", new TypeValidation<SiaOptions>(SiaOptions.class)),

    /**
     * <p>URL completa verso la quale eseguire una redirect per rimandare l’utente al negozio
     * (può comprendere tutti gli eventuali parametri da passare) nel caso di annullamento del processo di pagamento.</p>
     * <p>
     * Nota: Lunghezza massima 254 caratteri
     */
    URL_BACK("URLBACK", new LengthValidation(URL_BACK_MAX_LENGTH, LengthValidation.Operation.MIN)),

    /**
     * <p>
     * URL completa verso la quale redirigere il browser del cliente a transazione avvenuta con successo (può comprendere tutti gli eventuali parametri da passare).
     * Il sistema appende ad essa i parametri dell'esito.
     * </p>
     * <p>
     * Nota: Lunghezza massima 254 caratteri
     */
    URL_DONE("URLDONE", new LengthValidation(URL_DONE_MAX_LENGTH, LengthValidation.Operation.MIN)),

    /**
     * <p>
     * URL del merchant system verso la quale SIA effettua la GET o POST di conferma dell’avvenuto pagamento
     * (può contenere eventuali parametri impostati dal negozio).
     * Il sistema appende ad essa i parametri dell'esito.
     * </p>
     * <p>
     * Nota: Lunghezza massima 400 caratteri
     */
    URL_MS("URLMS", new LengthValidation(URL_MS_MAX_LENGTH, LengthValidation.Operation.MIN)),

    /**
     * Contabilizzazione delle transazioni effettuate
     * <p>
     * <ul>
     * <li>
     * <b>Contabilizzazione immediata - I</b>
     * <p>
     * La modalità di contabilizzazione immediata permette all’esercente di rendere automaticamente contabili
     * tutte le transazioni autorizzate.
     * Senza un suo intervento, la sera stessa del giorno in cui è avvenuta la transazione, il processor
     * di front end esegue il clearing in automatico del movimento per l’intero importo autorizzato.
     * Questa modalità può essere ad esempio utilizzata nel caso in cui si vendano beni/servizi immediatamente
     * fruibili da parte del compratore (software, musica, servizi online, etc.9).
     * </p>
     * </li>
     * <p>
     * <li>
     * <b>Contabilizzazione differita - D</b>
     * <p>
     * La modalità di contabilizzazione differita prevede che le operazioni autorizzate debbano essere
     * esplicitamente rese contabili dall’esercente.
     * Per eseguire l’operazione di contabilizzazione di un movimento l’esercente ha a disposizione un
     * predeterminato numero di giorni dal momento della autorizzazione.
     * <p>Questa modalità mette a disposizione dell’esercente le seguenti operazioni:</p>
     * <ul>
     * <li>
     * <b>totale</b>
     * <p>Un movimento viene reso contabile per l’intero ammontare della cifra autorizzata.</p>
     * </li>
     * <p>
     * <li>
     * <b>parziale</b>
     * <p>
     * Un movimento viene reso contabile per un ammontare inferiore alla cifra autorizzata;
     * una operazione di contabilizzazione parziale può far riferimento ad una autorizzazione
     * per la quale era già stata richiesta una contabilizzazione parziale (split shipment) a patto
     * che non sia scaduto il termine ultimo di contabilizzazione.
     * </p>
     * </li>
     * <p>
     * <li>
     * <b>annullamento</b>
     * <p>
     * Viene annullata una operazione di contabilizzazione eseguita durante la giornata, il movimento
     * è nuovamente contabilizzabile.
     * </p>
     * </li>
     * </ul>
     * </p>
     * </li>
     * </ul>
     */
    TIPO_CONTAB("TCONTAB", new TypeValidation<SiaType>(SiaType.class)),

    /**
     * Consente di specificare il tipo di Autorizzazione che dovrà essere utilizzata sulle transazioni effettuate.
     * <p>
     * <ul>
     * <li>
     * <b>Autorizzazione immediata - I</b>
     * <p>
     * La modalità di autorizzazione immediata prevede che durante la fase di pagamento online venga
     * immediatamente inviata la richiesta di autorizzazione ai circuiti internazionali.
     * Una volta conclusa la transazione in modo positivo l’esercente ha la certezza che quanto dovuto
     * dal cliente è stato “prenotato” dal suo plafond.
     * </p>
     * </li>
     * <p>
     * <li>
     * <b>Autorizzazione differita - D</b>
     * <p>
     * La modalità di autorizzazione differita prevede che durante la fase di pagamento online le transazioni
     * siano prese in carico ma non inoltrate ai circuiti (viene comunque effettuato un controllo della validità
     * della carta presso l’issuer).
     * L’esercente che utilizza questa modalità di accettazione dei pagamenti è in grado, in un secondo tempo,
     * di far elaborare le richieste di autorizzazione pendenti che lo riguardano.
     * Le richieste di autorizzazione differita possono pervenire a PIB per un importo inferiore a quello originale;
     * l’esercente può inoltrare una serie di autorizzazioni differite fino a coprire il totale originale.
     * </p>
     * </li>
     * </ul>
     */
    TIPO_AUTOR("TAUTOR", new TypeValidation<SiaType>(SiaType.class)),

    /**
     * Lingua nella quale devono essere mostrati i messaggi di interazione con l’utente finale.
     * <p>
     * <p>Il campo è facoltativo; di default la lingua è quella Italiana.</p>
     */
    LINGUA("LINGUA", new ListValidation(LINGUA_LIST)),

    /**
     * Contiene l'indirizzo e-mail al quale inviare l'esito della transazione.
     * <p>
     * <p>
     * Se non è presente viene utilizzato quello disponibile nella anagrafica SIA del negozio.
     * Lunghezza minima 7 caratteri alfanumerici massima 50.
     * </p>
     */
    EMAIL_ESERC("EMAILESERC", new LengthValidation(EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH)),

    /**
     * Contiene il codice circuito corrispondente al tipo di strumento di pagamento con cui l’esercente desidera che venga effettuato il pagamento.
     * <p>
     * <p>I valori possibili per questo parametro sono:</p>
     * <ol style="margin-bottom: 0px;">
     * <li><p>Visa</p></li>
     * <li><p>Mastercard</p></li>
     * </ol>
     * <ol start="4" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>Maestro</p></li>
     * <li><p>Cirrus</p></li>
     * <li><p>American Express</p></li>
     * <li><p>Diners</p></li>
     * <li><p>JCB</p></li>
     * </ol>
     * <ol start="10" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>Aura</p></li>
     * </ol>
     * <ol start="49" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>Paypass</p></li>
     * </ol>
     * <ol start="94" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>Postepay</p></li>
     * </ol>
     * <ol start="96" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>MyBank</p></li>
     * <li><p>Paypal</p></li>
     * </ol>
     * <ol start="81" type="A" style="margin-top: 0px; margin-bottom: 0px;">
     * <li><p>Carte di credito</p></li>
     * </ol>
     * <ol start="367" type="A" style="margin-top: 0px;">
     * <li><p>Altri strumenti di pagamento</p></li>
     * </ol>
     * <p>
     * Se viene indicato come strumento predefinito una carta di credito l’utente verrà inviato alla pagina di scelta
     * dello strumento di pagamento con il campo circuito preselezionato e non modificabile.
     * </p>
     * <p>
     * Per i circuiti 49 - Paypass e 97 – Paypal l’utente verrà rediretto automaticamente alla pagina di login del relativo
     * strumento di pagamento, senza che venga visualizzata la pagina di scelta dello strumento.
     * </p>
     * <p>
     * Per il circuito 96 – MyBank l’utente verrà inviato alla pagina di scelta della propria banca, senza che venga
     * visualizzata la pagina di scelta dello strumento.
     * </p>
     * <p>
     * Indicando il circuito CC la pagina di scelta dello strumento di pagamento conterrà e permetterà di scegliere solo le carte di credito.
     * </p>
     * <p>
     * Indicando il circuito NC la pagina di scelta dello strumento di pagamento conterrà e permetterà di selezionare solo i circuiti diversi da carte di credito.
     * </p>
     * <p>
     * Se il campo è valorizzato con NC e si verifica un errore durante il processo di pagamento l’utente viene inviato alla pagina URLBACK.
     * </p>
     */
    LOCK_CARD("LOCKCARD", new TypeValidation<SiaLockcard>(SiaLockcard.class)),

    /**
     * Importo della commissione sul servizio espresso nell’unità minima della valuta (centesimi di euro).
     * <p>
     * <p>
     * Si tenga presente che il parametro IMPORTO è comprensivo della commissione.
     * </p>
     * <p>
     * <p>
     * Nota: il parametro COMMIS, se presente, è significativo se e solo se è stata impostata anche l’opzione aggiuntiva
     * OPTIONS = F (pagamento con commissione su servizio).
     * </p>
     */
    COMMIS("COMMIS", new LengthValidation(COMMIS_MIN_LENGTH, COMMIS_MAX_LENGTH)),

    /**
     * Indirizzo di e-mail del cliente.
     * <p>
     * <p>
     * Se il campo non è presente verrà richiesto all’utente insieme ai dati della carta di credito.
     * Lunghezza minima 7 caratteri alfanumerici massima 50.
     * </p>
     */
    EMAIL("EMAIL", new LengthValidation(EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH)),

    /**
     * Descrizione ordine (vedere OPTIONS O).
     * <p>
     * <p>Lunghezza massima 140.</p>
     */
    DESCR_ORD("DESCRORD", new LengthValidation(DESC_ORDINE_LENGTH)),

    /**
     * Identificativo validation service per transazioni mybank.
     * <p>
     * <p>
     * Se presente fa saltare la pagina di scelta della banca mybank redirigendo l'utente sulla home banking associata all'identificativo ricevuto.
     * Lunghezza massima 35.
     * </p>
     */
    ID_VS("IDVS", new LengthValidation(ID_VS_LENGTH)),

    /**
     * Descrizione aggiuntiva dell'operazione di contabilizzazione, a discrezione dell'esercente (solo per contabilizzazione immediata).
     * <p>
     * <p>Lunghezza massima 100.</p>
     */
    DESCR_OP("DESCROP", new LengthValidation(DESC_OPERAZIONE_LENGTH)),

    /**
     * Timestamp locale del tipo yyyy-MM-ddTHH:mm:ss.SSS
     */
    TIMESTAMP("TIMESTAMP", new DateValidation(TIMESTAMP_PATTERN)),

    /**
     * Identificatore univoco dell’ordine.
     */
    ID_ORDINE("IDORDINE", new LengthValidation(ID_ORDINE_MIN_LENGTH, ID_ORDINE_MAX_LENGTH)),

    /**
     * Indica chi ha richiesto l’operazione.
     * <p>
     * <p>Deve essere passata la User ID di un operatore valido.</p>
     */
    ID_OPERATORE("IDOPERATORE", new LengthValidation(ID_ORDINE_MIN_LENGTH, ID_ORDINE_MAX_LENGTH)),

    OPERATORE("OPERATORE", new LengthValidation(ID_ORDINE_MIN_LENGTH, ID_ORDINE_MAX_LENGTH)),

    /**
     * Identificatore univoco della richiesta gestito dall’esercente.
     * <p>
     * <p>
     * Può essere usato per il recupero delle informazioni in merito alla richiesta fatta anche nel caso di mancata risposta.
     * I primi 8 caratteri devono avere il formato yyyyMMdd con la data della richiesta.
     * </p>
     */
    REQ_REF_NUM("REQREFNUM", new BaseValidation() {

        @Override
        public boolean isValid(Object value) {
            return DateValidation.validate(value.toString().substring(0, 8), "yyyyMMdd") &&
                    new LengthValidation(REQREFNUM_LENGTH).isValid(value);
        }
    }),

    /**
     * Numero carta di credito. (Acr. di Primary Account Number)
     * <p>
     * <p>È il numero identificativo di una carta di debito (p.e. il Bancomat) e di una carta di credito associato a queste fin dall’emissione.</p>
     */
    PAN("PAN", new LengthValidation(PAN_MIN_LENGTH, PAN_MAX_LENGTH)),

    /**
     * Stringa numerica di lunghezza 19
     */
    ALIAS_PAN("ALIASPAN"),

    /**
     * Data scadenza. Stringa numerica di lunghezza 4, in formato AAMM.
     */
    ALIAS_PAN_DATA_SCADENZA("ALIASPANDATASCAD"),

    /**
     * Ultime 4 cifre del PAN.
     */
    ALIAS_PAN_TAIL("ALIASPANTAIL"),

    /**
     * Costante per redirect
     */
    PAGE("PAGE", new ListValidation<String>(PAGE_LIST)),

    /**
     * Il campo OPTIONS permette di attivare varie opzioni aggiuntive per il pagamento in corso. Le opzioni sono indicate
     * tramite una lettera dell’alfabeto.
     * Se valorizzato con il valore B, il sistema accetta due ulteriori campi nel messaggio in ingresso: NOME e COGNOME. Il valore di tali
     * campi, se presenti, viene memorizzato associato all’ordine in corso. I campi non sono modificabili dal cliente e
     * non sono visualizzati. Per garantire la non modificabilità dei valori i campi entrano a par parte della stringa per
     * il calcolo del MAC. I campi NOME e COGNOME non sono comunque obbligatori.
     */
    NOME("NOME", new RangeValidation(NOME_MIN_LENGTH, NOME_MAX_LENGTH)),

    /**
     * Il campo OPTIONS permette di attivare varie opzioni aggiuntive per il pagamento in corso. Le opzioni sono indicate
     * tramite una lettera dell’alfabeto.
     * Se valorizzato con il valore B, il sistema accetta due ulteriori campi nel messaggio in ingresso: NOME e COGNOME. Il valore di tali
     * campi, se presenti, viene memorizzato associato all’ordine in corso. I campi non sono modificabili dal cliente e
     * non sono visualizzati. Per garantire la non modificabilità dei valori i campi entrano a par parte della stringa per
     * il calcolo del MAC. I campi NOME e COGNOME non sono comunque obbligatori.
     */
    COGNOME("COGNOME", new RangeValidation(COGNOME_MIN_LENGTH, COGNOME_MAX_LENGTH)),


    /**
     * Codice di sicurezza. (Acr. di Card Verification Value 2)
     * <p>
     * <p>
     * Per le carte di credito Mastercard e Visa il codice CVV2 (Card Verification Value) o CVC2 (Card Validation Code),
     * costituito da 3 cifre, è posizionato sul retro della carta di credito, dopo i numeri che identificano la carta stessa.
     * Per le carte di credito American Express il numero di verifica è composto da 4 cifre e si trova nella parte
     * anteriore della carta di credito, al di sopra del numero.
     * </p>
     * <p>
     * <ul>
     * <li>
     * Carte di credito del circuito Visa, Mastercard e Discover
     * <p>
     * il codice è CVC2 o CVV2, è composto da 3 cifre e si trova subito sopra il riquadro della firma.
     * </p>
     * </li>
     * <p>
     * <li>
     * Carte di credito del circuito American Express
     * <p>
     * il codice di sicurezza CID è composto da 4 cifre ed è stampato sul fronte della carta sopra il numero della stessa.
     * </p>
     * </li>
     * </ul>
     */
    CVV2("CVV2", new RangeValidation(CVV2_MIN_LENGTH, CVV2_MIN_LENGTH)),

    /**
     * Data di scadenza della carta – MMyy -
     */
    DATA_SCAD("DATASCAD", new DateValidation(DATA_SCADENZA_PATTERN)),

    /**
     * Il circuito di autorizzazione della carta (ad es: 01 per VISA).
     * <p>
     * <p>
     * Nel caso in cui il merchant non fosse in possesso del codice circuito è possibile delegare al sistema ATPOS
     * il calcolo dello stesso semplicemente impostando come CODICECIRCUITO il valore 93.
     * </p>
     */
    CODICE_CIRCUITO("CODICECIRCUITO", new LengthValidation(CODICE_CIRCUITO_MAX_LENGTH)),

    /**
     * Identificativo della transazione di autorizzazione differita effettuata online dal cliente.
     */
    ID_TRANSAZIONE("IDTRANS", new LengthValidation(ID_TRANSAZIONE_LENGTH)),

    /**
     * E-mail del titolare della carta (opzionale).
     */
    EMAIL_TIT("EMAILTIT", new RangeValidation(EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH)),

    /**
     * Identificativo del titolare.
     */
    USER_ID("USERID", new RangeValidation(USER_ID_MIN_LENGTH, USER_ID_MAX_LENGTH)),

    /**
     * Codice dell’acquirer con cui si vuole effettuare la transazione.
     */
    ACQUIRER("ACQUIRER", new LengthValidation(ACQUIRER_LENGTH)),

    /**
     * Indirizzo IP associato alla richiesta.
     */
    IP_ADDRESS("IPADDRESS", new Ipv4Validation()),

    ESITO("ESITO"),

    /**
     * Numero autorizzazione: identificativo della autorizzazione assegnato dall’emittente della carta (solo in caso di esito positivo).
     * Se l’autorizzazione non è stata concessa, il campo è valorizzato con “NULL”.
     * E’ una stringa di lunghezza massima 6 caratteri per tutti i circuiti escluso MyBank per il quale invece
     * ha lunghezza fissa di 35 caratteri e contiene l’identificativo della transazione assegnato dal Validation Service.
     * Non è significativo nel caso di transazione effettuata con circuito Paypal.
     */
    AUT("AUT"),

    CARTA("CARTA"),

    /**
     * Release delle API: da valorizzare con “02”
     */
    RELEASE("RELEASE", new LengthValidation(RELEASE_LENGTH));

    private final String name;

    private SiaValidationStrategy validator;

    SiaParameters(String name) {
        this(name, new BaseValidation() {
            @Override
            public boolean isValid(Object value) {
                return true;
            }
        });
    }

    SiaParameters(String name, SiaValidationStrategy validator) {
        this.name = name;
        this.validator = validator;
    }

    public static SiaParameters valueOfByName(String name) {
        for (SiaParameters o : values()) {
            if (o.equalsName(name)) {
                return o;
            }
        }

        return null;
    }

    public boolean validate(Object value) {
        return validator.isValid(value);
    }

    public SiaValidationStrategy getValidator() {
        return validator;
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