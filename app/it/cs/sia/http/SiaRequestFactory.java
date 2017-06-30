package it.cs.sia.http;


import it.cs.sia.common.enums.SiaOperations;

/**
 * Created by Davide Vallicella on 17/05/2017.
 */
public class SiaRequestFactory {

    public static SiaBaseRequest buildBaseSiaRequest(SiaOperations operazione, String startKey) {
        switch (operazione) {
            case AUTORIZZAZIONE_ONLINE:
                return new SiaRichiestaAutorizzazioneOnline(startKey);
            case REDIRECT_AVVIO_PAGAMENTO:
                return new SiaRichiestaAvvioPagamentoRedirect(startKey);
            case RECUPERA_ALIAS_PAN:
                return new SiaRichiestaRecuperoAliasPAN(startKey);
        }

        return null;
    }
}
