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
    int fecha_nacimiento;
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

    public int getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(int fecha_nacimiento) {
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
            
        }catch(Exception e){
                
        }
    }
}
