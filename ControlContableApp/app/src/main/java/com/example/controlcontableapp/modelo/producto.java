package com.example.controlcontableapp.modelo;
import java.util.Date;

public class producto {
    private int id;
    private int factura;
    private String producto;
    private int categoria;
    private String marca;
    private int cantidad;
    private int undadMedida;
    private float precioUnitario;


    public producto(int id, int factura, String producto, int categoria, String marca, int cantidad, int undadMedida, float precioUnitario) {
        this.id = id;
        this.factura = factura;
        this.producto = producto;
        this.categoria = categoria;
        this.marca = marca;
        this.cantidad = cantidad;
        this.undadMedida = undadMedida;
        this.precioUnitario = precioUnitario;
    }

    //private date



    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUndadMedida() {
        return undadMedida;
    }

    public void setUndadMedida(int undadMedida) {
        this.undadMedida = undadMedida;
    }

}
