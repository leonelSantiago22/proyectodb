/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodb;

import java.net.ConnectException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonel
 */
public class version {
        String version_id;
        String requisito;
        int anio_creacion;
        String juego;
        String plataforma;
    public String getVersion_id() {
        return version_id;
    }

    public void setVersion_id(String version_id) {
        this.version_id = version_id;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public int getAnio_creacion() {
        return anio_creacion;
    }

    public void setAnio_creacion(int anio_creacion) {
        this.anio_creacion = anio_creacion;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }   
    public void Mostrar_Versiones(JTable paraMostrarVersiones)
    {
            coneccion objetoConexion = new coneccion();
            DefaultTableModel modelo = new DefaultTableModel(); 
            
            String sql ="";
            
            modelo.addColumn(version_id);
            modelo.addColumn(requisito);
            modelo.addColumn(anio_creacion);
            modelo.addColumn(juego);
            modelo.addColumn(plataforma);
            paraMostrarVersiones.setModel(modelo);
            
            sql = "select version_id,requisito,año_creacion,juego,plataforma from version";
            
            String [] datos = new String [5];
            Statement st; 
            
            try{
                st = objetoConexion.establecerConecxionstatic().createStatement();
                
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next())
                {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    
                    modelo.addRow(datos);
                }
                paraMostrarVersiones.setModel(modelo);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+ e.toString());
        }
    }
    public void selecccionar_version(JTable tabla_recibida,JTextField version_text, JTextField requisito_text, JTextField creacion_text, JTextField juego_text, JTextField plataforma_text)
    {
        try{
            int fila = tabla_recibida.getSelectedRow();
           if(fila>=0){ 
               version_text.setText(tabla_recibida.getValueAt(fila, 0).toString());
               requisito_text.setText(tabla_recibida.getValueAt(fila, 1).toString());
               creacion_text.setText(tabla_recibida.getValueAt(fila, 2).toString());
               juego_text.setText(tabla_recibida.getValueAt(fila, 3).toString());
               plataforma_text.setText(tabla_recibida.getValueAt(fila, 4).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Valio madre banda fila no seleccionada");
            }
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Valio madre banda"+e.toString());
        }
    }

    public void insertar_verison(JTextField version_text, JTextField requisito_text, JTextField creacion_text, JTextField juego_text, JTextField plataforma_text)
    {
        setVersion_id(version_text.getText());
        setRequisito(requisito_text.getText());
        setAnio_creacion(Integer.parseInt(creacion_text.getText()));
        setJuego(juego_text.getText());
        setPlataforma(plataforma_text.getText());
        coneccion objConexion = new coneccion();
        String consulta = "INSERT INTO version(version_id,requisito,año_creacion,juego,plataforma) VALUES(?,?,?,?,?);";
        try {
            CallableStatement cs = objConexion.establecerConecxionstatic().prepareCall(consulta);
            cs.setString(1, getVersion_id());
            cs.setString(2, getRequisito());
            cs.setInt(3, getAnio_creacion());
            cs.setString(4, getJuego());
            cs.setString(5, getPlataforma());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se INSERTO correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valio coliflor "+e.toString());
        }
    }
    
    public void modificar_version(JTextField version_text, JTextField requisito_text, JTextField creacion_text, JTextField juego_text, JTextField plataforma_text)
    {
        setVersion_id(version_text.getText());
        setRequisito(requisito_text.getText());
        setAnio_creacion(Integer.parseInt(creacion_text.getText()));
        setJuego(juego_text.getText());
        setPlataforma(plataforma_text.getText());
        coneccion objConexion = new coneccion();
        String consulta = "UPDATE version SET version_id = ?, requisito = ?, año_creacion = ?, juego = ?, plataforma = ? WHERE version_id = ?;";
        try {
            CallableStatement cs = objConexion.establecerConecxionstatic().prepareCall(consulta);
            cs.setString(1, getVersion_id());
            cs.setString(2, getRequisito());
            cs.setInt(3, getAnio_creacion());
            cs.setString(4, getJuego());
            cs.setString(5, getPlataforma());
            cs.setString(6, getVersion_id());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se modifico correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valio coliflor "+e.toString());
        }
    }
    public void eliminar_version(JTextField version_text)
    {
        setVersion_id(version_text.getText());
        coneccion objConeccion = new coneccion();
        String consulta = "DELETE FROM version where version.version_id = ?;";
        try {
            CallableStatement cs = objConeccion.establecerConecxionstatic().prepareCall(consulta);
            cs.setString(1, getVersion_id());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se borro el dato "+getVersion_id()+"Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valio colaaa "+e.toString());
        }
    }
}
