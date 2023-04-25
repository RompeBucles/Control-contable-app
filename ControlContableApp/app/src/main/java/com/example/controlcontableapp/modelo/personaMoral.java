package com.example.controlcontableapp.modelo;

public class personaMoral {
    private int id;
    private String nombreEmpresa;
    private int apoderado;
    private int proveedor;

    public personaMoral(int id, String nombreEmpresa, int apoderado, int proveedor) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.apoderado = apoderado;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getApoderado() {
        return apoderado;
    }

    public void setApoderado(int apoderado) {
        this.apoderado = apoderado;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
}
