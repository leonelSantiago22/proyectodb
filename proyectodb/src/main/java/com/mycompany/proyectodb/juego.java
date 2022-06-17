/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodb;


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Leonel
 */
public class juego {
    
    String nombre_juego2;
    String clasificacion_juego;
    String genero_juego;
    String descripcion_juego;
      

    public String getNombre_juego() {
        return nombre_juego2;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego2 = nombre_juego;
    }

    public String getClasificacion_juego() {
        return clasificacion_juego;
    }

    public void setClasificacion_juego(String clasificacion_juego) {
        this.clasificacion_juego = clasificacion_juego;
    }

    public String getGenero_juego() {
        return genero_juego;
    }

    public void setGenero_juego(String genero_juego) {
        this.genero_juego = genero_juego;
    }

    public String getDescripcion_juego() {
        return descripcion_juego;
    }

    public void setDescripcion_juego(String descripcion_juego) {
        this.descripcion_juego = descripcion_juego;
    }
    
    public void Mostrarusuarios(JTable paraTotalDeUsuarios){
        coneccion objetoConexion = new coneccion();
        
        DefaultTableModel modelo = new DefaultTableModel(); 
        
        
        String sql ="";
        modelo.addColumn(nombre_juego2);
        modelo.addColumn(clasificacion_juego);
        modelo.addColumn(genero_juego);
        modelo.addColumn(descripcion_juego);
        paraTotalDeUsuarios.setModel(modelo);
        
        //sql2 = ""
        
        sql = "select nombre_juego,clasificacion,genero,descripcion from juego;";
        //incorporar las vueltas que hay que incorporar en la tabla 
        String [] datos = new String[4];
        
        Statement st;
        
        try{
            //me va a lanzar un resultado
            st = objetoConexion.establecerConecxionstatic().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                
                modelo.addRow(datos);
            }
            paraTotalDeUsuarios.setModel(modelo);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+ e.toString());
        }
    }
    public void inserta_juego(JTextField nombre_juego, JTextField clasificacion_recibida, JTextField genero_recibido, JTextField descripcion_recibida)
    {
            setNombre_juego(nombre_juego.getText());
            setClasificacion_juego(clasificacion_recibida.getText());
            setGenero_juego(genero_recibido.getText());
            setDescripcion_juego(descripcion_recibida.getText());
             coneccion objetoConexion = new coneccion();
             String consulta=" INSERT INTO juego(nombre_juego,clasificacion,genero,descripcion) \n" +
"      VALUES (?,?,?,?);" ; //donde va a estar guardada la consulta 
             
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_juego());
                 cs.setString(2,getClasificacion_juego());
                 cs.setString(3,getGenero_juego());
                 cs.setString(4,getDescripcion_juego());
                 
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Se modifico el juego correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "Valio madre banda");
             }
             
    }
    
    public void seleccionar_alumno(JTable tabla_recibida, JTextField nombre_juego, JTextField clasificacion_recibida, JTextField genero_recibido, JTextField descripcion_recibida )
    {
        try{
            int fila = tabla_recibida.getSelectedRow();
            
            if(fila>=0){
                nombre_juego.setText(tabla_recibida.getValueAt(fila, 0).toString());
                clasificacion_recibida.setText(tabla_recibida.getValueAt(fila, 1).toString());
                genero_recibido.setText(tabla_recibida.getValueAt(fila, 2).toString());
                descripcion_recibida.setText(tabla_recibida.getValueAt(fila, 3).toString());
                
            }else{
                JOptionPane.showMessageDialog(null, "Valio madre banda fila no seleccionada");
            }
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Valio madre banda"+e.toString());
        }
    }
    
    public void modificar_juego(JTextField nombre_juego, JTextField clasificacion_recibida, JTextField genero_recibido, JTextField descripcion_recibida)
    {
            setNombre_juego(nombre_juego.getText());
            setClasificacion_juego(clasificacion_recibida.getText());
            setGenero_juego(genero_recibido.getText());
            setDescripcion_juego(descripcion_recibida.getText());
            coneccion objetoConexion = new coneccion();
            String consulta="UPDATE juego SET nombre_juego=?, clasificacion=?, genero=?, descripcion=? WHERE juego.nombre_juego=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_juego());
                 cs.setString(2,getClasificacion_juego());
                 cs.setString(3,getGenero_juego());
                 cs.setString(4,getDescripcion_juego());
                 cs.setString(5,getNombre_juego());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Se inserto el juego correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "Valio madre banda"+e.toString());
             }
    }
    public void eliminar_juego(JTextField nombre_juego)
    {
        setNombre_juego(nombre_juego.getText());
            coneccion objetoConexion = new coneccion();
            String consulta="DELETE FROM juego WHERE juego.nombre_juego=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_juego());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Se elimino el juego correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "Valio madre banda"+e.toString());
             }
    }
 
}
