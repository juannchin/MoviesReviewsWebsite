
package datos;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
   private static final String JDBC_URL="jdbc:mysql://localhost:3307/bd_control_de_peliculas?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
  
   private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="12345";
    
    private static BasicDataSource datasource;
    
    public static DataSource getDataSource()throws SQLException{
        if (datasource== null){
            datasource = new BasicDataSource();
            datasource.setUrl(JDBC_URL);
            datasource.setUsername(JDBC_USER);
            datasource.setPassword(JDBC_PASSWORD);
            //No de conexiones
            datasource.setInitialSize(10);
            
            
        }
        System.out.println("datasource = " + datasource);
        return datasource;
    }
    
    public static Connection getConnection() throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
