
package web;

import datos.UsuarioTipoUsuarioDaoJDBC;
import dominio.UsuarioTipoUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo3
 */

@WebServlet("/ServletUsuariosTipoUsua")
public class ServletUsuariosTipoUsua extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        //cod del metodo doPost
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        } 
        
        //Se crea automaticamente el siguiente metodo acccionDeafult.
        //this.accionDefault(request, response); 
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<UsuarioTipoUsuario> usuariosT = new UsuarioTipoUsuarioDaoJDBC().listarUsuaTipoUsua();
        
        //para no duplicar la info del form cambiamos el request por el session
        HttpSession session = request.getSession();
        
        session.setAttribute("usuarioslista", usuariosT);
        session.setAttribute("totusuarios", usuariosT.size());

        //Esto es para no duplicar
        response.sendRedirect("admin/usuariostipousuarios.jsp");
    }
    
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        UsuarioTipoUsuario usuarioTip = new UsuarioTipoUsuarioDaoJDBC().encontrar(new UsuarioTipoUsuario(id));
        request.setAttribute("usuarioTip", usuarioTip);
        
        //definir la pagina jsp
        String jspEditar = "/WEB-INF/paginas/usuariotipousuario/editarUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }  
    }
    
    public void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Agregar Cliente
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        int id_tipo_usuario = 0;
        String idCadena = request.getParameter("id_tipo_usuario");
        
        if(idCadena != null && !"".equals(idCadena)){
            id_tipo_usuario = Integer.parseInt(idCadena);
        } 

        UsuarioTipoUsuario usuario = new UsuarioTipoUsuario(nombres, apellidos, email, 
                password, fecha_nacimiento, id_tipo_usuario);
             
        int registrosmodificados = new UsuarioTipoUsuarioDaoJDBC().insertar(usuario);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
    
    public void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperar los valores del formulario editarCliente.jsp
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        int id_tipo_usuario = 0;
        String idCadena = request.getParameter("id_tipo_usuario");
        
        if(idCadena != null && !"".equals(idCadena)){
            id_tipo_usuario = Integer.parseInt(idCadena);
        } 

        UsuarioTipoUsuario usuario = new UsuarioTipoUsuario(id, nombres, apellidos, email, password, 
                fecha_nacimiento, id_tipo_usuario);
             
        int registrosmodificados = new UsuarioTipoUsuarioDaoJDBC().actualizar(usuario);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }

    public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        UsuarioTipoUsuario usuarioTip = new UsuarioTipoUsuario(id);
        
        int registrosmodificados = new UsuarioTipoUsuarioDaoJDBC().eliminar(usuarioTip);
        
        System.out.println("Registros Modificados = "+registrosmodificados);
        this.accionDefault(request, response);
        
    }
}
