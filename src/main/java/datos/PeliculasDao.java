
package datos;

import dominio.NombrePeliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PeliculasDao {
   
    
     private static final String SQL_CONSULTA_P = "SELECT a.id id_pelicula, a.nombre nombre, descripcion descripcion,  thumbnail thumbnail, " +
"       b.nombre categoria,  " +
"       nombre_productora productora,  " +
"	   edad_minima edad_minima, " +
"       calificacion calificacion, " +
"       b.id id_categoria " +
"FROM peliculas a INNER JOIN categorias b ON a.id_categoria = b.id " +
"INNER JOIN casa_productora c ON a.id_productora = c.id_productora " +
"INNER JOIN clasificacion d ON a.id_clasificacion = d.id_clasificacion " +
"INNER JOIN calificacion e ON a.id = e.id ";
     

      public List<NombrePeliculas> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       NombrePeliculas nombrepelicula = null; 
       List<NombrePeliculas> listapeliculas = new ArrayList<>();
         
          try {
            System.out.println("Conexion establecida");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA_P);
             System.out.println("Previo a ejecutar el query");
             
            Statement instruccion = conn.createStatement();
            String sql = "SELECT a.id id_pelicula, a.nombre nombre, descripcion descripcion,  thumbnail thumbnail, " +
"       b.nombre categoria,  " +
"       nombre_productora productora,  " +
"	   edad_minima edad_minima, " +
"       calificacion calificacion, " +
"       b.id id_categoria " +
"FROM peliculas a INNER JOIN categorias b ON a.id_categoria = b.id " +
"INNER JOIN casa_productora c ON a.id_productora = c.id_productora " +
"INNER JOIN clasificacion d ON a.id_clasificacion = d.id_clasificacion " +
"INNER JOIN calificacion e ON a.id = e.id";

            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Nombre de = " + resultado.getString("id_pelicula"));
                System.out.println("Nombre de = " + resultado.getString("nombre"));
                System.out.println("Nombre de= " + resultado.getString("descripcion"));
                System.out.println("Nombre de = " + resultado.getString("thumbnail"));
                System.out.println("Nombre de = " + resultado.getString("categoria"));
                System.out.println("Nombre de = " + resultado.getString("productora"));
                System.out.println("Nombre de = " + resultado.getString("edad_minima"));
                System.out.println("Nombre de = " + resultado.getDouble("calificacion"));
                System.out.println("Nombre de = " + resultado.getInt("id_categoria"));
   
            }
            
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPelicula = rs.getInt("id_pelicula");
                String nombrePelicula = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String thumbnail = rs.getString("thumbnail");
                String categoria = rs.getString("categoria");
                String productora = rs.getString("productora");
                String edad_minima = rs.getString("edad_minima");
                double calificacion = rs.getDouble("calificacion");
                int idcategoria = rs.getInt("id_categoria");
                
                 System.out.println("Nombre de:" + idPelicula);
                System.out.println("Nombre de:" + nombrePelicula);
                System.out.println("Nombre de:" + descripcion);
                System.out.println("Nombre de:" + thumbnail);
                System.out.println("Nombre de:" + categoria);
                System.out.println("Nombre de:" + productora);
                System.out.println("Nombre de:" + edad_minima);
                System.out.println("Nombre de:" + calificacion);
                System.out.println("Nombre de: "+ idcategoria);
                nombrepelicula = new NombrePeliculas(idPelicula,nombrePelicula,descripcion,thumbnail,
                        categoria,productora,edad_minima,calificacion,idcategoria);
                listapeliculas.add(nombrepelicula);
         

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
         
         return listapeliculas;
    }  
     
          

     
}
