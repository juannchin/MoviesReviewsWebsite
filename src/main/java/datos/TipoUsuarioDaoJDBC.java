
package datos;

import dominio.TipoUsuario;
import java.sql.*;
import java.util.*;

public class TipoUsuarioDaoJDBC {
    
    private static final String SQL_CONSULTA = "SELECT id_tipo_usuario, user_type from tipo_usuario";

    private static final String SQL_POR_ID = "SELECT id_tipo_usuario, user_type from tipo_usuario "
            + "WHERE id_tipo_usuario= ?";

    private static final String SQL_INSERTAR = "INSERT INTO tipo_usuario (user_type)"
            + "VALUES(?)";

    private static final String SQL_ACTUALIZAR = "UPDATE tipo_usuario SET user_type=? where id_tipo_usuario=?";

    private static final String SQL_BORRAR = "DELETE FROM tipo_usuario WHERE id_tipo_usuario=?";
    
   public List<TipoUsuario> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       TipoUsuario tipousuario = null; 
         List<TipoUsuario> tipousuarios = new ArrayList<>();
         
          try {
            System.out.println("Conexion establecida");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA);
             System.out.println("Previo a ejecutar el query");
            Statement instruccion = conn.createStatement();
            String sql = "Select user_type FROM tipo_usuario";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Nombre del rol = " + resultado.getString("user_type"));
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTipoUsuario = rs.getInt("id_tipo_usuario");
                String userType = rs.getString("user_type");
                System.out.println("ID TipoUsuario" + idTipoUsuario);
                System.out.println("Nombre del rol:" + userType);
                tipousuario = new TipoUsuario(idTipoUsuario,userType);
                tipousuarios.add(tipousuario);
         

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
         
         return  tipousuarios;
    }
    
      public TipoUsuario encontrar(TipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, tipousuario.getIdTipoUsuario());
            rs = stmt.executeQuery();

            rs.next();

            String userType = rs.getString("user_type");
          
            tipousuario.setUserType(userType);
            
             System.out.println("Encontrar nombre = " + userType);
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipousuario;
    }
      
        public int insertar(TipoUsuario tipousuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR);
            
            stmt.setString(1, tipousuario.getUserType());
           
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
        
        public int actualizar(TipoUsuario tipousuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            
            stmt.setString(1, tipousuario.getUserType());
            stmt.setInt(2, tipousuario.getIdTipoUsuario());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(TipoUsuario tipousuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR);
            
            
            stmt.setInt(1, tipousuario.getIdTipoUsuario());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
}
