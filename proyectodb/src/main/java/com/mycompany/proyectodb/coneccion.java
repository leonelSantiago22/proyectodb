/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodb;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Leonel
 */
public class coneccion {
   Connection conectar = null;
   
   String usuario = "postgres";
<<<<<<< HEAD
   String contrasena = "root";
   String bd = "proyecto_db";//nombre de la base de datos 
=======
   //String contrasena = "Mr.Robot";
   //String bd = "proyectoBD";//nombre de la base de datos 
>>>>>>> 4f9cdf25bfae78391727966b3b702acde7c5f8ac
   String ip ="localhost";
   String puerto = "5433";
   
   String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
   
   public Connection establecerConecxionstatic(){
        try{
               Class.forName("org.postgresql.Driver");
               
               conectar = DriverManager.getConnection(cadena, usuario, contrasena);
               //JOptionPane.showMessageDialog(null,"Se conecto Correctamente a la Base De Datos");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error En la coneecion a la base de datos"+e.toString());
        }
        return conectar;
   }
}
