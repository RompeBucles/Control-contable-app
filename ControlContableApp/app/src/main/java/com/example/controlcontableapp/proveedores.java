package com.example.controlcontableapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.adapters.proveedorAdapter;
import com.example.controlcontableapp.controlador.controladorProveedor;
import com.example.controlcontableapp.modelo.listaProveedor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class proveedores extends AppCompatActivity {

    Context cnx;
    ConexionBD conexionBD;

    controladorProveedor contP = new controladorProveedor();

    FloatingActionButton btnNuevo;

    RecyclerView recyclerViewProveedores;

    proveedorAdapter provAdptr;

    List<listaProveedor> listaProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        btnNuevo = (FloatingActionButton) findViewById(R.id.btnNuevo);
        recyclerViewProveedores = (RecyclerView)findViewById(R.id.recyclerrViewProveedores);
        //final TextView label = (TextView) findViewById(R.id.textView11);
        listaProveedor = new ArrayList<>();
        //prueba manual
        //listaProveedor.add(new listaProveedor(1,1,"pb1","pb1","pb1","pb1"));

        listaProveedor=contP.listarProveedores(this);
        provAdptr = new proveedorAdapter(proveedores.this, listaProveedor);

        RecyclerView.LayoutManager layMan = new LinearLayoutManager(proveedores.this);
        recyclerViewProveedores.setLayoutManager(layMan);
        recyclerViewProveedores.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProveedores.addItemDecoration(new DividerItemDecoration(proveedores.this, LinearLayoutManager.VERTICAL));
        recyclerViewProveedores.setAdapter(provAdptr);

        //listaP();

        //listaProveedor=contP.listarProveedores(this);
        //listaProveedor.addAll(contP.listarProveedores(this));
        //contP.listarProveedores(this);
        //cnx = this;
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(proveedores.this, "FFFFFFF", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(proveedores.this);
                builder.setTitle("Tipo de proveedor");
                builder.setMessage("¿Quiere registrar una persona moral o una persona física?");


                builder.setPositiveButton("Persona física", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Intent intent  = new Intent(proveedores.this, crearProfveedorF.class);
                        startActivity(intent );
                        proveedores.this.finish();
                    }
                });
                builder.setNegativeButton("Persona moral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Intent intent  = new Intent(proveedores.this, crearProveedorM.class);
                        startActivity(intent );
                        proveedores.this.finish();
                    }
                });
                builder.show();
            }
        });




    }

    public void listaP(){
            listaProveedor=contP.listarProveedores(this);
            provAdptr.notifyDataSetChanged();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listaProveedor.clear();
        listaProveedor=contP.listarProveedores(this);

    }
}