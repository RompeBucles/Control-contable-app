package com.example.controlcontableapp.controlador;

import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.LoginActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorLogin {

/*
    public void inicioSesion() {

        Connection conn = ConexionBD.Conn();
        String resultado = "";

        if(conn == null) {


/*
        try {
            String QUERY = "SELECT * FROM funcionarios WHERE id = " + id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                editId.setText(String.valueOf(id));
                editNome.setText(resultSet.getString("nome"));
                editTelefone.setText(resultSet.getString("telefone"));
                editIdade.setText(String.valueOf(resultSet.getInt("idade")));
            }

        } catch (SQLException erro) {
            Toast.makeText(CadastroActivity.this, "Ocorreu um erro: " + erro, Toast.LENGTH_LONG).show();
        }

    }
*/
}
