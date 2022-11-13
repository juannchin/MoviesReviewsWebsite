package datos;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.*;

/**
 *
 * @author rafag
 */
public class ClienteDaoJDBC {

    private static final String SQL_CONSULTA = "SELECT id_cliente, nombre, apellido, email, telefono, saldo from cliente";

    private static final String SQL_POR_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo from cliente "
            + "WHERE id_cliente= ?";

    private static final String SQL_INSERTAR = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo)"
            + "VALUES( ?, ?, ? ,?, ?)";

    private static final String SQL_ACTUALIZAR = "UPDATE cliente "
            + "SET nombre= ?, apellido=?, email=?, telefono=?, saldo=? where id_cliente=? ";

    private static final String SQL_BORRAR = "DELETE FROM cliente WHERE id_cliente=?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            System.out.println("Conexion establecida");
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CONSULTA);
            System.out.println("Previo a ejecutar el query");
            Statement instruccion = conn.createStatement();
            String sql = "Select nombre, apellido FROM cliente";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Nombre del cliente = " + resultado.getString("nombre"));
                System.out.println("Nombre del cliente = " + resultado.getString("apellido"));
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getFloat("saldo");
                System.out.println("ID CLIENTE" + idCliente);
                System.out.println("Nombre del cliente:" + nombre);
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;

    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_POR_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();

            rs.next();

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

            System.out.println("Encontrar nombre = " + nombre);
            System.out.println("Encontrar apellido = " + apellido);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTAR);
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ACTUALIZAR);
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            stmt.setInt(6, cliente.getIdCliente());
             
            rows= stmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
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
            
            
            stmt.setInt(1, cliente.getIdCliente());
             
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
