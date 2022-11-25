/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Marvin
 */
public class Casa_productora 
{
    private int id_productora=0;
    private String nombre_productora="";
    private String fecha_fundacion="";
    private String subproductoras="";

    //creamos los metodos accesores
    //Getter
    public int getId_productora() {
        return id_productora;
    }

    public String getNombre_productora() {
        return nombre_productora;
    }

    public String getFecha_fundacion() {
        return fecha_fundacion;
    }

    public String getSubproductoras() {
        return subproductoras;
    }
    
    //Setter

    public void setId_productora(int id_productora) {
        this.id_productora = id_productora;
    }

    public void setNombre_productora(String nombre_productora) {
        this.nombre_productora = nombre_productora;
    }

    public void setFecha_fundacion(String fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public void setSubproductoras(String subproductoras) {
        this.subproductoras = subproductoras;
    }
    
    //constructor vacio
    public Casa_productora ()
    {
        
    }
    //constructor que asigna valores paa insertar aqui omitimos el insert
     public Casa_productora (String nombre, String fecha, String subproduct)
    {
        nombre_productora = nombre;
        fecha_fundacion = fecha;
        subproductoras = subproduct;
    }
     
     //constructor que asigna valores para mostrar 
     public Casa_productora (int id, String nombre, String fecha, String subproduct)
    {
        id_productora = id;
        nombre_productora = nombre;
        fecha_fundacion = fecha;
        subproductoras = subproduct;
    }
     
    //constructor para eliminar
     public Casa_productora (int id)
    {
        id_productora = id;
    }
}
