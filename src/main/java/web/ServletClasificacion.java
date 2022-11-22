package web;

/**
 *
 * @author carlos vidal
 */
import datos.ClasificacionDao;
import dominio.Clasificacion;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
   
    @WebServlet("/ServletClasificacion")
public class ServletClasificacion extends HttpServlet{
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
            String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                  this.editarClasificacion(request, response);
                    break;
                case "eliminar":
                  this.eliminarClasificacion(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
         List<Clasificacion>  clasificacion= new ClasificacionDao().listar();
        
        System.out.println("Clasificacion="+  clasificacion);
         HttpSession sesion = request.getSession();
        sesion.setAttribute("clasificacion",  clasificacion);
        response.sendRedirect("admin/clasificacion.jsp");
    }
    
     protected void editarClasificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_clasificacion = Integer.parseInt(request.getParameter("id_clasificacion"));
        Clasificacion clasificacion = new ClasificacionDao().encontrar(new Clasificacion(id_clasificacion));
        request.setAttribute("clasificacion", clasificacion);
        //DEFINIR LA PAGINA JSP
        String jspEditar = "/WEB-INF/paginas/clasificacion/editarClasificacion.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }
     
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarClasificacion(request, response);
                    break;
                case "modificar":
                    this.modificarClasificacion(request, response);
                     break;
                default:
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
     public void insertarClasificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Clasificacion
       String nombre = request.getParameter("nombre");
        String edad_minima = request.getParameter("edad_minima");
        String recomendacion = request.getParameter("recomendacion");
       
       Clasificacion clasificacion =new Clasificacion(nombre,edad_minima,recomendacion);
        
        int registrosmodificados =new ClasificacionDao().insertar(clasificacion);
      
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
      
     public void modificarClasificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RECUPERAR LOS VALORES DEL FORMULARIO editar.jsp
        int id_clasificacion = Integer.parseInt(request.getParameter("id_clasificacion"));
        String nombre = request.getParameter("nombre");
        String edad_minima = request.getParameter("edad_minima");
        String recomendacion = request.getParameter("recomendacion");
    
        Clasificacion clasificacion = new Clasificacion(id_clasificacion, nombre, edad_minima, recomendacion);

        int registrosmodificados = new ClasificacionDao().actualizar(clasificacion);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);

    }
     
      public void eliminarClasificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id_clasificacion = Integer.parseInt(request.getParameter("id_clasificacion"));
        
         Clasificacion clasificacion = new Clasificacion(id_clasificacion);
        int registrosmodificados = new ClasificacionDao().eliminar(clasificacion);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
}

  
    

