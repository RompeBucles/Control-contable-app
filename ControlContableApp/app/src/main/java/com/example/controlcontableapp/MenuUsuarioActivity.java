package com.example.controlcontableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;

import java.sql.Connection;

public class MenuUsuarioActivity extends AppCompatActivity {
    ConexionBD conexionBD;
    ImageView btnUsuarios, btnProductos, btnProveedores, btnKardex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        btnProductos = (ImageView) findViewById(R.id.btnProductos);
        btnProveedores = (ImageView) findViewById(R.id.btnProveedores);
        btnKardex = (ImageView) findViewById(R.id.btnKardex);

        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection conn = conexionBD.Conn();
                if(conn == null) {
                    Toast.makeText(MenuUsuarioActivity.this, "Error Conexion", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MenuUsuarioActivity.this, ListaProductosActivity.class);
                startActivity(intent);
            }
        });

        btnProveedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection conn = conexionBD.Conn();
                if(conn == null) {
                    Toast.makeText(MenuUsuarioActivity.this, "Error Conexion", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MenuUsuarioActivity.this, proveedores.class);
                startActivity(intent);
            }
        });

        btnKardex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection conn = conexionBD.Conn();
                if(conn == null) {
                    Toast.makeText(MenuUsuarioActivity.this, "Error Conexion", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MenuUsuarioActivity.this, kardexList.class);
                startActivity(intent);
            }
        });
    }
}