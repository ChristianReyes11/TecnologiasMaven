/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christian.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author FERNANDO-SOPORTE
 */
public class ConexionPostgres {
    private String URL = "jdbc:postgresql://localhost:5432/crud_christian01";
    private String USER = "postgres";
    private String PASSWORD = "postgres";
    
    private Connection con = null;
    
    public Connection Conexion(){
        
        
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error en la conexion "+e.getMessage());
        }
        return con;
    }
    
    public void Desconectar(){
        if (con != null) {
            try {
                con.close();
                System.out.println("Desconectado");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }
    
//    public ResulSet select(SelectDB select){
//        return select.executeQuery(cx);
//    }
}
