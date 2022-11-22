
package dominio;

/**
 *
 * @author Grupo3
 */
public class UsuarioTipoUsuario {
    //variables iguales a las de la base de datos
    
    //Usuario
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private String fecha_nacimiento;
    //private int id_tipo_usuario;
    
    //Tipo Usuario
    private int id_tipo_usuario;
    private String user_type;

    //CONSTRUCTORES
    public UsuarioTipoUsuario() {
    }

    public UsuarioTipoUsuario(int id) {
        this.id = id;
    }

    public UsuarioTipoUsuario(int id, String nombres, String apellidos, String email, String password, String fecha_nacimiento, int id_tipo_usuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public UsuarioTipoUsuario(int id, String nombres, String apellidos, String email, String password, String fecha_nacimiento, String user_type) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
        this.user_type = user_type;
    }
    
    public UsuarioTipoUsuario(String nombres, String apellidos, String email, String password, String fecha_nacimiento, int id_tipo_usuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_tipo_usuario = id_tipo_usuario;
    }
    
    //METODOS ACCESORES

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    //METODO TO STRING()

    @Override
    public String toString() {
        return "UsuarioTipoUsuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", password=" + password + ", fecha_nacimiento=" + fecha_nacimiento + ", id_tipo_usuario=" + id_tipo_usuario + ", user_type=" + user_type + '}';
    }
    

    
}
