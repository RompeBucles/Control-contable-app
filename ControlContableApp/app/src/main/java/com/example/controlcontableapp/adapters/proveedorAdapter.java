package com.example.controlcontableapp.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.R;
import com.example.controlcontableapp.controlador.controladorProveedor;
import com.example.controlcontableapp.modProvF;
import com.example.controlcontableapp.modProvM;
import com.example.controlcontableapp.modelo.listaProveedor;

import java.util.List;

public class proveedorAdapter extends RecyclerView.Adapter<proveedorAdapter.viewHolderProveedores>{

    ConexionBD conexionDB;
    controladorProveedor contProveedor = new controladorProveedor();

    private Context ctx;

    private LayoutInflater mInflater;
    private List<listaProveedor> list;

    public void removeItemById(int id) {
        for (int i =0; i < list.size(); i++){
            if (list.get(i).getId()==id){
                list.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    @NonNull
    @Override
    public viewHolderProveedores onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_proveedores, parent , false);
        return new viewHolderProveedores(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderProveedores holder, int position) {
        final listaProveedor prov = list.get(position);

        holder.txtId.setText(String.valueOf(prov.getId()));
        holder.txtIdProv.setText(String.valueOf(prov.getIdProveedor()));
        holder.txtNombre.setText(prov.getNombre());
        holder.txtRfc.setText(prov.getRfc());
        holder.txtActEcon.setText(prov.getActEconomica());
        holder.txtRegistro.setText(prov.getRegistroSefiplan());

        holder.btnItemModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a = contProveedor.tipoProv(ctx, prov.getIdProveedor());

                if(a==0){
                    Toast.makeText(ctx, "Error con h", Toast.LENGTH_LONG).show();
                } else if (a==1) {
                    Intent abreForm = new Intent(ctx, modProvF.class);
                    abreForm.putExtra("id", prov.getIdProveedor());
                    ctx.startActivity(abreForm);
                } else if (a==2) {
                    Intent abreForm = new Intent(ctx, modProvM.class);
                    abreForm.putExtra("id", prov.getIdProveedor());
                    ctx.startActivity(abreForm);
                }


            }
        });

        holder.btnItemElimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Eliminar proveedor");
                builder.setMessage("¿Estás seguro de que quieres eliminar este proveedor?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String i = String.valueOf(prov.getId());
                        int id = prov.getIdProveedor();
                        if(!i.isEmpty())  {



                            try {
                                if (contProveedor.bajaProv(ctx, id)){
                                    Toast.makeText(ctx, "Se ha dado de baja al proveedor", Toast.LENGTH_LONG).show();
                                    removeItemById(Integer.parseInt(i));
                                }

                            } catch (Exception e) {
                                Toast.makeText(ctx, "Error: " +id+i  +e, Toast.LENGTH_LONG).show();
                            }

                        }
                    }


                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class viewHolderProveedores extends RecyclerView.ViewHolder {
        TextView txtId,txtIdProv,txtNombre, txtRfc,txtActEcon,txtRegistro;

        ImageView btnItemElimar, btnItemModificar;

        public viewHolderProveedores(@NonNull View itemView) {
            super(itemView);

            txtId= (TextView) itemView.findViewById(R.id.txtId);
            txtIdProv= (TextView) itemView.findViewById(R.id.txtIdProv);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtRfc = (TextView) itemView.findViewById(R.id.txtRfc);
            txtActEcon = (TextView) itemView.findViewById(R.id.txtActEcon);
            txtRegistro = (TextView) itemView.findViewById(R.id.txtRegistro);
            btnItemElimar = (ImageView) itemView.findViewById(R.id.btnItemElimar);
            btnItemModificar = (ImageView) itemView.findViewById(R.id.btnItemModificar);
        }
    }

    public proveedorAdapter(Context ctx, List<listaProveedor> list){
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
