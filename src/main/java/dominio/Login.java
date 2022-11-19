/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author juan
 */
public class Login {
    //variables iguales a las de la base de datos
    private int id, id_tipo_usuario;
    private String nombres, apellidos, email, password;
    
    //Constructores
    public Login(){
    
    }

    public Login(int id) {
        this.id = id;
    }

    public Login(String nombres, String apellidos, String email, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }
    
    //Metodos accesores
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
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

    
    //Metodo ToString()

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", nombres=" + nombres + 
                ", apellidos=" + apellidos + ", password=" + password +'}';
    }
}
