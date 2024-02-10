/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mycompany.bda_proyecto01.frmMenu;
import com.mycompany.bda_proyecto01.frmRegisto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author franc
 */
public class claseLogin {
    public void validaUsuario(JTextField txtUsuario, JPasswordField txtContraseña){
        try {
            ResultSet rs = null;
            
            PreparedStatement ps = null;
            
            conexion.conexionBD cone = new conexion.conexionBD();
            String consulta="select * from clientes where clientes.id = (?) and clientes.contraseña = (?);";
            ps = cone.estableceConexion().prepareStatement(consulta);
            
            String passw =String.valueOf(txtContraseña.getPassword());
            ps.setString(1, txtUsuario.getText());
            ps.setString(2, passw);
            
            if(txtContraseña.getText().equals(claseRegistro.txtContraseñaRegistro.getText())){
                rs = ps.executeQuery();
            
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "EL USUARIO ES CORRECTO");
                    frmMenu menu = new frmMenu();
                    menu .setVisible(true);
                }
            }
            
        } catch (Exception e) {
            
        }
    }
}
