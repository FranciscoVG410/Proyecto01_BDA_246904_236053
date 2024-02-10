/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class conexionBD {
    Connection conectar;
    
    String usuario="root";
    String contraseña="63690Val";
    String bd="banco";
    String ip="localhost";
    String puerto="3036";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Problemas en conexion "+ e.toString());
        }
        return conectar;
    } 
}
