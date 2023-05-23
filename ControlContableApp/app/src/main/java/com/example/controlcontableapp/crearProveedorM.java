package com.example.controlcontableapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controlcontableapp.controlador.controladorEntidades;
import com.example.controlcontableapp.controlador.controladorProveedor;
import com.example.controlcontableapp.modelo.entidadFederativa;
import com.example.controlcontableapp.modelo.municipio;
import com.example.controlcontableapp.modelo.proveedorM;

public class crearProveedorM extends AppCompatActivity {

    EditText lblNombreEmp, lblNombre, lblApUno, lblApDos, lblRfc, lblActEcon, lblRegistro, lblNumero, lblCorreo, lblDierccion;
    Spinner boxMunicipio, boxEntidad;
    Button btnGuardar;
    //Context cnx = new crearProfveedorF();
    controladorProveedor contP = new controladorProveedor();
    controladorEntidades contE = new controladorEntidades();

    proveedorM pF = new proveedorM();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_proveedor_m);

        lblNombreEmp = (EditText) findViewById(R.id.lblNombreEmpresa);
        lblNombre = (EditText) findViewById(R.id.lblNombre);
        lblApUno = (EditText) findViewById(R.id.lblApUno);
        lblApDos = (EditText) findViewById(R.id.lblApDos);
        lblRfc = (EditText) findViewById(R.id.lblRfc);
        lblActEcon = (EditText) findViewById(R.id.lblActEcon);
        lblRegistro = (EditText) findViewById(R.id.lblRegistro);
        lblNumero = (EditText) findViewById(R.id.lblTelefono);
        lblCorreo = (EditText) findViewById(R.id.lblCorreo);
        lblDierccion = (EditText) findViewById(R.id.lblDireccion);
        boxEntidad = (Spinner) findViewById(R.id.boxEntidad);
        Spinner spinnerEntidad = (Spinner) findViewById(R.id.boxEntidad);
        boxMunicipio = (Spinner) findViewById(R.id.boxMunicipio);
        Spinner spinnerMunicipio = (Spinner) findViewById(R.id.boxMunicipio);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        ArrayAdapter<entidadFederativa> adapter = new ArrayAdapter<entidadFederativa>(this, android.R.layout.simple_spinner_item, contE.listaEntidades1(this));
        spinnerEntidad.setAdapter(adapter);

        spinnerEntidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> spinner,
                                       View v,
                                       int posicion,
                                       long id) {
                entidadFederativa en = (entidadFederativa) spinnerEntidad.getSelectedItem();
                ArrayAdapter<municipio> adapter2 = new ArrayAdapter<municipio>(crearProveedorM.this, android.R.layout.simple_spinner_item, contE.listaMunicipios(crearProveedorM.this,en.getId()));
                spinnerMunicipio.setAdapter(adapter2);
            }
            public void onNothingSelected(AdapterView<?> spn) {
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(proveedores.this, "FFFFFFF", Toast.LENGTH_LONG).show();
                if(validarCampos()){
                    entidadFederativa en = (entidadFederativa) spinnerEntidad.getSelectedItem();
                    municipio mu = (municipio) spinnerMunicipio.getSelectedItem();
                    if(crearUsuario(en, mu)){
                        Toast.makeText(crearProveedorM.this, "Registro creado", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(crearProveedorM.this, proveedores.class);
                        startActivity(intent );
                    }
                }
            }
        });
    }

    private boolean validarCampos(){
        boolean r = true;
        if(lblNombreEmp.getText().toString().isEmpty()){
            lblNombreEmp.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if(lblNombre.getText().toString().isEmpty()){
            lblNombre.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if(lblApUno.getText().toString().isEmpty()){
            lblApUno.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if(lblRfc.getText().toString().isEmpty()){
            lblRfc.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if(lblActEcon.getText().toString().isEmpty()){
            lblActEcon.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if(lblRegistro.getText().toString().isEmpty()){
            lblRegistro.setError("Este campo no puede quedar vacío");
            r = false;
        }
        if (!lblNombre.getText().toString().matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
            lblNombre.setError("Contenido no válido");
            r = false;
        }
        if (!lblApUno.getText().toString().matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
            lblApUno.setError("Contenido no válido");
            r = false;
        }
        /*if (!lblNombreEmp.getText().toString().matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
            lblNombreEmp.setError("Contenido no válido");
            r = false;
        }*/
        if(!lblApDos.getText().toString().isEmpty()){
            if (!lblApDos.getText().toString().matches("^[A-Za-züÜáéíóúáéíóúÁÉÍÓÚÑñ]{3,50}$")) {
                lblApDos.setError("Contenido no válido");
                r = false;
            }
        }
        if (!lblRegistro.getText().toString().matches("^([0-9])*$")) {
            lblRegistro.setError("Contenido no válido");
            r = false;
        }
        if (!lblNumero.getText().toString().matches("^([0-9])*$")) {
            lblNumero.setError("Contenido no válido");
            r = false;
        }

        return r;
    }

    private boolean crearUsuario(entidadFederativa en, municipio mu){
        pF.setRegimen("Moral");
        pF.setNombreEmpresa(lblNombreEmp.getText().toString());
        pF.setNombreApoderado(lblNombre.getText().toString());
        pF.setApellidUno(lblApUno.getText().toString());
        if(lblApDos.getText().toString().isEmpty()){pF.setApellidoDos(null);}else{pF.setApellidoDos(lblApDos.getText().toString());}
        pF.setRfc(lblRfc.getText().toString());
        pF.setActividadEconomica(lblActEcon.getText().toString());
        pF.setRegistro(lblRegistro.getText().toString());
        if(lblNumero.getText().toString().isEmpty()){pF.setTelefono(null);}else{pF.setTelefono(lblNumero.getText().toString());}
        if(lblCorreo.getText().toString().isEmpty()){pF.setCorreo(null);}else{pF.setCorreo(lblCorreo.getText().toString());}
        if(lblDierccion.getText().toString().isEmpty()){pF.setDireccion(null);}else{pF.setDireccion(lblDierccion.getText().toString());}
        if(en.getId()==0){}else{pF.setEntidadFederativa(en.getId());}
        if(mu.getId()==0){}else{pF.setMunicipio(en.getId());}

        //provisionales
        //pF.setEntidadFederativa(30);
        //pF.setMunicipio(2);

        if(contP.crearProvM(this,pF)){return true;}else{return false;}
    }
}