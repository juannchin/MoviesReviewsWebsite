/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.UsuariosDao;
import dominio.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marvin
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MiServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Esto sirve para imprimir la salida de escritura y así visualizar los datos
        response.setContentType("text/html;charse=UTF-8");
        PrintWriter out = response.getWriter();
        
        //capturamos los datos recibidos del formulario
        //con el objeto request accedemos a los datos enviados y en el metodo getParameter dentro
        //como cadena se escribe el name del control html
        String nombres = request.getParameter("nombres_MR");
        String apellidos = request.getParameter("apellidos_MR");
        String email = request.getParameter("email_MR");
        String password = request.getParameter("password_MR");
        String fecha_nacimiento = request.getParameter("fecha_nacMR");
        String pregunta_r = request.getParameter("preguntaR_MR");
        String respuesta_r = request.getParameter("respuestaR_MR");
        
        //imprimimos los datos con out lo que haremos sera escribir codigo html
        try
        {
            //evaluamos el tipo operación que se realizara 
            String accion = "";
            InsertarUsuario (request, response);
            
                        //lo hacemos solo para confirmar que en el servlet si se reciben los datos
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Los datos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tus nombres son: "+nombres+"</h1>");
            out.println("<h1>Tus apellidos son: "+apellidos+"</h1>");
            out.println("<h1>Tus apellidos son: "+email+"</h1>");
            out.println("<h1>Tus apellidos son: "+password+"</h1>");
            out.println("<h1>Tus apellidos son: "+fecha_nacimiento+"</h1>");
            out.println("<h1>Tus apellidos son: "+pregunta_r+"</h1>");
            out.println("<h1>Tus apellidos son: "+respuesta_r+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        finally
        {
           out.close();
        }
    }
    
    /*creamos el metodo de insertar este metodo desde el servlet solo se encargara de enviar los datos al veradero
    de insertar el cual esta en la clase de usuariosDao*/
    
    public void InsertarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //capturamos los datos recibidos del formulario
        //con el objeto request accedemos a los datos enviados y en el metodo getParameter dentro
        //como cadena se escribe el name del control html
        String nombres = request.getParameter("nombres_MR");
        String apellidos = request.getParameter("apellidos_MR");
        String email = request.getParameter("email_MR");
        String password = request.getParameter("password_MR");
        String fecha_nacimiento = request.getParameter("fecha_nacMR");
        String pregunta_r = request.getParameter("preguntaR_MR");
        String respuesta_r = request.getParameter("respuestaR_MR");
        
        //enviamos los datos a la clase Clientes por medio del constructor con parametros
        //que se encarga de asignar los valores a las variables 
        Usuario user = new Usuario (nombres,apellidos,email,password,fecha_nacimiento,pregunta_r, respuesta_r);
        
        //mandamos el objeto de usuario con sus variables llenas al metodo d einsertar
        UsuariosDao usuario_metodos = new UsuariosDao();
        
        usuario_metodos.InsertarUsuario(user);
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
