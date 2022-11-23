
package dominio;


public class NombrePeliculas {
    
     private int idPelicula;
     private String nombrePelicula;
     private String descripcion;
     private String thumbnail;
     private String categoria;
     private String productora;
     private String edad_minima;
      private double calificacion;
      private int idcategoria;
     

    public NombrePeliculas() {
    }

    public NombrePeliculas(int idPelicula) {
        this.idPelicula = idPelicula;
    }
///////
   
    public NombrePeliculas(String nombrePelicula, String descripcion, String thumbnail, String categoria, String productora, String edad_minima, double calificacion) {
        this.nombrePelicula = nombrePelicula;
        this.descripcion = descripcion;
        this.thumbnail = thumbnail;
        this.categoria = categoria;
        this.productora = productora;
        this.edad_minima = edad_minima;
        this.calificacion = calificacion;
    }

    public NombrePeliculas(int idPelicula, String nombrePelicula, String descripcion, String thumbnail, String categoria, String productora, String edad_minima, double calificacion, int idcategoria) {
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.descripcion = descripcion;
        this.thumbnail = thumbnail;
        this.categoria = categoria;
        this.productora = productora;
        this.edad_minima = edad_minima;
        this.calificacion = calificacion;
        this.idcategoria = idcategoria;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(String edad_minima) {
        this.edad_minima = edad_minima;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "NombrePeliculas{" + "idPelicula=" + idPelicula + ", nombrePelicula=" + nombrePelicula + ", descripcion=" + descripcion + ", thumbnail=" + thumbnail + ", categoria=" + categoria + ", productora=" + productora + ", edad_minima=" + edad_minima + ", calificacion=" + calificacion + '}';
    }
    

  
        
}
