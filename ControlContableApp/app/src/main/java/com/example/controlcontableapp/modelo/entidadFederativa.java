package com.example.controlcontableapp.modelo;

public class entidadFederativa {
    private int id;
    private String clave;
    private String valor;

    public entidadFederativa(int id, String clave, String valor) {
        this.id = id;
        this.clave = clave;
        this.valor = valor;
    }

    public entidadFederativa() {
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
}
