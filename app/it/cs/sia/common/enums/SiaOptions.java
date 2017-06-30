package it.cs.sia.common.enums;

/**
 * Created by Davide Vallicella on 15/06/2017.
 * <p>
 * <p>
 * Il campo OPTIONS permette di attivare varie opzioni aggiuntive per il pagamento in corso.
 * Le opzioni sono indicate tramite una lettera dell�alfabeto.
 * </P>
 */
public enum SiaOptions implements SiaCommonInterface {

    /**
     * Il sistema accetta due ulteriori campi nel messaggio in ingresso: NOME e COGNOME.
     * Il valore di tali campi, se presenti, viene memorizzato associato all�ordine in corso.
     * I campi non sono modificabili dal cliente e non sono visualizzati.
     * Per garantire la non modificabilit� dei valori i campi entrano a par parte della stringa per il calcolo del MAC.
     * I campi NOME e COGNOME non sono comunque obbligatori.
     */
    B("B"),

    /**
     * Il sistema accetta la valorizzazione del campo COMMIS indicante l�importo della commissione sul servizio.
     */
    F("F"),

    /**
     * In caso di autorizzazione concessa il sistema invece di mostrare l�esito della transazione al consumatore effettua
     * la redirezione immediata presso URLDONE in modo che il negozio virtuale possa mostrare un proprio �scontrino� personalizzato.
     * In caso di autorizzazione negata all�utente viene riproposta la schermata di inserimento carta.
     */
    G("G"),

    /**
     * Nel caso di autorizzazione concessa, il sistema aggiunge alle informazioni gi� presenti nell�URLMS e nell�URLDONE
     * anche il campo BPW_ISSUER_COUNTRY che contiene l�informazione della nazione di provenienza dell�issuer.
     */
    I("I"),

    /**
     * Nel caso di ordine duplicato il sistema invia una URLMS con codice di esito 07.
     */
    L("L"),

    /**
     * L�utilizzo della OPTION M � associata alla abilitazione al servizio di ALIAS PAN (a discrezione della banca aderente).
     * Nel caso di autorizzazione concessa viene generato un Alias Pan che viene restituito nella URLMS ed URLDONE nel campo ALIASPAN.
     * Per i dettagli relativi a tale funzionalit� aggiuntiva fare riferimento al manuale specifico di integrazione.
     */
    M("M"),

    /**
     * In caso di autorizzazione negata il sistema, invece di mostrare l�esito della transazione al consumatore,
     * effettua la redirezione immediata verso URLDONE.
     */
    N("N"),

    /**
     * Richiede, nelle transazioni myBank, di inserire nel campo D13 (remittance information) il valore del campo
     * DESCRORD (descrizione ordine) invece del NUMORD (numero d'ordine), come da comportamento ordinario.
     */
    O("O"),

    /**
     * Viene restituito, in URLMS E URDONE, il campo RESPONSE_CODE_AUT che rappresenta il codice di risposta ritornato dal backend autorizzativo.
     */
    P("P"),

    /**
     * Per i pagamenti effettuati con Paypal il sistema aggiunge nelle URLMS e URLDONE anche le seguenti informazioni aggiuntive: PAYERID, PAYER e PAYERSTATUS.
     */
    Q("Q"),

    /**
     * Il MAC viene calcolato ed inviato negli URLMS e URLDONE anche in caso di esito negativo.
     * Le regole di maccatura sono le medesime adottate dallo scenario positivo.
     */
    R("R");

    private final String name;

    SiaOptions(String name) {
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