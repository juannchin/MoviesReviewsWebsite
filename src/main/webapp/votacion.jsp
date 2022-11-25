<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="datos.Conexion" %>
<%@page session="true" %>
<jsp:include page="/includes/header.jsp" />
<%
                String voto = request.getParameter("votacion");
                String pelicula = request.getParameter("pelicula_id");
                String user = request.getParameter("user_id");
                    
                /*try {*/
                    Connection conn = null; 
                    conn = Conexion.getConnection();
                    String query1 = "select id from usuarios WHERE usuarios.email='"+user+"'";
                    Statement st1 = conn.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);
                    rs1.next();
                    String userid = rs1.getString("id");
                    
                    Statement st=conn.createStatement();
                    int i=st.executeUpdate("insert into rating (id_usuario, id_pelicula, puntuacion) "
                            + "VALUES ("+userid+", "+pelicula+", "+voto+")");
           
                    /*String query2 = "INSERT INTO rating (id_usuario, id_pelicula, puntuacion) "
                                    + "VALUES ("+userid+", "+pelicula+", "+voto+")";
                    Statement st2 = conn.createStatement();
                    ResultSet rs2 = st2.executeQuery(query1);*/
                    

 %>
<div id="banner-wrapper">
   <div id="banner" class="box container">
                                        
        
         <section class="box feature">
             <div style="float:left">
                
             </div>
                        <div style="margin-left: 25px;">
                            <header>
                                <h2>Gracias por tu voto!!</h2>
                                
                            <br />

                            
                        </div>

                            </section>
        
                                    </div>
                </div>
        
        <% 
                        Conexion.close(conn);

                        /*} catch (Exception e1) {
                    }*/
                %>
        
<jsp:include page="/includes/footer.jsp" />	
