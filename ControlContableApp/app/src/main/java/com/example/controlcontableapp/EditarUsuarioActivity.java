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

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.controlador.controladorUsuario;
import com.example.controlcontableapp.modelo.modeloUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EditarUsuarioActivity extends AppCompatActivity {
    ConexionBD conexionBD;
    EditText lblIds, lblNombre, lblUsuario, lblContrasena, lblConfiContrasena;
    Spinner boxCargo, boxPerfil;
    Button btnGuardar;
    controladorUsuario actulizarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        conexionBD = new ConexionBD();

        lblIds = (EditText) findViewById(R.id.lblIds);
        lblNombre = (EditText) findViewById(R.id.lblNombre);
        lblUsuario = (EditText) findViewById(R.id.lblUsuario);
        boxCargo = (Spinner) findViewById(R.id.boxCargo);
        Spinner spinnerCargo = (Spinner) findViewById(R.id.boxCargo);
       // Spinner spinnerPerfil = (Spinner) findViewById(R.id.boxCargo);
       // boxPerfil = (Spinner) findViewById(R.id.boxPerfil);
        lblContrasena = (EditText) findViewById(R.id.lblContrasena);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

/*
        //OBTENER LOS CAMPOS DE ENTRADA
        String nombre = lblNombre.getText().toString();
        String usuario = lblUsuario.getText().toString();
        String contrasena = lblContrasena.getText().toString();
        String confiContrasena = lblConfiContrasena.getText().toString();
*/

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            int id = (int) bundle.get("id");
            recuperarIDusuario(id);
        }

        //Lista desplegable Cargo
/*
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{adapter, "Jefe de oficina", "Analista administrativo", "Administrativo especializado", "Jefe de departamento"});
        spinnerCargo.setAdapter(adapters);
*/

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

                if(conn == null) {
                    Toast.makeText(EditarUsuarioActivity.this, "Error", Toast.LENGTH_LONG).show();
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
                if(c4.length() < 8){
                    lblContrasena.setError("La contraseña debe tener al menos 8 caracteres");
                    retorno=false;
                }
                if (c1.isEmpty() || c2.isEmpty() || boxCargo.equals("Seleccione cargo")|| c4.isEmpty()){

                    Toast.makeText(EditarUsuarioActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
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


            try {


                    String id = lblIds.getText().toString();

                    modeloUsuario usuario = new modeloUsuario();
                    usuario.setId(Integer.parseInt(lblIds.getText().toString()));
                    usuario.setNombre(lblNombre.getText().toString());
                    usuario.setUsuario(lblUsuario.getText().toString());
                    usuario.setCargo(boxCargo.getSelectedItem().toString());
                    usuario.setContrasena(lblContrasena.getText().toString());

                    if(retorno){
                        resultado = controladorUsuario.actulizarUsuario(conn, usuario);
                    }

                }catch (Exception e){
                Toast.makeText(EditarUsuarioActivity.this, "ocurrio: " + e, Toast.LENGTH_LONG).show();
            }





                if (resultado.equals("ACTUALIZADO")) {
                    Toast.makeText(EditarUsuarioActivity.this, "El Usuario se ha modificado correctamente", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(EditarUsuarioActivity.this, ListaUsuariosActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditarUsuarioActivity.this, "El usuario no se a modificado" + resultado, Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void recuperarIDusuario(int id) {

        Connection conn = conexionBD.Conn();
        String resultado = "";

        if(conn == null) {
            Toast.makeText(EditarUsuarioActivity.this, "Error", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.recuperarId " +id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            String opciones = null;

            while(resultSet.next()) {
                lblIds.setText(String.valueOf(id));
                lblNombre.setText(resultSet.getString("nombre"));
                lblUsuario.setText(resultSet.getString("usuario"));
                // Agregar cada valor a la lista
               // opciones.add(resultSet.getString("cargo"));
                opciones = resultSet.getString("cargo");
                lblContrasena.setText(resultSet.getString("contrasena"));
            }
            // Crear un ArrayAdapter y asignarlo al Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{opciones,"Jefe de oficina", "Analista administrativo", "Administrativo especializado", "Jefe de departamento"});

            boxCargo.setAdapter(adapter);

        } catch (SQLException erro) {
            Toast.makeText(EditarUsuarioActivity.this, "Ocorreu um erro: " + erro, Toast.LENGTH_LONG).show();
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

    /*
    //Validar que los campos no esten vacios
    public boolean validar(){
        boolean retorno=true;
        String c1=lblNombre.getText().toString();

        Spinner boxCargo = findViewById(R.id.boxCargo);
        String c4=lblContrasena.getText().toString();

        if(c1.isEmpty()){
            lblNombre.setError("Este campo no puede quedar vacío");
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

    //Valida que todos los campos esten llenos
    public boolean validaTodosCampos() {
        boolean retorno = true;
        String c1=lblNombre.getText().toString();
        String c2=lblUsuario.getText().toString();
        String valor = boxCargo.getSelectedItem().toString();
        String c4=lblContrasena.getText().toString();

        if (c1.isEmpty() || c2.isEmpty() || valor.equals("Seleccione cargo")|| c4.isEmpty()){

            Toast.makeText(EditarUsuarioActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
            retorno=false;
        }
        return retorno;
    }
*/
}