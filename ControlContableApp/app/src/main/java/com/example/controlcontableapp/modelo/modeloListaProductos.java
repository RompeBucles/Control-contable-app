package com.example.controlcontableapp.modelo;

public class modeloListaProductos {

    private String producto;
    private String numeroFactura;
    private int cantidad;
    private String valor;
    private String fechaEmision;


    public String getProducto(){return producto;}

    public void setProducto(String producto){this.producto = producto;}

    public String getNumeroFactura(){return numeroFactura;}

    public void setNumeroFactura(String numeroFactura) {this.numeroFactura = numeroFactura;}

    public int getCantidad(){return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public String getValor(){return valor;}

    public void setValor(String valor) {this.valor = valor;}

    public String getFechaEmision(){return fechaEmision;}

    public void setFechaEmision(String fechaEmision) {this.fechaEmision = fechaEmision;}



}
