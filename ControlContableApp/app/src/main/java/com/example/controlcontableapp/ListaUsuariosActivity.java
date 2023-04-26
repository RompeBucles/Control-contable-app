package com.example.controlcontableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.adapters.UsuariosAdapter;
import com.example.controlcontableapp.modelo.modeloUsuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ListaUsuariosActivity extends AppCompatActivity {

    ConexionBD conexionBD;

    ImageView btnAtras;
    FloatingActionButton btnLista;
   RecyclerView recyclerViewUsuarios;

   UsuariosAdapter usuarioAdapter;
   List<modeloUsuario> listaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        //conexionBD = new ConexionBD();

        //btnAtras = (ImageView) findViewById(R.id.btnAtras);

        btnLista = (FloatingActionButton) findViewById(R.id.btnLista);

        recyclerViewUsuarios = (RecyclerView) findViewById(R.id.recyclerViewUsuarios);

        listaUsuario = new ArrayList<>();
        usuarioAdapter = new UsuariosAdapter(ListaUsuariosActivity.this, listaUsuario);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListaUsuariosActivity.this);
        recyclerViewUsuarios.setLayoutManager(layoutManager);
        recyclerViewUsuarios.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsuarios.addItemDecoration(new DividerItemDecoration(ListaUsuariosActivity.this, LinearLayoutManager.VERTICAL));
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        listarUsuarios();
/*
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreMenu = new Intent(ListaUsuariosActivity.this, MenuUsuarioActivity.class);
                startActivity(abreMenu);
            }
        });
*/

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(ListaUsuariosActivity.this, CrearUsuariosActivity.class);
                startActivity(intent );
            }
        });

    }

    public void listarUsuarios() {
        Connection conn = conexionBD.Conn();


        if(conn == null) {
            Toast.makeText(ListaUsuariosActivity.this, "Error al conectar", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.ListaUsuarios";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                modeloUsuario usuario = new modeloUsuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setCargo(resultSet.getString("cargo"));
                usuario.setPerfil(resultSet.getString("perfil"));
                usuario.setStatus(resultSet.getBoolean("status"));
                usuario.setFechaAlta(resultSet.getString("fechaAlta"));


                listaUsuario.add(usuario);
            }

            usuarioAdapter.notifyDataSetChanged();

        } catch (SQLException erro) {
            Toast.makeText(ListaUsuariosActivity.this, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listaUsuario.clear();
        listarUsuarios();
    }


}