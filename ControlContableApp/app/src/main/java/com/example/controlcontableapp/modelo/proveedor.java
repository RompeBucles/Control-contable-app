package com.example.controlcontableapp.modelo;

public class proveedor {
    private int id;
    private String regimen;
    private String rfc;
    private String actividadEconomica;
    private String direccion;
    private String registro;
    private byte status;
    private int entidadFederativa;
    private int municipio;

    public proveedor(int id, String regimen, String rfc, String actividadEconomica, String direccion, String registro, byte status, int entidadFederativa, int municipio) {
        this.id = id;
        this.regimen = regimen;
        this.rfc = rfc;
        this.actividadEconomica = actividadEconomica;
        this.direccion = direccion;
        this.registro = registro;
        this.status = status;
        this.entidadFederativa = entidadFederativa;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(int entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }
}
