package com.example.controlcontableapp.controlador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.crearProveedorM;
import com.example.controlcontableapp.modelo.entidadFederativa;
import com.example.controlcontableapp.modelo.municipio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class controladorEntidades {
    public List listaEntidades(Context p){
        List<entidadFederativa> list;
        list = new ArrayList<entidadFederativa>();
        list.add(new entidadFederativa(0,"0","Entidad Federativa"));
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return list;
        }
        try {
            String QUERY = "exec dbo.listaEntidades";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                entidadFederativa entidad = new entidadFederativa();
                entidad.setId(resultSet.getInt("id"));
                entidad.setClave(resultSet.getString("clave"));
                entidad.setValor(resultSet.getString("valor"));


                list.add(entidad);
            }
            return list;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return list;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("CONEXAO_MSSQL", e.getMessage());
            }
        }
    }

    public List listaMunicipios(Context p, int id){
        List<municipio> list;
        list = new ArrayList<municipio>();
        list.add(new municipio(0,"0","Municipio",0));
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return list;
        }
        try {
            String QUERY = "exec dbo.listaMunicipios " + id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                municipio muni = new municipio();
                muni.setId(resultSet.getInt("id"));
                muni.setClave(resultSet.getString("clave"));
                muni.setValor(resultSet.getString("valor"));
                muni.setId(resultSet.getInt("entidadFederativa"));


                list.add(muni);
            }
            return list;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return list;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("CONEXAO_MSSQL", e.getMessage());
            }
        }
    }

    public List listaEntidades1(crearProveedorM p){
        List<entidadFederativa> list;
        list = new ArrayList<entidadFederativa>();
        list.add(new entidadFederativa(0,"0","Entidad Federativa"));
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return list;
        }
        try {
            String QUERY = "exec dbo.listaEntidades";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                entidadFederativa entidad = new entidadFederativa();
                entidad.setId(resultSet.getInt("id"));
                entidad.setClave(resultSet.getString("clave"));
                entidad.setValor(resultSet.getString("valor"));


                list.add(entidad);
            }
            return list;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return list;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("CONEXAO_MSSQL", e.getMessage());
            }
        }
    }
}
