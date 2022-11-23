
package datos;

import dominio.NombrePeliculas;
import dominio.TipoCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDao {
    
    private static final String SQL_CONSULTA_POR_CATEGORIA= "SELECT a.nombre nombre, descripcion descripcion,  thumbnail thumbnail, " +
"       b.nombre categoria,  " +
"       nombre_productora productora,  " +
"	   edad_minima edad_minima, " +
"       calificacion calificacion, " +
"       b.id id_categoria " +
"FROM peliculas a INNER JOIN categorias b ON a.id_categoria = b.id " +
"INNER JOIN casa_productora c ON a.id_productora = c.id_productora " +
"INNER JOIN clasificacion d ON a.id_clasificacion = d.id_clasificacion " +
"INNER JOIN calificacion e ON a.id = e.id where b.id_categoria = ?";
 
         
        public List<NombrePeliculas> listarporCategoria(TipoCategoria idcategoria){
            
       Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        NombrePeliculas nombrepelicula = null; 
        List<NombrePeliculas> listapeliculas = new ArrayList<>();
       
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA_POR_CATEGORIA);
            stmt.setInt(1, idcategoria.getIdCategoria());
            
            
            rs = stmt.executeQuery();

              while (rs.next()) {
 
                String nombrePelicula = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String thumbnail = rs.getString("thumbnail");
                String categoria = rs.getString("categoria");
                String productora = rs.getString("productora");
                String edad_minima = rs.getString("edad_minima");
                double calificacion = rs.getDouble("calificacion");
               
                nombrepelicula = new NombrePeliculas(nombrePelicula,descripcion,thumbnail,categoria,productora,edad_minima,calificacion);
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
