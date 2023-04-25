package com.example.controlcontableapp.modelo;

public class entidadFederativa {
    private int id;
    private char clave;
    private String valor;

    public entidadFederativa(int id, char clave, String valor) {
        this.id = id;
        this.clave = clave;
        this.valor = valor;
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
}
