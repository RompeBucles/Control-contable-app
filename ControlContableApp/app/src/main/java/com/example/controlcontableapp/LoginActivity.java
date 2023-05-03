package com.example.controlcontableapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.modelo.modeloLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    ConexionBD conexionBD;
    String ConexionResultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //llamamos la caja de texto del loyout usuario y password login
        TextView txusuario = (TextView)findViewById(R.id.usuario);
        TextView txpassword = (TextView)findViewById(R.id.password);


        //llamamos al boton que esta en el loyout login
        Button btnentrar = (Button)findViewById(R.id.entrar);

        btnentrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Connection conn = conexionBD.Conn();
                if(conn == null) {
                    Toast.makeText(LoginActivity.this, "Error Conexion", Toast.LENGTH_LONG).show();
                    return;
                }
                try{

                        String query ="exec dbo.login '"+ txusuario.getText().toString()+"','"+txpassword.getText().toString()+"'";
                        Statement statement = conn.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);


                    if(resultSet.next()){
                        String perfil = resultSet.getString("perfil");

                        if(perfil.equals("Administrador")){
                            // Si el usuario es administrador, mostrar la actividad correspondiente
                            Intent intent = new Intent(LoginActivity.this, MenuAdminActivity.class);
                            startActivity(intent);

                        } if(perfil.equals("Usuario")) {
                            // Si es usuario , mostrar la actividad correspondiente
                            Intent intent = new Intent(LoginActivity.this, MenuUsuarioActivity.class);
                            startActivity(intent);

                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }

                } catch (SQLException erro) {
                    Toast.makeText(LoginActivity.this, "Error: " + erro, Toast.LENGTH_LONG).show();
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

