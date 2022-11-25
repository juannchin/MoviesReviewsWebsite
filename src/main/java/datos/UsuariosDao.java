package datos;

import dominio.Usuario;
import dominio.TipoUsuario;

//Clase que contendra todos los metodos relacionados a la tabla usuarios

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDao 
{
    String SQL_Insert =("INSERT INTO usuarios(nombres, apellidos, email, password, fecha_nacimiento, id_tipo_usuario, pregunta_recuperacion, respuesta_recuperacion) VALUES (?,?,?,?,?,?,?,?)");
    //Insertar datos
    public int InsertarUsuario (Usuario usuario)
    {
        //el PreparedStatement nos sirve para enviar los argumentos a mi consulta SQL de una manera segura
        //así nos protegemos de una inyección SQL
        PreparedStatement stmt = null;
        
        //objeto que almacena la conexion
        Connection conn = null;
        int filas_insertadas = 0;
        
        try
        {
            //inicializamos la conexion llamando al constructor de la clase
            Conexion c = new Conexion();
            
            //guardamos la conexion
            conn=c.getConnection();
            
            //asigno la conexion y mi consulta sql a mi objeto PreparedStatement
            stmt=conn.prepareStatement(SQL_Insert);
            //asigno los argumentos a mi consulta SQL
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getClave());
            stmt.setString(5, usuario.getFecha_nac());
            stmt.setInt(6, 2);
            stmt.setString(7, usuario.getPregunta_r());
            stmt.setString(8, usuario.getRespuesta_r());
            
            //ejeuctamos la consulta y guardamos su resultado en una variable
            //si filas insertadas devuelve 1 significa que se inserto sino no hizo nada
            filas_insertadas = stmt.executeUpdate();
            
            //cerramos la conexio y el preparedstatement
            c.close(conn);
            stmt.close();
              
        }
        catch(Exception e)
        {
            System.out.print("Ocurrio un error: "+e.getMessage());
        }
        
        return filas_insertadas;
    }
}
