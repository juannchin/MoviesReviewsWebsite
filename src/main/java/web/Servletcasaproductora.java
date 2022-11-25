/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.CasaProductoraDAO;
import dominio.Casa_productora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marvin
 */
@WebServlet(name = "Servletcasaproductora", urlPatterns = {"/Servletcasaproductora"})
public class Servletcasaproductora extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion= request.getParameter("accion");
        if(accion != null)
        {
            switch(accion)
            {
                case "eliminar":
                    this.eliminarCasaProductora(request, response);
                    break;
                case "editar":
                    this.editarCasa(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        }
        else
        {
            this.accionDefault(request, response);
        }
            
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        
        String accion= request.getParameter("accion");
        if(accion != null)
        {
            switch(accion)
            {
                case "insertar":
                    this.insertarCasaProductora(request, response);
                    break;
                case "modificar":
                    this.modificarCasa(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        }
    }
    
    //creamos el metodo de insertar casa productora
     public void insertarCasaProductora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Agregar Cliente
        String nombre_productora= request.getParameter("txtnombre_productora");
        String fecha= request.getParameter("txtfecha_funda");
        String subproductoras= request.getParameter("txtsub_productoras");
        

        Casa_productora casa =new Casa_productora(nombre_productora, fecha, subproductoras);
        
        int registrosmodificados =new CasaProductoraDAO().Insertar(casa);
        System.out.println("REGISTROS INSERTADOS = " + registrosmodificados);
        this.accionDefault(request, response);
        //this.accionDefault(request, response);
        
        
    }
     
     protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
             
        List<Casa_productora> casas= new CasaProductoraDAO().listar();
        System.out.println("Casas="+ casas);
        //request.setAttribute("casalista", casas);
        //request.getRequestDispatcher("/admin/casa_productora.jsp").forward(request, response);
        //response.sendRedirect("admin/casa_productora.jsp");
        HttpSession sesion = request.getSession();
        sesion.setAttribute("casalista",  casas);
        response.sendRedirect("admin/casa_productora.jsp");
    }
          
     public void eliminarCasaProductora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int idProductora = Integer.parseInt(request.getParameter("idProductora"));
        
        Casa_productora casa = new Casa_productora(idProductora);
        int registrosmodificados = new CasaProductoraDAO().eliminar(casa);
        System.out.println("registros ELIMINADOS = " + registrosmodificados);
        this.accionDefault(request, response);
    }
     
     //metodo para enviar los datos al modal
     private void editarCasa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProductora = Integer.parseInt(request.getParameter("idProductora"));
        Casa_productora casa = new CasaProductoraDAO().encontrar(new Casa_productora (idProductora));
        request.setAttribute("casa", casa);
        String jspEditar = "/WEB-INF/paginas/casa_productora/editar_casaproductora.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
     
     public void modificarCasa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RECUPERAR LOS VALORES DEL FORMULARIO editarCliente.jsp
        
        int idProductora= Integer.parseInt(request.getParameter("idProductora"));
        String nombre_productora= request.getParameter("nombreProductora");
        String fecha= request.getParameter("fecha_f");
        String subproductoras= request.getParameter("subproductoras");
       
        Casa_productora casa =new Casa_productora(idProductora,nombre_productora, fecha, subproductoras);
         
        int registrosmodificados = new CasaProductoraDAO().actualizar(casa);
        System.out.println("REGISTROS ACTUALIZADOS = " + registrosmodificados);
        this.accionDefault(request, response);

    }
}
