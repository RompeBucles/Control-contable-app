package com.example.controlcontableapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    static String ip = "192.168.1.116";
    static String class_driver = "net.sourceforge.jtds.jdbc.Driver";
    static String BD = "controlContable";

    static String usuario = "inv";
    static String password = "12345678";

    public static Connection Conn() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String URL_CONEXAO;

        try {

            Class.forName(class_driver);
            URL_CONEXAO = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + BD + ";"
                    + "user=" + usuario + ";"
                    + "password=" + password + ";";

            conn = DriverManager.getConnection(URL_CONEXAO);
        } catch (SQLException erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        } catch (ClassNotFoundException erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        } catch (Exception erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        }

        return conn;
    }

}
