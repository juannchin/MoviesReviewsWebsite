/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.TipoCategoriaDaoJDBC;
import dominio.TipoCategoria;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletTipoCategoria")
public class ServletCategorias extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     
             String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                  this.editarTipoCategoria(request, response);
                    break;
                case "eliminar":
                  this.eliminarTipoCategoria(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
        
    }
    
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<TipoCategoria>  tipocategorias = new TipoCategoriaDaoJDBC().listar();
        System.out.println("tipocategorias="+  tipocategorias);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("tipocategorias",  tipocategorias);
        response.sendRedirect("Tipocategoria.jsp");
    }
   
      protected void editarTipoCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        TipoCategoria tipocategorias = new TipoCategoriaDaoJDBC().encontrar(new TipoCategoria(idCategoria));
        request.setAttribute("tipocategoria", tipocategorias);
        //DEFINIR LA PAGINA JSP
        //String jspEditar = "/WEB-INF/paginas/tipousuario/editarTipoUsuario.jsp";
       String jspEditar = "/WEB-INF/paginas/PageCategorias/editarTipoCategoria.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }
      
      
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarTipoCategoria(request, response);
                    break;
                case "modificar":
                    this.modificarTipoCategoria(request, response);
                     break;
                default:
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    public void insertarTipoCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Agregar Cliente
       String nombreCategorias = request.getParameter("nombreCategorias");
        
       
       TipoCategoria tipocategoria =new TipoCategoria(nombreCategorias);
        
        int registrosmodificados =new TipoCategoriaDaoJDBC().insertar(tipocategoria);
      
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
      
        public void modificarTipoCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RECUPERAR LOS VALORES DEL FORMULARIO editar.jsp
         
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombreCategorias = request.getParameter("nombreCategorias");
    
        TipoCategoria tipocategoria = new TipoCategoria(idCategoria,nombreCategorias);

        int registrosmodificados = new TipoCategoriaDaoJDBC().actualizar(tipocategoria);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);

    }
          
         public void eliminarTipoCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        
         TipoCategoria tipocategoria = new TipoCategoria(idCategoria);
        int registrosmodificados = new TipoCategoriaDaoJDBC().eliminar(tipocategoria);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
   
}
