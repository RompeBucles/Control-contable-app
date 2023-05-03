package com.example.controlcontableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controlcontableapp.R;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.controlador.controladorUsuario;
import com.example.controlcontableapp.modelo.modeloUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearUsuariosActivity extends AppCompatActivity {
    ConexionBD conexionBD;
    EditText lblNombre, lblUsuario, lblContrasena, lblConfiContrasena;
    Spinner boxCargo, boxPerfil;
    Button btnGuardar;
    controladorUsuario insertarUsuario;


    controladorUsuario RecuperarIDusuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuarios);
        conexionBD = new ConexionBD();


        lblNombre = (EditText) findViewById(R.id.lblNombre);
        lblUsuario = (EditText) findViewById(R.id.lblUsuario);
        boxCargo = (Spinner) findViewById(R.id.boxCargo);
        Spinner spinnerCargo = (Spinner) findViewById(R.id.boxCargo);
        //Spinner spinnerPerfil = (Spinner) findViewById(R.id.boxCargo);
        //boxPerfil = (Spinner) findViewById(R.id.boxPerfil);
        lblContrasena = (EditText) findViewById(R.id.lblContrasena);
        lblConfiContrasena = (EditText) findViewById(R.id.lblConfiContrasena);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);





/*
        //Este es un campo de prueba para ver si funciona el OnFous
        lblNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (lblNombre.getText().toString().isEmpty()) {
                        lblNombre.setError("Este campo es obligatorio");
                    } else {
                        lblNombre.setError(null);
                    }
                }
            }
        });
*/
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
        //Lista desplegable Cargo

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{"Seleccione cargo", "Jefe de oficina", "Analista administrativo", "Administrativo especializado", "Jefe de departamento"});
        spinnerCargo.setAdapter(adapter);
        //Lista desplegable Perfil

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

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean retorno=true;
                Connection conn = conexionBD.Conn();
                String resultado = "";
                String c1=lblNombre.getText().toString();
                String c2=lblUsuario.getText().toString();
                Spinner boxCargo = findViewById(R.id.boxCargo);
                String c4=lblContrasena.getText().toString();
                String c5=lblConfiContrasena.getText().toString();


                if(conn == null) {
                    Toast.makeText(CrearUsuariosActivity.this, "Error", Toast.LENGTH_LONG).show();
                    return;
                }

                if(c1.isEmpty()){
                    lblNombre.setError("Este campo no puede quedar vacío");
                    retorno=false;
                }
                if(c2.isEmpty()){
                    lblUsuario.setError("Este campo no puede quedar vacío");
                    retorno=false;
                }
                if (boxCargo.getSelectedItem().equals("Seleccione cargo")) {
                    ((TextView) boxCargo.getSelectedView()).setError("Debe seleccionar una opción");
                    retorno=false;
                }
                if(c4.isEmpty()){
                    lblContrasena.setError("Este campo no puede quedar vacío");
                    retorno=false;
                }
                if (c1.isEmpty() || c2.isEmpty() || boxCargo.equals("Seleccione cargo")|| c4.isEmpty()){

                    Toast.makeText(CrearUsuariosActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
                    retorno=false;
                }

                if (!c1.matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
                    lblNombre.setError("El nombre no es válido");
                    retorno=false;
                }

                if (!c2.matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
                    lblUsuario.setError("El usuario no es válido");
                    retorno=false;
                }

                // Verificar que el usuario no se repita en la base de datos
                try {
                    String QUERY = "SELECT * FROM usuario WHERE usuario = '" + c2 + "'"+"and status = 1";
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(QUERY);

                    if (resultSet.next()) {
                        lblUsuario.setError("El usuario ya existe, intente con otro");
                        retorno=false;
                    }

                } catch (SQLException erro) {
                    Toast.makeText(CrearUsuariosActivity.this, "Ocurrió un error al verificar el usuario: " + erro, Toast.LENGTH_LONG).show();
                    retorno=false;
                }

                /*
                if (c4.length() < 6) {
                    lblContrasena.setError("La contraseña debe tener al menos 6 caracteres");
                    retorno=false;
                }
                */

                //es diferente a la contraseña y el .equal compara el objeto
                if (!c5.equals(c4)) {
                    lblConfiContrasena.setError("Las contraseñas no coinciden");
                    retorno=false;
                }

                modeloUsuario usuario = new modeloUsuario();
                usuario.setNombre(lblNombre.getText().toString());
                usuario.setUsuario(lblUsuario.getText().toString());
                usuario.setCargo(boxCargo.getSelectedItem().toString());
                usuario.setContrasena(lblContrasena.getText().toString());

                if(retorno){
                    resultado = controladorUsuario.insertarUsuario(conn, usuario);
                }



                if (resultado.equals("Guardado con exito")) {
                    limpiarCampos();

                    Toast.makeText(CrearUsuariosActivity.this, "El Usuario se ha agregado correctamente", Toast.LENGTH_LONG).show();

                    Intent intent  = new Intent(CrearUsuariosActivity.this, ListaUsuariosActivity.class);
                    startActivity(intent );

                } else {
                    Toast.makeText(CrearUsuariosActivity.this, "No se ha guardado el usuario " + resultado, Toast.LENGTH_LONG).show();
                }

            }
        });


    }
/*
    //Validar que los campos no esten vacios
    public boolean validar(){
        boolean retorno=true;
        String c1=lblNombre.getText().toString();
        String c2=lblUsuario.getText().toString();
        Spinner boxCargo = findViewById(R.id.boxCargo);
        String c4=lblContrasena.getText().toString();

        if(c1.isEmpty()){
            lblNombre.setError("Este campo no puede quedar vacío");
            retorno=false;
        }
        if(c2.isEmpty()){
            lblUsuario.setError("Este campo no puede quedar vacío");
            retorno=false;
        }
        if (boxCargo.getSelectedItem().equals("Seleccione cargo")) {
            ((TextView) boxCargo.getSelectedView()).setError("Debe seleccionar una opción");
            retorno=false;
        }
        if(c4.isEmpty()){
            lblContrasena.setError("Este campo no puede quedar vacío");
            retorno=false;
        }

        return retorno;
    }
*/
    /*
    //Valida que todos los campos esten llenos
    public boolean validaTodosCampos() {
        boolean retorno = true;
        String c1=lblNombre.getText().toString();
        String c2=lblUsuario.getText().toString();
        String valor = boxCargo.getSelectedItem().toString();
        String c4=lblContrasena.getText().toString();

        if (c1.isEmpty() || c2.isEmpty() || valor.equals("Seleccione cargo")|| c4.isEmpty()){

            Toast.makeText(CrearUsuariosActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
            retorno=false;
        }
        return retorno;
    }
*/

    private void limpiarCampos() {
        EditText Nombre = findViewById(R.id.lblNombre);
        EditText Usuario = findViewById(R.id.lblUsuario);
        Spinner spinnerCargo = findViewById(R.id.boxCargo);
        EditText contrasena = findViewById(R.id.lblContrasena);
        EditText confiContrasena = findViewById(R.id.lblConfiContrasena);

        Nombre.setText("");
        Usuario.setText("");
        spinnerCargo.setSelection(0);
        contrasena.setText("");
        confiContrasena.setText("");
    }


}