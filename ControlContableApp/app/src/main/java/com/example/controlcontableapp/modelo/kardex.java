package com.example.controlcontableapp.modelo;

import java.util.Date;

public class kardex {
    private int id;
    private Date fecha;
    private int productos;
    private String descripcion;
    private String entradaRecibe;
    private String deptoAsignado;
    private int cantidad;
    private int saldo;
    private int factura;
    private int salida;

    public kardex(int id, Date fecha, int productos, String descripcion, String entradaRecibe, String deptoAsignado, int cantidad, int saldo, int factura, int salida) {
        this.id = id;
        this.fecha = fecha;
        this.productos = productos;
        this.descripcion = descripcion;
        this.entradaRecibe = entradaRecibe;
        this.deptoAsignado = deptoAsignado;
        this.cantidad = cantidad;
        this.saldo = saldo;
        this.factura = factura;
        this.salida = salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntradaRecibe() {
        return entradaRecibe;
    }

    public void setEntradaRecibe(String entradaRecibe) {
        this.entradaRecibe = entradaRecibe;
    }

    public String getDeptoAsignado() {
        return deptoAsignado;
    }

    public void setDeptoAsignado(String deptoAsignado) {
        this.deptoAsignado = deptoAsignado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }
}
