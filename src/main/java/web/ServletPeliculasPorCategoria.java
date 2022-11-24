
package web;

import datos.CategoriaPeliculaDao;
import datos.PeliculasDao;
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


@WebServlet(name = "ServletPeliculasPorCategoria", urlPatterns = {"/ServletPeliculasPorCategoria"})
public class ServletPeliculasPorCategoria extends HttpServlet {


      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     
    this.accionDefault(request, response);
    }

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
         List<NombrePeliculas> listapeliculas = new PeliculasDao().listar();
        System.out.println("NombrePeliculas="+  listapeliculas);
         HttpSession sesion = request.getSession();
        sesion.setAttribute("listapeliculas", listapeliculas);
        response.sendRedirect("peliculas.jsp");
       
    }

}
