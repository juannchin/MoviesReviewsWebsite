
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
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
 * @author MilaCor
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        //cod del metodo doPost
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
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
        
        List<Cliente> clientes= new ClienteDaoJDBC().listar();
        System.out.println("Clientes="+ clientes);
        
        //para no duplicar la info del form cambiamos el request por el session
        HttpSession session = request.getSession();
        
        session.setAttribute("clientelista", clientes);
        session.setAttribute("totclientes", clientes.size());
        session.setAttribute("sTotal", this.calcularSaldoTotal(clientes));
        
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
        //Esto es para no duplicar
        response.sendRedirect("clientes.jsp");
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal=0;
        for(Cliente cliente : clientes){
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(id_cliente));
        request.setAttribute("cliente", cliente);
        
        //definir la pagina jsp
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }  
    }
    
    public void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperamos los valores del formulario Agregar Cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoCadena = request.getParameter("saldo");
        
        if(saldoCadena != null && !"".equals(saldoCadena)){
            saldo = Double.parseDouble(saldoCadena);
        } 
        
        int edad = 0;//
        String edadCadena = request.getParameter("edad");
        if(edadCadena != null && !"".equals(edadCadena)){
            edad = Integer.parseInt(edadCadena);
        } 

        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo, edad);
             
        int registrosmodificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }
    
    public void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Recuperar los valores del formulario editarCliente.jsp
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoCadena = request.getParameter("saldo");
        
        if(saldoCadena != null && !"".equals(saldoCadena)){
            saldo = Double.parseDouble(saldoCadena);
        } 
        
        int edad = 0;//
        String edadCadena = request.getParameter("edad");
        if(edadCadena != null && !"".equals(edadCadena)){
            edad = Integer.parseInt(edadCadena);
        } 

        Cliente cliente = new Cliente(id_cliente, nombre, apellido, email, telefono, saldo, edad);
             
        int registrosmodificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosmodificados = " + registrosmodificados);
        this.accionDefault(request, response);
    }

    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        
        Cliente cliente = new Cliente(id_cliente);
        
        int registrosmodificados = new ClienteDaoJDBC().eliminar(cliente);
        
        System.out.println("Registros Modificados = "+registrosmodificados);
        this.accionDefault(request, response);
        
    }
}
