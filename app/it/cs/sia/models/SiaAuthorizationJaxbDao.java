package it.cs.sia.models;

import it.cs.sia.adapter.DateAdapter;
import it.cs.sia.adapter.SiaLockcardAdapter;
import it.cs.sia.adapter.SiaTypeAdapter;
import it.cs.sia.common.enums.SiaLockcard;
import it.cs.sia.common.enums.SiaType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by Davide Vallicella on 27/06/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SiaAuthorizationJaxbDao {

    @XmlElement(name = "TipoPag")
    private String tipoPagamento;

    @XmlElement(name = "Tautor")
    @XmlJavaTypeAdapter(SiaTypeAdapter.class)
    private SiaType tipoAutorizzazione;

    @XmlElement(name = "IDtrans")
    private String idTransazione;

    @XmlElement(name = "Circuito")
    @XmlJavaTypeAdapter(SiaLockcardAdapter.class)
    private SiaLockcard circuito;

    @XmlElement(name = "NumOrdine")
    private String numeroOrdine;

    @XmlElement(name = "ImportoTrans")
    private String importoTransazione;

    @XmlElement(name = "ImportoAutor")
    private String importoAutorizzazione;

    @XmlElement(name = "Valuta")
    private String valuta;

    @XmlElement(name = "ImportoContab")
    private String importoContabilizzato;

    @XmlElement(name = "ImportoStornato")
    private String importoStornato;

    @XmlElement(name = "EsitoTrans")
    private String esitoTransazione;

    @XmlElement(name = "Timestamp")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date timestamp;

    @XmlElement(name = "NumAut")
    private String numeroAutenticazione;

    @XmlElement(name = "AcqBIN")
    private String acqBIN;

    @XmlElement(name = "CodiceEsercente")
    private String codiceEsercente;

    @XmlElement(name = "Stato")
    private String stato;

    @XmlElement(name = "MAC")
    private String mac;

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public SiaType getTipoAutorizzazione() {
        return tipoAutorizzazione;
    }

    public void setTipoAutorizzazione(SiaType tipoAutorizzazione) {
        this.tipoAutorizzazione = tipoAutorizzazione;
    }

    public String getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(String idTransazione) {
        this.idTransazione = idTransazione;
    }

    public SiaLockcard getCircuito() {
        return circuito;
    }

    public void setCircuito(SiaLockcard circuito) {
        this.circuito = circuito;
    }

    public String getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(String numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public String getImportoTransazione() {
        return importoTransazione;
    }

    public void setImportoTransazione(String importoTransazione) {
        this.importoTransazione = importoTransazione;
    }

    public String getImportoAutorizzazione() {
        return importoAutorizzazione;
    }

    public void setImportoAutorizzazione(String importoAutorizzazione) {
        this.importoAutorizzazione = importoAutorizzazione;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getImportoContabilizzato() {
        return importoContabilizzato;
    }

    public void setImportoContabilizzato(String importoContabilizzato) {
        this.importoContabilizzato = importoContabilizzato;
    }

    public String getImportoStornato() {
        return importoStornato;
    }

    public void setImportoStornato(String importoStornato) {
        this.importoStornato = importoStornato;
    }

    public String getEsitoTransazione() {
        return esitoTransazione;
    }

    public void setEsitoTransazione(String esitoTransazione) {
        this.esitoTransazione = esitoTransazione;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNumeroAutenticazione() {
        return numeroAutenticazione;
    }

    public void setNumeroAutenticazione(String numeroAutenticazione) {
        this.numeroAutenticazione = numeroAutenticazione;
    }

    public String getAcqBIN() {
        return acqBIN;
    }

    public void setAcqBIN(String acqBIN) {
        this.acqBIN = acqBIN;
    }

    public String getCodiceEsercente() {
        return codiceEsercente;
    }

    public void setCodiceEsercente(String codiceEsercente) {
        this.codiceEsercente = codiceEsercente;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
