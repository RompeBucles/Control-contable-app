package com.example.controlcontableapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.adapters.kardexAdapter;
import com.example.controlcontableapp.controlador.controladorKardex;
import com.example.controlcontableapp.modelo.kardexL;

import java.util.ArrayList;
import java.util.List;

public class kardexList extends AppCompatActivity {

    controladorKardex contP = new controladorKardex();

    RecyclerView recyclerViewKardex;

    kardexAdapter kAdptr;

    List<kardexL> listaKardex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kardex_l);

        recyclerViewKardex = (RecyclerView)findViewById(R.id.recyclerrViewKardex);

        listaKardex = new ArrayList<>();

        listaKardex = contP.listaKardez(this);

        kAdptr = new kardexAdapter(kardexList.this, listaKardex);

        RecyclerView.LayoutManager layMan = new LinearLayoutManager(kardexList.this);
        recyclerViewKardex.setLayoutManager(layMan);
        recyclerViewKardex.setItemAnimator(new DefaultItemAnimator());
        recyclerViewKardex.addItemDecoration(new DividerItemDecoration(kardexList.this, LinearLayoutManager.VERTICAL));
        recyclerViewKardex.setAdapter(kAdptr);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listaKardex.clear();
        listaKardex=contP.listaKardez(this);

    }
}