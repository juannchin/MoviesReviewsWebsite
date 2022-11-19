package datos;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.*;

/**
 *
 * @author MilaCor
 */
public class ClienteDaoJDBC {
    
    private static final String SQL_CONSULTA = "SELECT id_cliente, nombre, apellido, email, telefono, saldo, edad "
                                        +"FROM cliente";
    
    private static final String SQL_POR_ID = "SELECT id_cliente, nombre, apellido, email, telefono, "
                                         +"saldo, edad FROM cliente WHERE id_cliente = ?";
    
    private static final String SQL_INSERTAR = "INSERT INTO cliente "
            +"(nombre, apellido, email, telefono, saldo, edad) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_ACTUALIZAR = "UPDATE cliente SET "
                        +"nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ?, edad = ? WHERE id_cliente = ?";
    
    private static final String SQL_BORRAR = "DELETE FROM cliente WHERE id_cliente = ?";
    
    //Se importa la clase Cliente, la libreria java.util.List y dominio.Cliente
    public List<Cliente> listar(){
        //Inicializando 
        Connection conn = null;
        PreparedStatement stmt = null; //Para ejecutar consultas
        ResultSet rs = null;
        Cliente cliente = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            System.out.println("Conexion Especial");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA);
            System.out.println("Previo a ejecutar el Query");
            Statement instruccion = conn.createStatement();
            String sql = "SELECT nombre, apellido, email, telefono, saldo, edad FROM cliente";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Nombre del Cliente = "+ resultado.getString("nombre"));
                System.out.println("Apellido del Cliente = "+ resultado.getString("apellido"));
            }
            
            rs = stmt.executeQuery();
            
            //para mandar a llamar los getters y setters
            while(rs.next()){
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                int edad = rs.getInt("edad");
                
                System.out.println("Id cliente = "+ idCliente);
                System.out.println("Nombre = "+ nombre + " "+ apellido);
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo, edad);
                
                clientes.add(cliente);
            }  
        } catch (SQLException ex) { //importamos libreria java.sql.* y java.util.*
            ex.printStackTrace(System.out);
        }finally{
            //Cerrando el resulset, el prepareStatement y la conexion
           /* Conexion.close(rs);
            Conexion.Close(stmt);
            Conexion.closer(conn);*/
        }
        return clientes;
    }
    
    public Cliente encontrar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, cliente.getId_cliente());//obteniendo el id del cliente de la bd
            rs = stmt.executeQuery();//posicionarse en el primer registro
            rs.next(); 
            //nombre de los campos en la base de datos, recuperando los elementos
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");
            int edad = rs.getInt("edad");
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
            cliente.setEdad(edad);
            
            System.out.println("Encontrar nombre = " + nombre);
            System.out.println("Encontrar apellido = " + apellido);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Conexion.close(rs);
            Conexion.Close(stmt);
            Conexion.closer(conn);*/
        }
        return cliente;
    }
    
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR);
            
            //Mismo orden que en la base de datos, de preferencia
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getEdad());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Conexion.Close(stmt);
            Conexion.closer(conn);*/
        }
        return rows;
    }
    
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getEdad());
            
            stmt.setInt(7, cliente.getId_cliente());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Conexion.Close(stmt);
            Conexion.closer(conn);*/
        }
        return rows;
    } 
    
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_BORRAR);

            stmt.setInt(1, cliente.getId_cliente());
             
            rows= stmt.executeUpdate(); 
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Conexion.Close(stmt);
            Conexion.closer(conn);*/
        }
        return rows;
    }
    
}
