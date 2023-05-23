package com.example.controlcontableapp.controlador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.controlcontableapp.BD.ConexionBD;
import com.example.controlcontableapp.crearProfveedorF;
import com.example.controlcontableapp.modelo.listaProveedor;
import com.example.controlcontableapp.modelo.proveedorF;
import com.example.controlcontableapp.modelo.proveedorM;
import com.example.controlcontableapp.proveedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class controladorProveedor {

    public List listarProveedores(proveedores p){
        List<listaProveedor> list;
        list = new ArrayList<>();
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return list;
        }
        try {
            String QUERY = "exec dbo.listaProv";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                listaProveedor proveedor = new listaProveedor();
                proveedor.setId(resultSet.getInt("id"));
                proveedor.setIdProveedor(resultSet.getInt("idProveedor"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setRfc(resultSet.getString("rfc"));
                proveedor.setActEconomica(resultSet.getString("actividadEconomica"));
                proveedor.setRegistroSefiplan(resultSet.getString("registroSefiplan"));


                list.add(proveedor);
            }
            return list;

        } catch (SQLException erro) {
            Toast.makeText(p, "ocurrio un error: " + erro, Toast.LENGTH_LONG).show();
            return list;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("CONEXAO_MSSQL", e.getMessage());
            }
        }
    }

    public boolean bajaProv(Context p, int idP){
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            String queryDelete = "exec dbo.eliminarProveedor  ?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
            preparedStatement.setInt(1, idP);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
            }
        }
    }

    public proveedorF buscarF(Context p, int id){
        proveedorF pF = new proveedorF();
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return pF;
        }
        try {
            String QUERY = "exec dbo.buscarProvF " + id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                pF.setId(resultSet.getInt("id"));
                pF.setNombre(resultSet.getString("nombre"));
                pF.setApellidoUno(resultSet.getString("apellidoUno"));
                pF.setApellidoDos(resultSet.getString("apellidoDos"));
                pF.setRfc(resultSet.getString("rfc"));
                pF.setActividadEconomica(resultSet.getString("actividadEconomica"));
                pF.setRegistro(resultSet.getString("registro"));
                pF.setNumeroContacto(resultSet.getString("numeroContacto"));
                pF.setCorreo(resultSet.getString("correo"));
                pF.setDireccion(resultSet.getString("direccion"));
                pF.setEntidadFederativa(resultSet.getInt("entidadFedrativa"));
                pF.setMunicipio(resultSet.getInt("municipio"));
            }
            return pF;


        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return pF;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
            }
        }
    }

    public proveedorM buscarM(Context p, int id){
        proveedorM pF = new proveedorM();
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return pF;
        }
        try {
            String QUERY = "exec dbo.buscarProvM " + id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                pF.setId(resultSet.getInt("id"));
                pF.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
                pF.setNombreApoderado(resultSet.getString("nombre"));
                pF.setApellidUno(resultSet.getString("apellidoUno"));
                pF.setApellidoDos(resultSet.getString("apellidoDos"));
                pF.setRfc(resultSet.getString("rfc"));
                pF.setActividadEconomica(resultSet.getString("actividadEconomica"));
                pF.setRegistro(resultSet.getString("registro"));
                pF.setTelefono(resultSet.getString("telefono"));
                pF.setCorreo(resultSet.getString("correo"));
                pF.setDireccion(resultSet.getString("direccion"));
                pF.setEntidadFederativa(resultSet.getInt("entidadFedrativa"));
                pF.setMunicipio(resultSet.getInt("municipio"));
            }
            return pF;


        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return pF;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
            }
        }
    }

    public boolean updateProvF(Context p,  proveedorF prov){
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            String queryDelete = "exec dbo.modificarProveedorFisico  ?,?,?,?,?,?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
            preparedStatement.setString(1, prov.getDireccion());
            preparedStatement.setInt(2, prov.getEntidadFederativa());
            preparedStatement.setInt(3, prov.getMunicipio());
            preparedStatement.setString(4, prov.getNumeroContacto());
            preparedStatement.setString(5, prov.getCorreo());
            preparedStatement.setInt(6, prov.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //return true;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    return true;
                }
                return true;
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
                return false;
            }
        }
    }

    public boolean updateProvM(Context p,  proveedorM prov){
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            String queryDelete = "exec dbo.modificarProveedorMoral  ?,?,?,?,?,?,?,?,?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
            preparedStatement.setString(1, prov.getDireccion());
            preparedStatement.setInt(2, prov.getEntidadFederativa());
            preparedStatement.setInt(3, prov.getMunicipio());
            preparedStatement.setString(4, prov.getNombreApoderado());
            preparedStatement.setString(5, prov.getApellidUno());
            preparedStatement.setString(6, prov.getApellidoDos());
            preparedStatement.setString(7, prov.getTelefono());
            preparedStatement.setString(8, prov.getCorreo());
            preparedStatement.setInt(9, prov.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //return true;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    return true;
                }
                return true;
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
                return false;
            }
        }
    }

    public boolean crearProvF(crearProfveedorF p, proveedorF prov){
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            String queryDelete = "exec dbo.insertarProveedorFisico  ?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
            preparedStatement.setString(1, prov.getRegimen());
            preparedStatement.setString(2, prov.getRfc());
            preparedStatement.setString(3, prov.getActividadEconomica());
            preparedStatement.setString(4, prov.getDireccion());
            preparedStatement.setString(5, prov.getRegistro());
            if(prov.getEntidadFederativa()==0){preparedStatement.setString(6,null);}
            else{preparedStatement.setInt(6, prov.getEntidadFederativa());}
            if(prov.getMunicipio()==0){preparedStatement.setString(7,null);}
            else{preparedStatement.setInt(7, prov.getMunicipio());}
            preparedStatement.setString(8, prov.getNombre());
            preparedStatement.setString(9, prov.getApellidoUno());
            preparedStatement.setString(10, prov.getApellidoDos());
            preparedStatement.setString(11, prov.getNumeroContacto());
            preparedStatement.setString(12, prov.getCorreo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //return true;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    return true;
                }
                return true;
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
                return false;
            }
        }
        //return false;
    }

    public boolean crearProvM(Context p, proveedorM prov){
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            String queryDelete = "exec dbo.insertarProveedorMoral  ?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
            preparedStatement.setString(1, prov.getRegimen());
            preparedStatement.setString(2, prov.getRfc());
            preparedStatement.setString(3, prov.getActividadEconomica());
            preparedStatement.setString(4, prov.getDireccion());
            preparedStatement.setString(5, prov.getRegistro());
            preparedStatement.setInt(6, prov.getEntidadFederativa());
            preparedStatement.setInt(7, prov.getMunicipio());
            preparedStatement.setString(8, prov.getNombreApoderado());
            preparedStatement.setString(9, prov.getApellidUno());
            preparedStatement.setString(10, prov.getApellidoDos());
            preparedStatement.setString(11, prov.getTelefono());
            preparedStatement.setString(12, prov.getCorreo());
            preparedStatement.setString(13, prov.getNombreEmpresa());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //return true;

        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    return true;
                }
                return true;
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
                return false;
            }
        }
        //return false;
    }

    public int tipoProv(Context p,int id){
        String a;
        int b = 0;
        Connection conn = ConexionBD.Conn();
        if(conn == null) {
            Toast.makeText(p, "Error al conectar", Toast.LENGTH_LONG).show();
            return 0;
        }
        try {
            String QUERY = "exec dbo.tipoProv " + id;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while(resultSet.next()) {
                a = resultSet.getString("regimen");

                if(a.equals("Física")){
                    b= 1;
                } else if (a.equals("Moral")) {
                    b= 2;
                }
                else {b= 0;}
            }
            return b;


        } catch (SQLException erro) {
            Toast.makeText(p, "Ocurrió un error: " + erro, Toast.LENGTH_LONG).show();
            return 0;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Log.d("Conexión SQL", e.getMessage());
            }
        }
    }

}
