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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.CrearUsuariosActivity;
import com.example.controlcontableapp.LoginActivity;
import com.example.controlcontableapp.R;
import com.example.controlcontableapp.modelo.modeloUsuario;

import java.util.List;


public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosViewHolder> {

    private Context ctx;
    private List<modeloUsuario> lista;

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {

        TextView txtItemNombre, txtItemUsuario,txtItemCargo,txtItemPerfil, txtItemFechaAlta;
        ImageView btnItemElimar, btnItemModificar;

        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);

            txtItemNombre = (TextView) itemView.findViewById(R.id.txtItemNombre);
            txtItemUsuario = (TextView) itemView.findViewById(R.id.txtItemUsuario);
            txtItemCargo = (TextView) itemView.findViewById(R.id.txtItemCargo);
            txtItemPerfil = (TextView) itemView.findViewById(R.id.txtItemPerfil);
            txtItemFechaAlta = (TextView) itemView.findViewById(R.id.txtItemFechaAlta);

            btnItemElimar = (ImageView) itemView.findViewById(R.id.btnItemElimar);
            btnItemModificar = (ImageView) itemView.findViewById(R.id.btnItemModificar);
        }
    }

    public UsuariosAdapter(Context ctx, List<modeloUsuario> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_usuarios, parent, false);

        return new UsuariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {
        final modeloUsuario usuario = lista.get(position);

        holder.txtItemNombre.setText(usuario.getNombre());
        holder.txtItemUsuario.setText(usuario.getUsuario());
        holder.txtItemCargo.setText(usuario.getCargo());
        holder.txtItemPerfil.setText(usuario.getPerfil());
        holder.txtItemFechaAlta.setText(usuario.getFechaAlta());

        holder.btnItemModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreForm = new Intent(ctx, CrearUsuariosActivity.class);
                abreForm.putExtra("id", usuario.getId());
                ctx.startActivity(abreForm);
            }
        });

        holder.btnItemElimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Eliminar usuario");
                builder.setMessage("¿Estás seguro de que quieres eliminar este usuario?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Código para eliminar el usuario aquí
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}