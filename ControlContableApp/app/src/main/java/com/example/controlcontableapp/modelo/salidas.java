package com.example.controlcontableapp.modelo;

import java.util.Date;

public class salidas {
    private int id;
    private Date fecha;
    private String producto;
    private int departamento;

    public salidas(int id, Date fecha, String producto, int departamento) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.departamento = departamento;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
}
