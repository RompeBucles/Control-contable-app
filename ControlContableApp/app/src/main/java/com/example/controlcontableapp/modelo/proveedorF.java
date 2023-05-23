package com.example.controlcontableapp.modelo;

public class proveedorF {
    private int id;
    private String regimen;
    private String rfc;
    private String actividadEconomica;
    private String direccion;
    private String registro;
    private byte status;
    private int entidadFederativa;
    private int municipio;
    private int idPersonaFisica;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private String numeroContacto;
    private String correo;

    public proveedorF(int id, String regimen, String rfc, String actividadEconomica, String direccion, String registro, byte status, int entidadFederativa, int municipio, int idPersonaFisica, String nombre, String apellidoUno, String apellidoDos, String numeroContacto, String correo) {
        this.id = id;
        this.regimen = regimen;
        this.rfc = rfc;
        this.actividadEconomica = actividadEconomica;
        this.direccion = direccion;
        this.registro = registro;
        this.status = status;
        this.entidadFederativa = entidadFederativa;
        this.municipio = municipio;
        this.idPersonaFisica = idPersonaFisica;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
    }

    public proveedorF() {
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

    public int getIdPersonaFisica() {
        return idPersonaFisica;
    }

    public void setIdPersonaFisica(int idPersonaFisica) {
        this.idPersonaFisica = idPersonaFisica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
