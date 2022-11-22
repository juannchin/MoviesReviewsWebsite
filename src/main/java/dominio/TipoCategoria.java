/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Esau
 */
public class TipoCategoria {
    private int idCategoria;
    private String nombreCategorias;
    
 public TipoCategoria(){
    
 }

    public TipoCategoria(int idCategoria, String nombreCategorias) {
        this.idCategoria = idCategoria;
        this.nombreCategorias = nombreCategorias;
    }

    public TipoCategoria(int idCategoria) {
         this.idCategoria = idCategoria;
    }
     public TipoCategoria(String nombreCategorias) {
         this.nombreCategorias = nombreCategorias;
    }
 

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategorias() {
        return nombreCategorias;
    }

    public void setNombreCategorias(String nombreCategorias) {
        this.nombreCategorias = nombreCategorias;
    }

    @Override
    public String toString() {
        return "TipoCategoria{" + "idCategoria=" + idCategoria + ", nombreCategorias=" + nombreCategorias + '}';
    }
    
}
