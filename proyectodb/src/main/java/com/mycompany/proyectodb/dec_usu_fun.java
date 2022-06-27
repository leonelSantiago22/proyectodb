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
public class dec_usu_fun {
    int sum; 
    String nickname;
    String nombre;
    String email;
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void mostrar_dec(JTable paramostrar)
    {
        coneccion objetoConexion = new coneccion();
        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";
        modelo.addColumn(sum);
        modelo.addColumn(nickname);
        modelo.addColumn(nombre);
        modelo.addColumn(email);

        sql = "SELECT sum(t.monto),u.nickname,u.nombre,u.email FROM transaccion t,usuario u WHERE u.nickname=t.nickname GROUP BY (u.nickname) ORDER BY sum(t.monto) DESC ; ";

        paramostrar.setModel(modelo);

        String [] datos = new String[4];
        
        Statement st;
        
        try{
            //me va a lanzar un resultado
            st = objetoConexion.establecerConecxionstatic().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                modelo.addRow(datos);
            }
            paramostrar.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error no se pudo mostrar"+e.toString());
        }
    }
}
