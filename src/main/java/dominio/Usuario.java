package dominio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marvin
 */
public class Usuario 
{
    //variables que reciben los valores de la BD
    private String nombres="", apellidos="", email="";
    private String clave="", verificar_clave="", fecha_nac="";
    private String pregunta_r="", respuesta_r="";
    
    //creamos los metodos accesores de estas variables ya que son privadas
    //metodos GET para leer las variables

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getVerificar_clave() {
        return verificar_clave;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getPregunta_r() {
        return pregunta_r;
    }

    public String getRespuesta_r() {
        return respuesta_r;
    }
    
    //Metodos set para enviar datos a las variables

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setVerificar_clave(String verificar_clave) {
        this.verificar_clave = verificar_clave;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setPregunta_r(String pregunta_r) {
        this.pregunta_r = pregunta_r;
    }

    public void setRespuesta_r(String respuesta_r) {
        this.respuesta_r = respuesta_r;
    }
    
    //creamos un constructor con parametros que se encargara de asignarle los datos rebidos a las variables de la clase 
    public Usuario (String nombres, String apellidos, String email, String clave, String fecha_nac, String pregunta_r, String respuesta_r)
    {
        //le asigno el valor de los parametros a mis variables de clase 
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email=email;
        this.clave=clave;
        this.fecha_nac=fecha_nac;
        this.pregunta_r=pregunta_r;
        this.respuesta_r=respuesta_r;
    }
}
