package com.example.controlcontableapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.adapters.ProductosAdapter;
import com.example.controlcontableapp.adapters.UsuariosAdapter;
import com.example.controlcontableapp.modelo.factura;
import com.example.controlcontableapp.modelo.modeloListaProductos;
import com.example.controlcontableapp.modelo.modeloUsuario;
import com.example.controlcontableapp.modelo.producto;
import com.example.controlcontableapp.modelo.unidadMedida;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaProductosActivity extends AppCompatActivity {
    ConexionBD conexionBD;

    RecyclerView recyclerViewProductos;

    ProductosAdapter productosAdapter;
    List<modeloListaProductos> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        recyclerViewProductos = (RecyclerView) findViewById(R.id.recyclerViewProductos);

        listaProductos = new ArrayList<>();

        productosAdapter = new ProductosAdapter(ListaProductosActivity.this, listaProductos);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListaProductosActivity.this);
        recyclerViewProductos.setLayoutManager(layoutManager);
        recyclerViewProductos.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProductos.addItemDecoration(new DividerItemDecoration(ListaProductosActivity.this, LinearLayoutManager.VERTICAL));
        recyclerViewProductos.setAdapter(productosAdapter);

        listarProductosPP();

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.lista, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item1){
            listaProductos.clear();
            listarProductosPP();
        } else if (id == R.id.item2) {
            listaProductos.clear();
            listarProductosLP();
        } else if (id == R.id.item3) {
            listaProductos.clear();
            listarProductosBT();
        } else if (id == R.id.item4) {
            listaProductos.clear();
            listarProductosEC();

        }
        return super.onOptionsItemSelected(item);
    }

    public void listarProductosPP() {
        Connection conn = conexionBD.Conn();


        if(conn == null) {
            Toast.makeText(ListaProductosActivity.this, "Error al conectar", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.ListaProductosPP";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                modeloListaProductos modeloProducto = new modeloListaProductos();

                modeloProducto.setProducto(resultSet.getString("producto"));
                modeloProducto.setNumeroFactura(resultSet.getString("numeroFactura"));
                modeloProducto.setCantidad(resultSet.getInt("cantidad"));
                modeloProducto.setValor(resultSet.getString("valor"));
                modeloProducto.setFechaEmision(resultSet.getString("fechaEmision"));

                listaProductos.add(modeloProducto);

            }
            productosAdapter.notifyDataSetChanged();

        } catch (SQLException erro) {
            Toast.makeText(ListaProductosActivity.this, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
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

    public void listarProductosLP() {
        Connection conn = conexionBD.Conn();


        if(conn == null) {
            Toast.makeText(ListaProductosActivity.this, "Error al conectar", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.ListaProductosLP";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                modeloListaProductos modeloProducto = new modeloListaProductos();

                modeloProducto.setProducto(resultSet.getString("producto"));
                modeloProducto.setNumeroFactura(resultSet.getString("numeroFactura"));
                modeloProducto.setCantidad(resultSet.getInt("cantidad"));
                modeloProducto.setValor(resultSet.getString("valor"));
                modeloProducto.setFechaEmision(resultSet.getString("fechaEmision"));

                listaProductos.add(modeloProducto);

            }
            productosAdapter.notifyDataSetChanged();

        } catch (SQLException erro) {
            Toast.makeText(ListaProductosActivity.this, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
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

    public void listarProductosBT() {
        Connection conn = conexionBD.Conn();


        if(conn == null) {
            Toast.makeText(ListaProductosActivity.this, "Error al conectar", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.ListaProductosBT";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                modeloListaProductos modeloProducto = new modeloListaProductos();

                modeloProducto.setProducto(resultSet.getString("producto"));
                modeloProducto.setNumeroFactura(resultSet.getString("numeroFactura"));
                modeloProducto.setCantidad(resultSet.getInt("cantidad"));
                modeloProducto.setValor(resultSet.getString("valor"));
                modeloProducto.setFechaEmision(resultSet.getString("fechaEmision"));

                listaProductos.add(modeloProducto);

            }
            productosAdapter.notifyDataSetChanged();

        } catch (SQLException erro) {
            Toast.makeText(ListaProductosActivity.this, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
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

    public void listarProductosEC() {
        Connection conn = conexionBD.Conn();


        if(conn == null) {
            Toast.makeText(ListaProductosActivity.this, "Error al conectar", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            String QUERY = "exec dbo.ListaProductosEC";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                modeloListaProductos modeloProducto = new modeloListaProductos();

                modeloProducto.setProducto(resultSet.getString("producto"));
                modeloProducto.setNumeroFactura(resultSet.getString("numeroFactura"));
                modeloProducto.setCantidad(resultSet.getInt("cantidad"));
                modeloProducto.setValor(resultSet.getString("valor"));
                modeloProducto.setFechaEmision(resultSet.getString("fechaEmision"));

                listaProductos.add(modeloProducto);

            }
            productosAdapter.notifyDataSetChanged();

        } catch (SQLException erro) {
            Toast.makeText(ListaProductosActivity.this, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
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

    @Override
    protected void onRestart() {
        super.onRestart();
        listaProductos.clear();
        listarProductosPP();
    }

}