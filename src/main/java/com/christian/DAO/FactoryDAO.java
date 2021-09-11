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

/**
 *
 * @author FERNANDO-SOPORTE
 */
public class FactoryDAO {
    public enum Type{EMPLEADO,DEPARTAMENTO};
    public static IDAOGeneral create(Type type){
        IDAOGeneral dao = null;
        switch(type){
            case DEPARTAMENTO:
                dao=new DAODepartamento();
            break;
            case EMPLEADO:
                dao=new DAOEmpleado();
            break;
        }
        return dao;
    }
}
