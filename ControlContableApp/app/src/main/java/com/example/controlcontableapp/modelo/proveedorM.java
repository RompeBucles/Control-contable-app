package com.example.controlcontableapp.modelo;

public class proveedorM {
    private int id;
    private String regimen;
    private String rfc;
    private String actividadEconomica;
    private String direccion;
    private String registro;
    private byte status;
    private int entidadFederativa;
    private int municipio;
    private int idPersonaMoral;
    private String nombreEmpresa;
    private int idApoderado;
    private String nombreApoderado;
    private String apellidUno;
    private String apellidoDos;
    private String telefono;
    private String correo;

    public proveedorM(int id, String regimen, String rfc, String actividadEconomica, String direccion, String registro, byte status, int entidadFederativa, int municipio, int idPersonaMoral, String nombreEmpresa, int idApoderado, String nombreApoderado, String apellidUno, String apellidoDos, String telefono, String correo) {
        this.id = id;
        this.regimen = regimen;
        this.rfc = rfc;
        this.actividadEconomica = actividadEconomica;
        this.direccion = direccion;
        this.registro = registro;
        this.status = status;
        this.entidadFederativa = entidadFederativa;
        this.municipio = municipio;
        this.idPersonaMoral = idPersonaMoral;
        this.nombreEmpresa = nombreEmpresa;
        this.idApoderado = idApoderado;
        this.nombreApoderado = nombreApoderado;
        this.apellidUno = apellidUno;
        this.apellidoDos = apellidoDos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public proveedorM() {
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

    public int getIdPersonaMoral() {
        return idPersonaMoral;
    }

    public void setIdPersonaMoral(int idPersonaMoral) {
        this.idPersonaMoral = idPersonaMoral;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(int idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public String getApellidUno() {
        return apellidUno;
    }

    public void setApellidUno(String apellidUno) {
        this.apellidUno = apellidUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
