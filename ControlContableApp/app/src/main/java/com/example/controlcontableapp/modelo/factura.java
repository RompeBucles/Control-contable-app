package com.example.controlcontableapp.modelo;
import java.util.Date;

public class factura {
    private int id;
    private String numeroFactura;
    private int proveedor;
    private String folioFiscal;
    private Date fechaEmision;
    private String certificadoSat;
    private String noCertificado;
    private String tipoComprobante;
    private String metodoPago;
    private String formaPago;
    private String moneda;
    private float total;


    public factura(int id, String numeroFactura, int proveedor, String folioFiscal, Date fechaEmision, String certificadoSat, String noCertificado, String tipoComprobante, String metodoPago, String formaPago, String moneda, float total) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.proveedor = proveedor;
        this.folioFiscal = folioFiscal;
        this.fechaEmision = fechaEmision;
        this.certificadoSat = certificadoSat;
        this.noCertificado = noCertificado;
        this.tipoComprobante = tipoComprobante;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.moneda = moneda;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getFolioFiscal() {
        return folioFiscal;
    }

    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getCertificadoSat() {
        return certificadoSat;
    }

    public void setCertificadoSat(String certificadoSat) {
        this.certificadoSat = certificadoSat;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
