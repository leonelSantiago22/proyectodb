
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
    Date fecha_nacimiento;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
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
        modelo.addColumn("nickname");
        modelo.addColumn("email");
        modelo.addColumn("nombre");
        modelo.addColumn("fecha_nacimiento");
        modelo.addColumn("telefono");
        modelo.addColumn("plataforma");
        
        
        paraTotalDeUsuarios.setModel(modelo);
        
        sql = "select nickname,email,nombre,fecha_nac,telefono,plataforma from usuario;";
        //incorporar las vueltas que hay que incorporar en la tabla 
        String [] datos = new String[6];
        
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
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
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
            setFecha_nacimiento(Date.valueOf(fecha_nac_recibida.getText()));
            setTelefono(telefono_recibido.getText());
            setPlataforma(plataforma_recibida.getText());
             coneccion objetoConexion = new coneccion();
             String consulta=" INSERT INTO usuario(nickname,email,nombre,fecha_nac,telefono,plataforma) VALUES (?,?,?,?,?,?);" ; //donde va a estar guardada la consulta 
             
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNickname());
                 cs.setString(2,getEmail());
                 cs.setString(3,getNombre());
                 cs.setDate(4,getFecha_nacimiento());
                 cs.setString(5,getTelefono());
                 cs.setString(6,getPlataforma());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "USUARIO INGRESADO CORRECTAMENTE");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "NO SE PUDO INGRESAR AL USUARIO CORRECTAMENTE"+e.toString());
             }
             
    }
    
    //funcion de
    public void seleccionar_usuario(JTable tabla_recibida,JTextField nickname_recibido, JTextField email_recibido, JTextField nombre_recibido, JTextField fecha_nac_recibida, JTextField telefono_recibido, JTextField plataforma_recibida )
    {
        try{
            int fila = tabla_recibida.getSelectedRow();
            
            if(fila>=0){
                nickname_recibido.setText(tabla_recibida.getValueAt(fila, 0).toString());
                email_recibido.setText(tabla_recibida.getValueAt(fila, 1).toString());
                 nombre_recibido.setText(tabla_recibida.getValueAt(fila, 2).toString());
                 fecha_nac_recibida.setText(tabla_recibida.getValueAt(fila, 3).toString());
                telefono_recibido.setText(tabla_recibida.getValueAt(fila, 4).toString());
                 plataforma_recibida.setText(tabla_recibida.getValueAt(fila, 5).toString());
                
            }else{
                JOptionPane.showMessageDialog(null, "FILA CORRECTAMENTE SELECCIONADA");
            }
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "NO SE PUDO SELECCIONAR LA FILA DESEADA"+e.toString());
        }
    }
       
        
        
    public void modificar_usuario(JTextField nickname_recibido, JTextField email_recibido, JTextField nombre_recibido, JTextField fecha_nac_recibida, JTextField telefono_recibido, JTextField plataforma_recibida)
    {
            setNickname(nickname_recibido.getText());
            setEmail(email_recibido.getText());
            setNombre(nombre_recibido.getText());
            setFecha_nacimiento(Date.valueOf(fecha_nac_recibida.getText()));
            setTelefono(telefono_recibido.getText());
            setPlataforma(fecha_nac_recibida.getText());
             coneccion objetoConexion = new coneccion();
            String consulta="UPDATE usuario SET nickname=?, email=?, nombre=?, fecha_nac=?, telefono=?,plataforma=? WHERE usuario.nickname=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNickname());
                 cs.setString(2,getEmail());
                 cs.setString(3,getNombre());
                 cs.setDate(4,getFecha_nacimiento());
                 cs.setString(5,getTelefono());
                 cs.setString(6,getPlataforma());
                 cs.setString(7, getNickname());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO CORRECTAMENTE");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR AL USUARIO SELECCIONADO"+e.toString());
             }
    }
        
        
    public void eliminar_usuario(JTextField nickname)
    {
        setNickname(nickname.getText());
            coneccion objetoConexion = new coneccion();
            String consulta="DELETE FROM usuario WHERE usuario.nickname=?; " ; //donde va a estar guardada la consulta 
             try{
                 CallableStatement cs = objetoConexion.establecerConecxionstatic().prepareCall(consulta);
                 cs.setString(1,getNickname());
                 cs.execute();
                 
                 JOptionPane.showMessageDialog(null, "SE ELIMINO AL USUARIO CORRECTAMENTE");
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(null, "NO SE ELIMINO AL USUARIO"+e.toString());
             }
    }
        
}
    
    
    
    
    




