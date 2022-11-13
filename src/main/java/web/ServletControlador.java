package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
//import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes=" + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientelista", clientes);
        sesion.setAttribute("totclientes", clientes.size());
        sesion.setAttribute("sTotal", this.calcularsaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularsaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;

    }

    protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        //DEFINIR LA PAGINA JSP
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    public void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los valores del formulario Agregar Cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoCadena = request.getParameter("saldo");
        if (saldoCadena != null && !"".equals(saldoCadena)) {
            saldo = Double.parseDouble(saldoCadena);
        }
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        int registrosmodificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);

    }

    public void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RECUPERAR LOS VALORES DEL FORMULARIO editarCliente.jsp
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoCadena = request.getParameter("saldo");
        if (saldoCadena != null && !"".equals(saldoCadena)) {
            saldo = Double.parseDouble(saldoCadena);
        }
        Cliente cliente = new Cliente(idCliente,nombre, apellido, email, telefono, saldo);

        int registrosmodificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);

    }
    
    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        Cliente cliente= new Cliente(idCliente);
        int registrosmodificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
    

}
