package com.example.controlcontableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;

import java.sql.Connection;

public class MenuAdminActivity extends AppCompatActivity {
    ConexionBD conexionBD;
    ImageView btnUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btnUsuarios = (ImageView) findViewById(R.id.btnUsuarios);
        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection conn = conexionBD.Conn();
                if(conn == null) {
                    Toast.makeText(MenuAdminActivity.this, "Error Conexion", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MenuAdminActivity.this, ListaUsuariosActivity.class);
                startActivity(intent);
            }
        });
    }
}