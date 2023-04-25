package com.example.controlcontableapp.modelo;

public class municipio {
    private int id;
    private char clave;
    private String valor;
    private int entidadFederativa;

    public municipio(int id, char clave, String valor, int entidadFederativa) {
        this.id = id;
        this.clave = clave;
        this.valor = valor;
        this.entidadFederativa = entidadFederativa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getClave() {
        return clave;
    }

    public void setClave(char clave) {
        this.clave = clave;
    }

    public String getValor() {
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
