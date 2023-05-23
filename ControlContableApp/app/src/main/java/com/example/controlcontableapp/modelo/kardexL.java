package com.example.controlcontableapp.modelo;

public class kardexL {
    private int id;
    private String nombre;
    private String accion;
    private String destino;
    private String fecha;
    private int saldo;

    public kardexL() {
    }

    public kardexL(int id, String nombre, String accion, String destino, String fecha, int saldo) {
        this.id = id;
        this.nombre = nombre;
        this.accion = accion;
        this.destino = destino;
        this.fecha = fecha;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
