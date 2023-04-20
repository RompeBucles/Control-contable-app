package com.example.controlcontableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.controlcontableapp.BD.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    Connection conectado;
    String ConexionResultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //llamamos la caja de texto del loyout usuario y password login
        TextView usuario = (TextView)findViewById(R.id.usuario);
        TextView password = (TextView)findViewById(R.id.password);
        TextView msg = (TextView)findViewById(R.id.resultado);

        //llamamos al boton que esta en el loyout login
        Button btnentrar = (Button)findViewById(R.id.entrar);

        btnentrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Connection conn = ConexionBD.Conn();
                try{

                    if(conn!=null){
                        String query ="Select * from usuario";
                        Statement statement = conn.createStatement();
                        ResultSet ConexionResultado = statement.executeQuery(query);

                        msg.setText("Conectado a la BD SQL SERVER !!!!");

                    }else{
                        Toast.makeText(LoginActivity.this, "Tipo de error:", Toast.LENGTH_LONG).show();
                        return;
                    }
                } catch (SQLException erro) {
                    Toast.makeText(LoginActivity.this, "tipo de error: " + erro, Toast.LENGTH_LONG).show();
                }

            }
        });
        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su usuario (para usar esta función, se importaron las librearias View, Edit text )
        TextView editUsuario = (TextView) findViewById(R.id.usuario);

        editUsuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editUsuario.setHint("");
                } else {
                    editUsuario.setHint("Usuario");
                }
            }
        });

        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su contraseña (para usar esta función, se importaron las librearias View, Edit text )
        TextView editPassword = (TextView) findViewById(R.id.password);

        editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editPassword.setHint("");
                } else {
                    editPassword.setHint("Contraseña");
                }
            }
        });
    }

}

