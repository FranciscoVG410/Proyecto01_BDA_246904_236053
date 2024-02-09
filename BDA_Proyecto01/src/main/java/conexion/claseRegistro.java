/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mycompany.bda_proyecto01.frmLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author franc
 */
public class claseRegistro{
    public void validaRegistro(JTextField txtNombreRegistro,JTextField txtApellidoPRegistro, JTextField txtApellidoMRegistro, JTextField txtDomicilioRegistro, JPasswordField txtContraseñaRegistro){
        try {
            ResultSet rs = null;
            
            PreparedStatement ps = null;
            
            conexion.conexionBD cone = new conexion.conexionBD();
            String consulta="insert into clientes (id, nombres, apellidoP, apellidoM, domicilio, fechaNacimiento, contraseña) values ((?),(?), (?), (?), (?), (?), (?));";
            ps = cone.estableceConexion().prepareStatement(consulta);
            
            String passw =String.valueOf(txtContraseñaRegistro.getPassword());
            
            ps.setString(1, txtNombreRegistro.getText());
            ps.setString(2, txtApellidoPRegistro.getText());
            ps.setString(3, txtApellidoMRegistro.getText());
            ps.setString(4, txtDomicilioRegistro.getText());
            ps.setString(5, passw);
        
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "EL USUARIO SE A REGISTRADO CORRECFTAMENTE");
                frmLogin menu = new frmLogin();
                menu .setVisible(true);
            }
            
        } catch (Exception e) {
            
        }
    }
}
