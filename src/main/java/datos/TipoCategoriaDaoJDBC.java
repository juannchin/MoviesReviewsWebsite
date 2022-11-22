/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.TipoCategoria;
import java.sql.*;
import java.util.*;

public class TipoCategoriaDaoJDBC {
    private static final String SQL_CONSULTA = "SELECT id, nombre from categorias";

    private static final String SQL_POR_ID = "SELECT id, nombre from categorias "
            + "WHERE id= ?";

    private static final String SQL_INSERTAR = "INSERT INTO categorias (nombre)"
            + "VALUES(?)";

    private static final String SQL_ACTUALIZAR = "UPDATE categorias SET nombre=? where id=?";

    private static final String SQL_BORRAR = "DELETE FROM categorias WHERE id=?";
    
      public List<TipoCategoria> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoCategoria tipocategoria = null; 
        List<TipoCategoria> tipocategorias = new ArrayList<>();
                
                try {
            System.out.println("Conexion establecida de categorias");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA);
             System.out.println("Previo a ejecutar el query de categorias");
            Statement instruccion = conn.createStatement();
            String sql = "Select nombre FROM categorias";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Nombre de categoria = " + resultado.getString("nombre"));
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("id");
                String nombreCategorias = rs.getString("nombre");
                System.out.println("idCategoria" + idCategoria);
                System.out.println("Nombre :" + nombreCategorias);
                tipocategoria = new TipoCategoria(idCategoria,nombreCategorias);
                tipocategorias.add(tipocategoria);
         

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
         
         return  tipocategorias;
    }
      
      public TipoCategoria encontrar(TipoCategoria tipocategoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, tipocategoria.getIdCategoria());
            rs = stmt.executeQuery();

            rs.next();

            String nombreCategorias = rs.getString("nombre");
          
            tipocategoria.setNombreCategorias(nombreCategorias);
            
             System.out.println("Encontrar nombre = " + nombreCategorias);
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipocategoria;
    }
      
        public int insertar(TipoCategoria tipocategoria){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR);
            
            stmt.setString(1, tipocategoria.getNombreCategorias());
           
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
        
        public int actualizar(TipoCategoria tipocategoria){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            
            stmt.setString(1, tipocategoria.getNombreCategorias());
            stmt.setInt(2, tipocategoria.getIdCategoria());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(TipoCategoria tipocategoria){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR);
            
            
            stmt.setInt(1, tipocategoria.getIdCategoria());
             
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
