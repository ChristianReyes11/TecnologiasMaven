/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christian.DAO;

import com.christian.modelos.*;
import com.christian.conexionBD.ConexionPostgres;
import com.christian.interfaces.IDAOGeneral;
import com.christian.vistas.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FERNANDO-SOPORTE
 */
public class DAODepartamento implements IDAOGeneral<Departamento>{
    
    PreparedStatement pst;
    ResultSet rs;
    ConexionPostgres conexion = new ConexionPostgres();

    //Listo
    @Override
    public boolean guardar(Departamento pojo) {
        String sql = "INSERT INTO departamentos (clave, nombre,VALUES(?,?)";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al insertar el departamento "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    //Listo
    @Override
    public boolean modificar(Departamento pojo) {
        String sql = "UPDATE departamentos SET nombre = ? WHERE clave = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            
            pst.setString(1, pojo.getNombre());
            pst.setString(2, pojo.getClave());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al actualizar el departamento "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    //Listo
    @Override
    public boolean eliminar(String clave) {
        String sql = "DELETE from departamentos WHERE clave = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, clave);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al eliminar el departamento "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    
    @Override
    public Departamento buscarByid(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Listo
    @Override
    public List<Departamento> Consultar() {
        List<Departamento> listDepto = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Departamento dep = new Departamento();
                dep.setClave(rs.getString("clave"));
                dep.setNombre(rs.getString("nombre"));
                
                listDepto.add(dep); 
            }
            rs.close();
            pst.close();
            
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return listDepto;
    }
    
    
}
