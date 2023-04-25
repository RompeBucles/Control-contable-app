package com.example.controlcontableapp.modelo;

public class modeloUsuario {
    private int id;
    private String nombre;
    private String usuario;
    private String cargo;
    private String perfil;
    private String fechaAlta;

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getUsuario(){return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getCargo(){return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}
    public String getPerfil(){return perfil;}
    public void setPerfil(String perfil){this.perfil = perfil;}
    public String getFechaAlta(){return fechaAlta;}
    public void setFechaAlta(String fechaAlta){this.fechaAlta = fechaAlta;}
}
