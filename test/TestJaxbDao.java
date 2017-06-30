import it.cs.sia.common.enums.SiaLockcard;
import it.cs.sia.common.enums.SiaType;
import it.cs.sia.http.SiaRichiestaAutorizzazioneOnline;
import it.cs.sia.models.SiaRispostaAutorizzazioneOnlineJaxbDao;
import play.Logger;

import java.util.Date;

import static it.cs.sia.common.enums.SiaParameters.*;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
public class TestJaxbDao {

    private final long SID = 14801;

    private static String merchantId;
    private static String apiUrl;
    private static String errorUrl;
    private static String successUrl;
    private static String returnUrl;
    private static String startKey;

    TestJaxbDao() {
        init();
    }

    public void init() {
        this.merchantId = "129284530900002";
        this.apiUrl = "https://atpostest.ssb.it/atpos/apibo/apiBO.app?";
        this.errorUrl = "http://err.it";
        this.returnUrl = "http://return.it";
        this.successUrl = "http://done.it";
        this.startKey = "G7T2L-Hp-KV2ALKmTJ-jE8h4mm8e-RzKZ-jm-Rvbaqa-Uuw-6f-XRfFf9Hs5J-NuYQwFsU--5ssGX9f-LB--BUnLPDuGhQvgZ--9";
    }

    public static void main(String args[]) throws Exception {
       /* FileInputStream is = new FileInputStream("test/test.xml");
        SiaRispostaAutorizzazioneOnlineJaxbDao response = SiaRispostaAutorizzazioneOnlineJaxbDao.load(is);

        Logger.info("Timestamp:\t%s", response.getTimestamp());
        Logger.info("MAC:\t%s", response.getMac());
        Logger.info("Esito:\t%s", response.getEsito());*/
        SiaRichiestaAutorizzazioneOnline request;


        request = new SiaRichiestaAutorizzazioneOnline(startKey);

        request.add(ID_NEGOZIO, merchantId)
                .add(ID_ORDINE, "")
                .add(REQ_REF_NUM, "2017062900000000000" + new Date().getTime())
                .add(PAN, "4922950260000040")
                .add(DATA_SCAD, "1812")
                .add(IMPORTO, 100)
                .add(VALUTA, 978)
                .add(TIPO_CONTAB, SiaType.I)
                .add(CODICE_CIRCUITO, SiaLockcard.VISA);

        //request.validate();

        Logger.info("URL:\t%s", SiaRispostaAutorizzazioneOnlineJaxbDao.load(request.get(apiUrl).getStream()));
    }
}
