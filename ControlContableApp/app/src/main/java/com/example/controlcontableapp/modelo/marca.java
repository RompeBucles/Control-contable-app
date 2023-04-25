package com.example.controlcontableapp.modelo;

public class marca {
    private int id;
    private char categoria;
    private String valor;

    public marca(int id, char categoria, String valor) {
        this.id = id;
        this.categoria = categoria;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char clave) {
        this.categoria = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
