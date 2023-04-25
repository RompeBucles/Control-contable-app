package com.example.controlcontableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CrearUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuarios);

        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su usuario (para usar esta función, se importaron las librearias View, Edit text )
        TextView editNombre = (TextView) findViewById(R.id.lblNombre);

        editNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editNombre.setHint("");
                } else {
                    editNombre.setHint("Nombre");
                }
            }
        });

        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su contraseña (para usar esta función, se importaron las librearias View, Edit text )
        TextView editUsuario = (TextView) findViewById(R.id.lblUsuario);

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
        TextView editCargo = (TextView) findViewById(R.id.lblCargo);

        editCargo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editCargo.setHint("");
                } else {
                    editCargo.setHint("Cargo");
                }
            }
        });

        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su contraseña (para usar esta función, se importaron las librearias View, Edit text )
        TextView editContrasena = (TextView) findViewById(R.id.lblContrasena);

        editContrasena.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editContrasena.setHint("");
                } else {
                    editContrasena.setHint("Contraseña");
                }
            }
        });
        //Desaparece el titulo del cuadro de texto, cuando el usuario ingresa su contraseña (para usar esta función, se importaron las librearias View, Edit text )
        TextView editConfiContrasena = (TextView) findViewById(R.id.lblConfiContrasena);

        editConfiContrasena.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editConfiContrasena.setHint("");
                } else {
                    editConfiContrasena.setHint("Confirmar contraseña");
                }
            }
        });
    }
}