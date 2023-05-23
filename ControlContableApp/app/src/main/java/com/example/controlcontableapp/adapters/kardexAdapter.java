package com.example.controlcontableapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.R;
import com.example.controlcontableapp.modelo.kardexL;

import java.util.List;

public class kardexAdapter extends RecyclerView.Adapter<kardexAdapter.viewHolderKardex>{



    private Context ctx;

    private LayoutInflater mInflater;
    private List<kardexL> list;



    @NonNull
    @Override
    public viewHolderKardex onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_kardex, parent , false);
        return new viewHolderKardex(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderKardex holder, int position) {
        final kardexL prov = list.get(position);

        holder.txtId.setText(String.valueOf(prov.getId()));
        holder.txtNombre.setText(prov.getNombre());
        holder.txtAccion.setText(prov.getAccion());
        holder.txtDestino.setText(prov.getDestino());
        holder.txtFecha.setText(prov.getFecha());
        holder.txtSaldo.setText(String.valueOf(prov.getSaldo()));


    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class viewHolderKardex extends RecyclerView.ViewHolder {
        TextView txtId,txtNombre, txtAccion,txtDestino,txtFecha,txtSaldo;



        public viewHolderKardex(@NonNull View itemView) {
            super(itemView);

            txtId= (TextView) itemView.findViewById(R.id.txtId);
            txtNombre= (TextView) itemView.findViewById(R.id.txtNombre);
            txtAccion = (TextView) itemView.findViewById(R.id.txtAccion);
            txtDestino = (TextView) itemView.findViewById(R.id.txtDestino);
            txtFecha = (TextView) itemView.findViewById(R.id.txtFecha);
            txtSaldo = (TextView) itemView.findViewById(R.id.txtSaldo);
        }
    }

    public kardexAdapter(Context ctx, List<kardexL> list){
        this.mInflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.list = list;
    }

    /*@Override
    public proveedorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.activity_item_proveedores, null);
        return new ListAdapter.ViewHolder(view);
    }*/
}
