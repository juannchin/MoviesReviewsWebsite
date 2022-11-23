
package web;

import datos.CategoriasDao;
import dominio.NombrePeliculas;
import dominio.TipoCategoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletCategorias", urlPatterns = {"/ServletCategorias"})
public class ServletCategorias extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "Filtro":
                  this.accionDefault(request, response);
                    break;
              
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

  protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

TipoCategoria  idcategoria = null;

        List<NombrePeliculas> listapeliculas = new CategoriasDao().listarporCategoria(idcategoria);
        System.out.println("NombrePeliculas="+  listapeliculas);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listapeliculas", listapeliculas);
        response.sendRedirect("header.jsp");
       
    }

}
