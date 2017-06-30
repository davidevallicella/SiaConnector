
@POS è un gateway virtuale che permette di accettare e gestire in modo facile e sicuro i pagamenti effettuati  
su reti aperte per soddisfare le esigenze multicanale di aziende e banche.
 
La soluzione consente di accettare tutte le principali carte di pagamento 
(VISA, Mastercard, Maestro, American Express, Diners e JCB, Aura) secondo gli standard di sicurezza richiesti.
La soluzione è inoltre integrata con altri servizi di pagamento quali PayPal, Masterpass e MyBank.
 
L’applicazione è altresi dotata di un servizio di tokenizzazione carte di credito al fine di gestire i pagamenti ricorrenti
senza essere a conoscenza del numero di carta di credito.

@POS funziona con collegamento tramite redirect, API e web services.

Gli ordini sono gestiti tramite interfaccia web o applicazione.

Nella soluzione prospettata e condivisa con il cliente, viene prevista la seguente operatività sul servizio.
Cattolica Assicurazioni (identificata con Codice SIA da confermare) viene definita come Esercente sul
servizio @Pos e ad esso vengono associati tre differenti negozi per le richieste di pagamento prima
polizza:

- Cattolica Assicurazioni
- BCC Assicurazioni
- ABC Assicurazioni

Ai suddetti negozi si prevede di associare altrettanti negozi per l’innesco dei pagamenti successivi tramite
l’utilizzo del codice AliasPan precedentemente generato.
Le richieste di autorizzazione, in base alla tipologia di pagamento che si sta effettuando, devono
avvenire:

- In modalità redirect con protocollo 3DS e inserimento obbligatorio del valore CVV2/CVC2 per il
pagamento effettuato direttamente dal titolare carta sulla pagina di pagamento @Pos;
- In modalità redirect per i pagamenti su circuito Paypal;
- In modalità API, con protocollo Mo.to e utilizzo del codice Alias Pan, e senza inserimento del
valore CVV2/CVC2, per i pagamenti “rateali” richiesti ditettamente dal Merchant.

In entrambi i casi, le richieste devono prevedere:
- Il parametro di Autorizzazione (A) e il parametro di Contabilizzazione (C) entrambi impostati in
maniera Immediata (I)
- Il campo Numero Ordine si consiglia valorizzato con il numero polizza o un dato che permetta di
associare la successiva posizione al codice Alias Pan creato. La gestione da parte del cliente del
parametro URLMS in cui viene restituito il valore dell’ALIAS PAN sostitutivo del numero carta che
il cliente deve salvare sulla propria base dati, insieme alla scadenza carta, per l’eventuale
successivo utilizzo nei pagamenti recurring.