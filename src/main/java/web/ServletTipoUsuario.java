package web;


import datos.TipoUsuarioDaoJDBC;
import dominio.TipoUsuario;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletTipoUsuario")
public class ServletTipoUsuario extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     
             String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                  this.editarTipoUsuario(request, response);
                    break;
                case "eliminar":
                  this.eliminarTipoUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
        
    }
    
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
         List<TipoUsuario>  tipousuarios= new TipoUsuarioDaoJDBC().listar();
        System.out.println("TipoUsuarios="+  tipousuarios);
         HttpSession sesion = request.getSession();
        sesion.setAttribute("tipousuarios",  tipousuarios);
        response.sendRedirect("tipousuarios.jsp");
    }
   
      protected void editarTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        TipoUsuario tipousuario = new TipoUsuarioDaoJDBC().encontrar(new TipoUsuario(idTipoUsuario));
        request.setAttribute("tipousuario", tipousuario);
        //DEFINIR LA PAGINA JSP
        String jspEditar = "/WEB-INF/paginas/tipousuario/editarTipoUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }
      
      
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion= request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarTipoUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarTipoUsuario(request, response);
                     break;
                default:
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    public void insertarTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Agregar Cliente
       String userType = request.getParameter("userType");
        
       
       TipoUsuario tipousuario =new TipoUsuario(userType);
        
        int registrosmodificados =new TipoUsuarioDaoJDBC().insertar(tipousuario);
      
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
      
        public void modificarTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RECUPERAR LOS VALORES DEL FORMULARIO editar.jsp
        int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        String userType = request.getParameter("userType");
    
        TipoUsuario tipousuario = new TipoUsuario(idTipoUsuario,userType);

        int registrosmodificados = new TipoUsuarioDaoJDBC().actualizar(tipousuario);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);

    }
          
         public void eliminarTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        
         TipoUsuario tipousuario= new TipoUsuario(idTipoUsuario);
        int registrosmodificados = new TipoUsuarioDaoJDBC().eliminar(tipousuario);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
   
}
