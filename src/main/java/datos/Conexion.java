
package datos;

import java.sql.*; 
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author MilaCor
 */
public class Conexion {
    
    //esta url se trae del wizard
    private static final String JDBC_URL="jdbc:mysql://localhost:3307/bd_tecnologica?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    //se crea automaticamente la libreria de org.apache
    private static BasicDataSource dataSource;
    
    //se crea la libreria javax.sql.DataSource automaticamente
    public static DataSource getDataSource() throws SQLException{ //importamos el sqlException
        
        //
        if(dataSource == null){
            dataSource = new BasicDataSource(); //instancia de BasicDataSource
            
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Num. de conexiones, diciendo que se conectaran 20 usuarios, no necesariamente simultaneas.
            dataSource.setInitialSize(10);
            
            /*ADICIONALES... configuracion de Pool de Direcciones.
            //Minimo de conexiones que se pueden admitir
            dataSource.setMinIdle(3);
            
            //Maximo de conexiones que se pueden admitir
            dataSource.setMaxIdle(40);
            
            //Total de conexiones que se conectarán
            dataSource.setMaxTotal(43);*/
        }
        System.out.println("dataSource = " + dataSource);
        return dataSource;
    }
    
    //Con esto, obtenemos una conexion a la base de datos a partir del Pool de direcciones
    public static Connection getConnection() throws SQLException{

        //Llamar el conector que estamos trabajando, traido desde el wizard de la bd => ´Driver class´
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

        return getDataSource().getConnection();   
    }
    
    //Metodos para...
    //Cerrar el Resulset
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //Cerrar el PreparedStatement
    public static void Close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //Cerrar la conexion
    public static void closer(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
}
