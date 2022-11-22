
package dominio;

/**
 *
 * @author carlos vidal
 */
public class Clasificacion {
    //variables iguales a la base de datos
    
    private int id_clasificacion;
    private String nombre;
    private String edad_minima;
    private String recomendacion;
    
    //constructores
    public Clasificacion(){
    
    }

    public Clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public Clasificacion(String nombre, String edad_minima, String recomendacion) {
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.recomendacion = recomendacion;
    }

    public Clasificacion(int id_clasificacion, String nombre, String edad_minima, String recomendacion) {
        this.id_clasificacion = id_clasificacion;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.recomendacion = recomendacion;
    }



    //Metodos getter and setter

    public int getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(String edad_minima) {
        this.edad_minima = edad_minima;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    
    //Metodo ToString
    @Override
    public String toString() {
        return "Clasificacion{" + "id_clasificacion=" + id_clasificacion + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", recomendacion=" + recomendacion + '}';
    }
    
    
    
}
