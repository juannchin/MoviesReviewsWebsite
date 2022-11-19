/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Login;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.*;

/**
 *
 * @author juan
 */


  
public class LoginDao {  
    
    private static final String SQL_POR_EMAIL = "SELECT id, nombres, apellidos, email, password FROM usuarios WHERE email=? and password=?";
    
    public static boolean validate(String email,String password){  
        boolean status=false;  
    
            try {
                Connection conn = null;
                PreparedStatement ps = null;
                conn = Conexion.getConnection();
                ps = conn.prepareStatement(SQL_POR_EMAIL);
                ps.setString(1,email);  
                ps.setString(2,password);  

                ResultSet rs=ps.executeQuery();  
                status=rs.next();  
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);

                }
             catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } 
            return status;
        }    
}  
