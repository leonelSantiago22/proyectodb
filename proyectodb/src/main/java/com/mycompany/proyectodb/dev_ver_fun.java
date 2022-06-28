/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodb;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonel
 */
public class dev_ver_fun {
    int sum;
    String version_id;
    String juego;
    String plataforma;
    String modelo;
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getVersion_id() {
        return version_id;
    }

    public void setVersion_id(String version_id) {
        this.version_id = version_id;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void mostrar_dec(JTable paramostrar)
    {
        coneccion objetoConexion = new coneccion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "";
    sql = "SELECT sum(t.monto),v.version_id,v.juego,v.plataforma,p.modelo FROM transaccion t,modalidad_pago m,version v,plataforma p WHERE m.version_id=v.version_id AND m.id_pago=t.id_pago AND v.plataforma=p.nombre GROUP BY (v.version_id,v.juego,p.nombre,p.modelo ) ORDER BY sum(t.monto) DESC ;";
        modelo.addColumn("sum");
        modelo.addColumn("version_id");
        modelo.addColumn("juego");
        modelo.addColumn("plataforma");
        modelo.addColumn("modelo");
        
        paramostrar.setModel(modelo);
        String [] datos = new String[5];
        
        Statement st;
        try 
        {
            st = objetoConexion.establecerConecxionstatic().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            paramostrar.setModel(modelo);     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.toString());
        }
    }
}
