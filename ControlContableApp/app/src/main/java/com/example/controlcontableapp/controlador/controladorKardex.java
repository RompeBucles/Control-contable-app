package com.example.controlcontableapp.controlador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.modelo.kardexL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class controladorKardex {
    public List listaKardez(Context p){
        List<kardexL> list;
        list = new ArrayList<>();
        //list.add(new kardexL(0,"0","Entidad Federativa"));
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return list;
        }
        try {
            String QUERY = "exec dbo.listaKardex";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                kardexL entidad = new kardexL();
                entidad.setId(resultSet.getInt("id"));
                entidad.setNombre(resultSet.getString("producto"));
                entidad.setAccion(resultSet.getString("accion"));
                entidad.setDestino(resultSet.getString("dirigidoA"));
                entidad.setFecha(resultSet.getString("fecha"));
                entidad.setSaldo(resultSet.getInt("saldo"));

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
