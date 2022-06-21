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
public class usarios {
    String nickname;
    String fecha_nacimiento;
    String email;
    String nombre;
    String telefono;
    String plataforma;
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPlataforma() {
        return plataforma;
    }

    //creacion de los getters y setters
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public void Mostrarusuarios(JTable paraTotalDeUsuarios){
        coneccion objetoConexion = new coneccion();
        
        DefaultTableModel modelo = new DefaultTableModel(); 
        
        String sql ="";
        modelo.addColumn(nickname);
        modelo.addColumn(plataforma);
        
        paraTotalDeUsuarios.setModel(modelo);
        
        //sql2 = ""
        
        sql = "select nickname,plataforma from usuario;";
        //incorporar las vueltas que hay que incorporar en la tabla 
        String [] datos = new String[2];
        
        Statement st;
        
        try{
            //me va a lanzar un resultado
            st = objetoConexion.establecerConecxionstatic().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                
                modelo.addRow(datos);
            }
            paraTotalDeUsuarios.setModel(modelo);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error: "+ e.toString());
        }
    }
    public void inserta_usuario(JTextField nickname_recibido, JTextField email_recibido, JTextField nombre_recibido, JTextField fecha_nac_recibida, JTextField telefono_recibido, JTextField plataforma_recibida)
    {
             setNickname(nickname_recibido.getText());
            setEmail(email_recibido.getText());
            setNombre(nombre_recibido.getText());
            setFecha_nacimiento(fecha_nac_recibida.getText());
            setTelefono(telefono_recibido.getText());
            setPlataforma(fecha_nac_recibida.getText());
             coneccion objetoConexion = new coneccion();
             String consulta=" INSERT INTO usuario(nickname,email,nombre,fecha_nac,telefono,plataforma) \n" +
"      VALUES (?,?,?,?,?,?);" ; //donde va a estar guardada la consulta 
             
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNickname());
                 cs.setString(2,getEmail());
                 cs.setString(3,getNombre());
                 cs.setString(4,getFecha_nacimiento());
                 cs.setString(5,getTelefono());
                 cs.setString(6,getPlataforma());
                 
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "Usuario ingresado correctament");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "No se pudo ingresar al usuario");
             }
             
    }
    
    //funcion de
    public void seleccionar_alumno(JTable tabla_recibida,JTextField nickname_recibido, JTextField email_recibido, JTextField nombre_recibido, JTextField fecha_nac_recibida, JTextField telefono_recibido, JTextField plataforma_recibida )
    {
        try{
            int fila = tabla_recibida.getSelectedRow();
            
            if(fila>=0){
                nickname_recibido.setText(tabla_recibida.getValueAt(fila, 0).toString());
                email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                 email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                 email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                 email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                
            }else{
                JOptionPane.showMessageDialog(null, "Valio madre banda fila no seleccionada");
            }
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Valio madre banda"+e.toString());
        }
    }
    
    
    
    
    
}



