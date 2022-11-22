
package datos;

import dominio.UsuarioTipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Grupo3
 */
public class UsuarioTipoUsuarioDaoJDBC {
    
    private static final String SQL_CONSULTA_USUA_TIP = "SELECT id id, nombres nombres, apellidos apellidos,"+
            " email email, password password, fecha_nacimiento fecha_nacimiento, user_type user_type " +
            "FROM usuarios a INNER JOIN tipo_usuario b ON a.id_tipo_usuario = b.id_tipo_usuario";
    
    private static final String SQL_POR_ID_USUA = "SELECT id id, nombres nombres, apellidos apellidos, "+
            "email email, password password, fecha_nacimiento fecha_nacimiento, user_type user_type"+
            " FROM usuarios a INNER JOIN tipo_usuario b "+
            "ON a.id_tipo_usuario = b.id_tipo_usuario WHERE a.id = ?";
    
    private static final String SQL_INSERTAR_USUA = "INSERT INTO usuarios "+
            "(nombres, apellidos, email, password, fecha_nacimiento, id_tipo_usuario) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    
    private static final String SQL_ACTUALIZAR_USUA = "UPDATE usuarios SET "+
            "nombres = ?, apellidos = ?, email = ?, password = ?, fecha_nacimiento = ?, "+
            "id_tipo_usuario = ? WHERE id = ?";
    
    private static final String SQL_BORRAR_USUA = "DELETE FROM usuarios WHERE id = ?";

    public List<UsuarioTipoUsuario> listarUsuaTipoUsua() {
        //Inicializando
        Connection conn = null;
        PreparedStatement stmt = null; //Para ejecutar consultas
        ResultSet rsU = null;
        UsuarioTipoUsuario usuarioTip = null;

        List<UsuarioTipoUsuario> usuarioTipUsua = new ArrayList<>();
        
        try {
            System.out.println("Conexion Especial");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA_USUA_TIP);
            
            System.out.println("Previo a ejecutar el Query");
            Statement instruccion = conn.createStatement();
            String sql = "SELECT id id, nombres nombres, apellidos apellidos, email email, " +
            "password password, fecha_nacimiento fecha_nacimiento, user_type user_type " +
            "FROM usuarios a INNER JOIN tipo_usuario b ON a.id_tipo_usuario = b.id_tipo_usuario;";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Nombre del Usuario = "+ resultado.getString("nombres"));
                System.out.println("Apellido del Usuario = "+ resultado.getString("apellidos"));
            }
            
            rsU = stmt.executeQuery();
            
            //para mandar a llamar los getters y setters
            while(rsU.next()){
                int id = rsU.getInt("id");
                String nombres = rsU.getString("nombres");
                String apellidos = rsU.getString("apellidos");
                String email = rsU.getString("email");
                String password = rsU.getString("password");
                String fecha_nacimiento = rsU.getString("fecha_nacimiento");
                String user_type = rsU.getString("user_type");
                //int id_tipo_usuario = rsU.getInt("id_tipo_usuario");
                
                
                System.out.println("Id usuario = "+ id);
                System.out.println("Nombre = "+ nombres + " "+ apellidos);
                
                usuarioTip = new UsuarioTipoUsuario(id, nombres, apellidos, email, password, 
                        fecha_nacimiento, user_type);
                
                usuarioTipUsua.add(usuarioTip);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            //Cerrando el resulset, el prepareStatement y la conexion
            Conexion.close(rsU);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarioTipUsua;
    }
    
    public UsuarioTipoUsuario encontrar(UsuarioTipoUsuario usuarioTipoU){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID_USUA);
            stmt.setInt(1, usuarioTipoU.getId());//obteniendo el id del cliente de la bd
            rs = stmt.executeQuery();//posicionarse en el primer registro
            rs.next(); 
            //nombre de los campos en la base de datos, recuperando los elementos
            int id = rs.getInt("id");
            String nombres = rs.getString("nombres");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String fecha_nacimiento = rs.getString("fecha_nacimiento");
            String user_type = rs.getString("user_type");

            int id_tipo_usuario = 0;
                
            if(null != user_type)switch (user_type) {
                case "Administrador":
                    id_tipo_usuario = 1;
                    break;
                case "Usuario":
                    id_tipo_usuario = 2;
                    break;
                case "Visitante":
                    id_tipo_usuario = 3;
                    break;
                default:
                    break;
            }
                  
            usuarioTipoU.setId(id);
            usuarioTipoU.setNombres(nombres);
            usuarioTipoU.setApellidos(apellidos);
            usuarioTipoU.setEmail(email);
            usuarioTipoU.setPassword(password);
            usuarioTipoU.setFecha_nacimiento(fecha_nacimiento);
            usuarioTipoU.setId_tipo_usuario(id_tipo_usuario);
            usuarioTipoU.setUser_type(user_type);
            
            System.out.println("Encontrar nombre = " + nombres);
            System.out.println("Encontrar apellido = " + apellidos);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarioTipoU;
    }
    
    public int insertar(UsuarioTipoUsuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR_USUA);
            
            //Mismo orden que en la base de datos, de preferencia
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getFecha_nacimiento());
            stmt.setInt(6, usuario.getId_tipo_usuario());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(UsuarioTipoUsuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR_USUA);
            
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getFecha_nacimiento());
            stmt.setInt(6, usuario.getId_tipo_usuario());
            
            stmt.setInt(7, usuario.getId());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } 
    
    public int eliminar(UsuarioTipoUsuario usuarioTip){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR_USUA);

            stmt.setInt(1, usuarioTip.getId());
             
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
