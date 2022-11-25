package datos;

import dominio.Clasificacion;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.*;

/**
 *
 * @author carlos vidal
 */
public class ClasificacionDao {
    private static final String SQL_CONSULTA = "SELECT id_clasificacion, nombre, edad_minima, recomendacion "
                                        +"FROM clasificacion";
    
    private static final String SQL_POR_ID = "SELECT id_clasificacion, nombre, edad_minima, recomendacion "
                                         +" FROM clasificacion WHERE id_clasificacion = ?";
    
    private static final String SQL_INSERTAR = "INSERT INTO clasificacion "
            +"(nombre, edad_minima, recomendacion) VALUES (?, ?, ?)";
    
    private static final String SQL_ACTUALIZAR = "UPDATE clasificacion SET "
                        +"nombre = ?, edad_minima = ?, recomendacion = ?  WHERE id_clasificacion = ?";
    
    private static final String SQL_BORRAR = "DELETE FROM clasificacion WHERE id_clasificacion = ?";
    
    //Se importa la clase Clasficacion, la libreria java.util.List y dominio.clasificacion
    public List<Clasificacion> listar(){
        //Inicializando 
        Connection conn = null;
        PreparedStatement stmt = null; //Para ejecutar consultas
        ResultSet rs = null;
        Clasificacion clasificacion = null;
        
        List<Clasificacion> clasificaciones = new ArrayList<>();
        
        try {
            System.out.println("Conexion Especial");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA);
            System.out.println("Previo a ejecutar el Query");
            Statement instruccion = conn.createStatement();
            String sql = "SELECT nombre, edad_minima, recomendacion FROM clasificacion";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Nombre = "+ resultado.getString("nombre"));
            }
            
            rs = stmt.executeQuery();
            
            //para mandar a llamar los getters y setters
            while(rs.next()){
                int id_clasificacion = rs.getInt("id_clasificacion");
                String nombre = rs.getString("nombre");
                String edad_minima = rs.getString("edad_minima");
                String recomendacion = rs.getString("recomendacion");
               
                System.out.println("id_clasificacion = "+ id_clasificacion);
                System.out.println("nombre = "+ nombre );
                System.out.println("edad_minima = "+ edad_minima );
                System.out.println("recomendacion = "+ recomendacion );
                clasificacion = new Clasificacion(id_clasificacion, nombre, edad_minima, recomendacion);
                
                clasificaciones.add(clasificacion);
            }  
             } catch (SQLException ex) { //importamos libreria java.sql.* y java.util.*
            ex.printStackTrace(System.out);
        }finally{
            //Cerrando el resulset, el prepareStatement y la conexion
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clasificaciones;
    }
    
    public Clasificacion encontrar(Clasificacion clasificacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, clasificacion.getId_clasificacion());//obteniendo el id del cliente de la bd
            rs = stmt.executeQuery();//posicionarse en el primer registro
            rs.next(); 
            //nombre de los campos en la base de datos, recuperando los elementos
            //int id_clasificacion = rs.getInt("id_clasificacion");
            String nombre = rs.getString("nombre");
            String edad_minima = rs.getString("edad_minima");
            String recomendacion = rs.getString("recomendacion");
            
            //clasificacion.setId_clasificacion(id_clasificacion);
            clasificacion.setNombre(nombre);
            clasificacion.setEdad_minima(edad_minima);
            clasificacion.setRecomendacion(recomendacion);
            
            System.out.println("Encontrar nombre = " + nombre);
            
                } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clasificacion;
    }
     public int insertar(Clasificacion clasificacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR);
            
            //Mismo orden que en la base de datos, de preferencia
            stmt.setString(1, clasificacion.getNombre());
            stmt.setString(2, clasificacion.getEdad_minima());
            stmt.setString(3, clasificacion.getRecomendacion());
            
            
           
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     
      public int actualizar(Clasificacion clasificacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            
            stmt.setString(1, clasificacion.getNombre());
            stmt.setString(2, clasificacion.getEdad_minima());
            stmt.setString(3, clasificacion.getRecomendacion());
            
            stmt.setInt(4, clasificacion.getId_clasificacion());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
      
       public int eliminar(Clasificacion clasificacion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR);

            stmt.setInt(1, clasificacion.getId_clasificacion());
             
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
