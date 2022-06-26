/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectodb;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class plataforma {
    
    String nombre_plataforma;
    String modelo_plataforma;
    Date fecha_lanzamiento_plataforma;

    public String getNombre_plataforma() {
        return nombre_plataforma;
    }

    public void setNombre_plataforma(String nombre_plataforma) {
        this.nombre_plataforma = nombre_plataforma;
    }

    public String getModelo_plataforma() {
        return modelo_plataforma;
    }

    public void setModelo_plataforma(String modelo_plataforma) {
        this.modelo_plataforma = modelo_plataforma;
    }

    public Date getFecha_lanzamiento_plataforma() {
        return fecha_lanzamiento_plataforma;
    }

    public void setFecha_lanzamiento_plataforma(Date fecha_lanzamiento_plataforma) {
        this.fecha_lanzamiento_plataforma = fecha_lanzamiento_plataforma;
    }
    
    
      public void Mostrarplataforma(JTable paraTotalDePlataforma){
        coneccion objetoConexion = new coneccion();
        
        DefaultTableModel modelo = new DefaultTableModel(); 
        
        
        String sql =" ";
        modelo.addColumn(nombre_plataforma);
        modelo.addColumn(modelo_plataforma);
        modelo.addColumn(fecha_lanzamiento_plataforma);
        paraTotalDePlataforma.setModel(modelo);
        
        //sql2 = ""
        
        sql = "select nombre,modelo,fecha_lanzamiento from plataforma;";
        //incorporar las vueltas que hay que incorporar en la tabla 
        String [] datos = new String[3];
        
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
                
                modelo.addRow(datos);
            }
            paraTotalDePlataforma.setModel(modelo);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error en vista de plataforma: "+ e.toString());
        }
    }
      
      
     public void inserta_plataforma(JTextField nombre_plataforma, JTextField modelo_recibida, JTextField fecha_recibida)
    {
            setNombre_plataforma(nombre_plataforma.getText());
            setModelo_plataforma(modelo_recibida.getText());
            setFecha_lanzamiento_plataforma(Date.valueOf(fecha_recibida.getText()));
      
             coneccion objetoConexion = new coneccion();
             String consulta="INSERT INTO plataforma(nombre,modelo,fecha_lanzamiento)VALUES (?,?,?);" ; //donde va a estar guardada la consulta 
             
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_plataforma());
                 cs.setString(2,getModelo_plataforma());
                 cs.setDate(3, getFecha_lanzamiento_plataforma());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Plataforma insertada correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "No se inserto correctamente" + e.toString());
             }
             
    }
     
      
    public void seleccionar_plataforma(JTable tabla_recibida, JTextField nombre_plataforma, JTextField modelo_recibido, JTextField fecha_recibida)
    {
        try{
            int fila = tabla_recibida.getSelectedRow();
            
            if(fila>=0){
                nombre_plataforma.setText(tabla_recibida.getValueAt(fila, 0).toString());
                modelo_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                fecha_recibida.setText(tabla_recibida.getValueAt(fila, 2).toString());
               
                
            }else{
                JOptionPane.showMessageDialog(null, "No se seleciono la fila");
            }
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Algo ocurrio no funciono"+e.toString());
        }
    }
    
    
    public void modificar_juego(JTextField nombre_plataforma, JTextField modelo_recibido, JTextField fecha_recibida)
    {
            setNombre_plataforma(nombre_plataforma.getText());
              setModelo_plataforma(modelo_recibido.getText());
            setFecha_lanzamiento_plataforma(Date.valueOf(fecha_recibida.getText()));
            coneccion objetoConexion = new coneccion();
            String consulta="UPDATE plataforma SET nombre=?, modelo=?, fecha_lanzamiento=? WHERE plataforma.nombre=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_plataforma());
                 cs.setString(2,getModelo_plataforma());
                 cs.setDate(3,getFecha_lanzamiento_plataforma());
                 cs.setString(4, getNombre_plataforma());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Plataforma modificada correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "No se pudo modificar la plataforma"+e.toString());
             }
    }
    
    public void eliminar_juego(JTextField nombre_plataforma)
    {
        setNombre_plataforma(nombre_plataforma.getText());
            coneccion objetoConexion = new coneccion();
            String consulta="DELETE FROM plataforma WHERE plataforma.nombre=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNombre_plataforma());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Se elimino la Plataforma correctamente");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "No se pudo eliminar la plataforma "+e.toString());
             }
    }
    
      
      
      
}
