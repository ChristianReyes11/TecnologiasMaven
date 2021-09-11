/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christian.vistas;

import javax.swing.*;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.table.*;
import com.christian.DAO.*;
import com.christian.modelos.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author FERNANDO-SOPORTE
 */
public class EmpleadosGUI extends javax.swing.JInternalFrame {
    
    Empleado empleado = new Empleado();
    DAOEmpleado daoEmpleado = new DAOEmpleado();

    /**
     * Creates new form EmpleadosGUI
     */
    public EmpleadosGUI() {
        initComponents();
    }
    
    //Método para Guardar un empleado en la base de datos
    void Guardar(){
        String clave = txtClave.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDirección.getText();
        String telefono = txtTeléfono.getText();
        
        //validamos los campos a enviar a la base de datos
        if (clave.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Hay campos sin llenar *");
        } else {
            Empleado e = new Empleado();
            e.setClave(clave);
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            if (daoEmpleado.guardar(e)) {
                JOptionPane.showMessageDialog(null, "Registro guardado con exito...");
            }
        }
    }
    
    //Método para Eliminar un empleado de la base de datos
    void Eliminar(){
        String clave = txtClave.getText();

        if (txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor debe seleccionar un articulo de la lista");
        } else {
            if (daoEmpleado.eliminar(clave)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado con exito...");
            }
        }
    }
    
    //Método para limpiar los campos para poder ingresar un nuevo empleado
    void Limpiar(){
        txtClave.setText("");
        txtNombre.setText("");
        txtDirección.setText("");
        txtTeléfono.setText("");
    }
    
    
    void BuscarByID(){
        
    }
    
    //Método para consultar a todos los empleados de la base de datos
    void Consultar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clave");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        tableEmp.setModel(modelo);
        String datos[] = new String[4];
        Connection base = null;
        Statement at = null;
        String url = "jdbc:postgresql://localhost:5432/crud_christian01";
        try{
            base = DriverManager.getConnection(url,"postgres","postgres");
            at = base.createStatement();
            ResultSet rs = at.executeQuery("Select * From empleados");
            while(rs.next()){
                datos[0] = rs.getString("Clave");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Direccion");
                datos[3] = rs.getString("Telefono");
                modelo.addRow(datos);
            }
            JOptionPane.showMessageDialog(null, "Acepta para continuar.");
            rs.close();
            at.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    void Modificar(){
        String clave = txtClave.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDirección.getText();
        String telefono = txtTeléfono.getText();

        //validamos los campos a enviar a la base de datos
        if (clave.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor valide los datos a enviar a la Base de Datos");
        } else {
            Empleado e = new Empleado();
            e.setClave(clave);
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            if (daoEmpleado.modificar(e)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado con exito...");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClave = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDirección = new javax.swing.JLabel();
        lblTeléfono = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDirección = new javax.swing.JTextField();
        txtTeléfono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscarID = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        lblCamposObligatorios = new javax.swing.JLabel();

        setClosable(true);

        lblClave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClave.setText("Clave: *");
        lblClave.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre: *");
        lblNombre.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblDirección.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDirección.setText("Dirección: *");
        lblDirección.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTeléfono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTeléfono.setText("Teléfono: *");
        lblTeléfono.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscarID.setText("Buscar Id");
        btnBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIDActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Dirección", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEmp);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblCamposObligatorios.setText("* Campos obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTeléfono)
                            .addComponent(lblDirección, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtClave)
                            .addComponent(txtNombre)
                            .addComponent(txtDirección)
                            .addComponent(txtTeléfono, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnBuscarID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCamposObligatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscarID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirección)
                    .addComponent(txtDirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTeléfono)
                        .addComponent(txtTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCamposObligatorios, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnBuscarIDActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Guardar();
        Limpiar();
        Consultar();
        //Listo
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Limpiar();
        //Listo
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Eliminar();
        Limpiar();
        Consultar();
        //Listo
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        Consultar();
        Limpiar();
        //Listo
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        Modificar();
        Limpiar();
        Consultar();
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarID;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCamposObligatorios;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblDirección;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTeléfono;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDirección;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTeléfono;
    // End of variables declaration//GEN-END:variables
}
