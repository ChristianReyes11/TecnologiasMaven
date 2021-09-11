/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christian.interfaces;

import java.util.List;

/**
 *
 * @author FERNANDO-SOPORTE
 */
public interface IDAOGeneral <T>{
//    Método para Guardar 
    public boolean guardar(T pojo);
    
//    Método para Modificar
    public boolean modificar(T pojo);
    
//    Método para Eliminar
    public boolean eliminar(String clave);
    
//    Método para buscar por ID
    public T buscarByid(String clave);
    
//    Método para Buscar todo
    public List<T> Consultar();
}
