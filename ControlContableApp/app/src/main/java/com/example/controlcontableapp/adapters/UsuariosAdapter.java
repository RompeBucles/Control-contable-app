package com.example.controlcontableapp.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.CrearUsuariosActivity;
import com.example.controlcontableapp.EditarUsuarioActivity;
import com.example.controlcontableapp.R;
import com.example.controlcontableapp.controlador.controladorUsuario;
import com.example.controlcontableapp.modelo.modeloUsuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosViewHolder> {
    ConexionBD conexionBD;
    controladorUsuario eliminarUsuario;
    private Context ctx;
    private List<modeloUsuario> lista;

    public void removeItemById(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) { // getId() es un método de la clase Note que devuelve el ID de la nota
                lista.remove(i); // Elimina el objeto de la lista
                notifyItemRemoved(i); // Notifica al RecyclerView que se eliminó un elemento en la posición correspondiente
                break; // Sale del bucle una vez que se encuentra y elimina el elemento deseado
            }
        }
    }

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {

        TextView txtItemNombre, txtItemUsuario,txtItemCargo,txtItemPerfil,txtItemStatus, txtItemFechaAlta;
        ImageView btnItemElimar, btnItemModificar;

        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);

            txtItemNombre = (TextView) itemView.findViewById(R.id.txtItemNombre);
            txtItemUsuario = (TextView) itemView.findViewById(R.id.txtItemUsuario);
            txtItemCargo = (TextView) itemView.findViewById(R.id.txtItemCargo);
            txtItemPerfil = (TextView) itemView.findViewById(R.id.txtItemPerfil);
            txtItemStatus =(TextView) itemView.findViewById(R.id.txtItemStatus);
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
        if (usuario.getStatus()) {
            holder.txtItemStatus.setText("Vigente");
        } else {
            holder.txtItemStatus.setText("No vigente");
        }
        holder.txtItemFechaAlta.setText(usuario.getFechaAlta());




        holder.btnItemModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abreForm = new Intent(ctx, EditarUsuarioActivity.class);
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

                        Connection conn = conexionBD.Conn();
                                if(conn == null) {
                                    Toast.makeText(ctx, "Error", Toast.LENGTH_LONG).show();
                                    return;
                                }
                                String id = String.valueOf(usuario.getId());
                                if(!id.isEmpty())  {

                                    removeItemById(Integer.parseInt(id));

                                    try {
                                        String QUERY = "exec dbo.eliminarUsuario " + id;
                                        Statement statement = conn.createStatement();
                                        boolean resultSet = statement.execute(QUERY);

                                    } catch (SQLException erro) {
                                        Toast.makeText(ctx, "Error: " + erro, Toast.LENGTH_LONG).show();
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
