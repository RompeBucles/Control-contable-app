package com.example.controlcontableapp.modelo;

public class listaProveedor {
    private int id;
    private int idProveedor;
    private String nombre;
    private String rfc;
    private String actEconomica;
    private String registroSefiplan;

    public listaProveedor(){

    }

    public listaProveedor(int id, int idProveedor, String nombre, String rfc, String actEconomica, String registroSefiplan) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.rfc = rfc;
        this.actEconomica = actEconomica;
        this.registroSefiplan = registroSefiplan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getActEconomica() {
        return actEconomica;
    }

    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    public String getRegistroSefiplan() {
        return registroSefiplan;
    }

    public void setRegistroSefiplan(String registroSefiplan) {
        this.registroSefiplan = registroSefiplan;
    }
}
