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
public class DAOEmpleado implements IDAOGeneral<Empleado>{
    
    PreparedStatement pst;
    ResultSet rs;
    ConexionPostgres conexion = new ConexionPostgres();

    //Terminado el metodo guardar
    @Override
    public boolean guardar(Empleado pojo) {
        String sql = "INSERT INTO empleados (clave, nombre, direccion, telefono) values (?,?,?,?)";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
            pst.setString(3, pojo.getDireccion());
            pst.setString(4, pojo.getTelefono());
            
            pst.executeUpdate();
            
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al insertar el empleado "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    //Terminado el metodo modificar
    @Override
    public boolean modificar(Empleado pojo) {
        String sql = "UPDATE empleados SET nombre = ?, direccion = ?, telefono = ?  WHERE clave = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            
            pst.setString(1, pojo.getNombre());
            pst.setString(2, pojo.getDireccion());
            pst.setString(3, pojo.getTelefono());
            pst.setString(4, pojo.getClave());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al actualizar el empleado "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    //Terminado el metodo eliminar
    @Override
    public boolean eliminar(String clave) {
        String sql = "DELETE from empleados WHERE clave = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, clave);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al eliminar el empleado "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    
    @Override
    public Empleado buscarByid(String clave) {
        Empleado empleado=null;
        return empleado;
    }
    

    
    @Override
    public List<Empleado> Consultar() {
        List<Empleado> listEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Empleado emp = new Empleado();
                emp.setClave(rs.getString("clave"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setTelefono(rs.getString("telefono"));
                
                listEmpleados.add(emp); 
            }
            rs.close();
            pst.close();
            
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return listEmpleados;
    }
    
}
