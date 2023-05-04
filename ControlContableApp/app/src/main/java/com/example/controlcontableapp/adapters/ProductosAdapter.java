package com.example.controlcontableapp.adapters;

import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.R;
import com.example.controlcontableapp.modelo.factura;
import com.example.controlcontableapp.modelo.modeloListaProductos;
import com.example.controlcontableapp.modelo.producto;
import com.example.controlcontableapp.modelo.unidadMedida;


import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder>{
    ConexionBD conexionBD;
    private Context ctx;
    private List<modeloListaProductos> listaProductos;

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemProducto, txtItemFactura,txtItemCantidad, txtItemMedida, txtItemFecha;
        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            txtItemProducto = (TextView) itemView.findViewById(R.id.txtItemProducto);
            txtItemFactura = (TextView) itemView.findViewById(R.id.txtItemFactura);
            txtItemCantidad = (TextView) itemView.findViewById(R.id.txtItemCantidad);
            txtItemMedida = (TextView) itemView.findViewById(R.id.txtItemMedida);
            txtItemFecha =(TextView) itemView.findViewById(R.id.txtItemFecha);
        }

    }

    public ProductosAdapter(Context ctx, List<modeloListaProductos> listaProductos) {
        this.ctx = ctx;
        this.listaProductos = listaProductos;
    }


    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_productos, parent, false);

        return new ProductosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        final modeloListaProductos modeloProducto = listaProductos.get(position);

        holder.txtItemProducto.setText(modeloProducto.getProducto());
        holder.txtItemFactura.setText(modeloProducto.getNumeroFactura());
        holder.txtItemCantidad.setText(String.valueOf(modeloProducto.getCantidad()));
        holder.txtItemMedida.setText(modeloProducto.getValor());
        holder.txtItemFecha.setText(modeloProducto.getFechaEmision());
    }

    @Override
    public int getItemCount() {return this.listaProductos.size();}

}
