package com.example.controlcontableapp.modelo;

public class municipio {
    private int id;
    private String clave;
    private String valor;
    private int entidadFederativa;

    public municipio(int id, String clave, String valor, int entidadFederativa) {
        this.id = id;
        this.clave = clave;
        this.valor = valor;
        this.entidadFederativa = entidadFederativa;
    }

    public municipio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String toString() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(int entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }
}