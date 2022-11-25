/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Casa_productora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Marvin
 */
public class CasaProductoraDAO 
{
    String SQL_insertar = "INSERT INTO casa_productora (nombre_productora, fecha_fundacion, subproductoras) VALUES (?,?,?)";
    String SQL_Select = "Select * from casa_productora";
    String SQL_BORRAR = "DELETE FROM casa_productora WHERE id_productora=?";
    String SQL_POR_ID = "SELECT * from casa_productora WHERE id_productora= ?";
    String SQL_ACTUALIZAR = "UPDATE casa_productora SET nombre_productora=?, fecha_fundacion=?, subproductoras=? where id_productora=?";
    
    public int Insertar(Casa_productora casa)
    {
        //el PreparedStatement nos sirve para enviar los argumentos a mi consulta SQL de una manera segura
        //así nos protegemos de una inyección SQL
        PreparedStatement stmt = null;
        
        //objeto que almacena la conexion
        Connection conn = null;
        int filas_insertadas = 0;
        
        try
        {
            
            //guardamos la conexion
            conn=Conexion.getConnection();
            
            //asigno la conexion y mi consulta sql a mi objeto PreparedStatement
            stmt=conn.prepareStatement(SQL_insertar);
            //asigno los argumentos a mi consulta SQL
            stmt.setString(1, casa.getNombre_productora());
            stmt.setString(2, casa.getFecha_fundacion());
            stmt.setString(3, casa.getSubproductoras());
            
            //ejeuctamos la consulta y guardamos su resultado en una variable
            //si filas insertadas devuelve 1 significa que se inserto sino no hizo nada
            filas_insertadas = stmt.executeUpdate();
            
            //cerramos la conexio y el preparedstatement
            conn.close();
            stmt.close();
              
        }
        catch(Exception e)
        {
            System.out.print("Ocurrio un error: "+e.getMessage());
        }
        
        return filas_insertadas;
    }
    
    public List<Casa_productora> listar() 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Casa_productora casa = null;
        List<Casa_productora> casas = new ArrayList<>();
        try {
            System.out.println("Conexion establecida");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Select);
            System.out.println("Previo a ejecutar el query");
            Statement instruccion = conn.createStatement();
            String sql = "Select * from casa_productora";
            ResultSet resultado = instruccion.executeQuery(SQL_Select);
            while (resultado.next()) {
                System.out.println("Nombre de la productora = " + resultado.getString("nombre_productora"));
                System.out.println("Id d ela productora = " + resultado.getString("id_productora"));
            }
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_casa = rs.getInt("id_productora");
                String nombre_produc = rs.getString("nombre_productora");
                String fecha_fun = rs.getString("fecha_fundacion");
                String sub_p = rs.getString("subproductoras");
                System.out.println("ID productora " + id_casa);
                System.out.println("Nombre de la productora:" + nombre_produc);
                
                //envio mi valor a mi clase de datos
                casa = new Casa_productora(id_casa, nombre_produc, fecha_fun, sub_p);
                casas.add(casa);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return casas;
    }
    
    public int eliminar(Casa_productora casa)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR);
            
            
            stmt.setInt(1, casa.getId_productora());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    //Metodo para encontrar por ID al usuario
    public Casa_productora encontrar(Casa_productora casa) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, casa.getId_productora());
            rs = stmt.executeQuery();

            rs.next();
            
            int idProductora = rs.getInt("id_productora");
            String nombre_productora = rs.getString("nombre_productora");
            String fecha_productora = rs.getString("fecha_fundacion");
            String subproductoras = rs.getString("subproductoras");

            casa.setId_productora(idProductora);
            casa.setNombre_productora(nombre_productora);
            casa.setFecha_fundacion(fecha_productora);
            casa.setSubproductoras(subproductoras);
            

            System.out.println("Encontrar nombre = " + nombre_productora);
            System.out.println("Encontrar codigo = " + idProductora);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return casa;
    }
    
    //metodo de actualizar
    public int actualizar(Casa_productora casa)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            System.out.println(" va entrar momento de actualizar = " + SQL_ACTUALIZAR);
            
            stmt.setString(1, casa.getNombre_productora());
            stmt.setString(2, casa.getFecha_fundacion());
            stmt.setString(3, casa.getSubproductoras());
            stmt.setInt(4, casa.getId_productora());
             
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
