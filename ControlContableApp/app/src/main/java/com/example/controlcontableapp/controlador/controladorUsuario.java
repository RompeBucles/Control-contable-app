package com.example.controlcontableapp.controlador;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.R;
import com.example.controlcontableapp.modelo.modeloUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorUsuario {
    ConexionBD conexionBD;
    EditText lblIds, lblNombre, lblUsuario, lblContrasena;
    Spinner boxCargo, boxPerfil;
    private Context ctx;



    public static String insertarUsuario(Connection conn, modeloUsuario usuario) {
        try {

            PreparedStatement preparedStatement = conn.prepareStatement("exec dbo.Insertar_usuario  ?, ?, ?, ?");
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getCargo());
            preparedStatement.setString(4, usuario.getContrasena());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            return "Guardado con exito";
        } catch (SQLException erro) {
            return "Error: " + erro.getMessage();
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

    public static String actulizarUsuario(Connection conn, modeloUsuario usuario) {
        try {
            String QUERY_UPDATE = "exec dbo.Modificar_usuario  ?, ?, ?, ?, ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getUsuario());
            preparedStatement.setString(4, usuario.getCargo());
            preparedStatement.setString(5, usuario.getContrasena());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            return "ACTUALIZADO";
        } catch (SQLException erro) {
            return "Error: " + erro.getMessage();
        }finally {
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
