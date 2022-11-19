
package dominio;

/**
 *
 * @author MilaCor
 */
public class Cliente {
    //variables iguales a las de la base de datos
    private int id_cliente;
    private String nombre, apellido, email, telefono;
    private double saldo;
    private int edad;
    
    //Constructores
    public Cliente(){
    
    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Cliente(String nombre, String apellido, String email, String telefono, double saldo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
        this.edad = edad;
    }

    public Cliente(int id_cliente, String nombre, String apellido, String email, String telefono, double saldo, int edad) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
        this.edad = edad;
    }
    
    //Metodos accesores
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //Metodo ToString()

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + 
                ", apellido=" + apellido + ", email=" + email + ", telefono=" + 
                telefono + ", saldo=" + saldo + ", edad=" + edad +'}';
    }

}
