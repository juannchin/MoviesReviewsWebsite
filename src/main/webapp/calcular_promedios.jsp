<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="datos.Conexion" %>
<%@page session="true" %>
<jsp:include page="/includes/header.jsp" />
<%
                    
                /*try {*/
                    Connection conn = null; 
                    conn = Conexion.getConnection();
                    String query1 = "select * from peliculas";
                    Statement st1 = conn.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);
                    
                    while(rs1.next())
                {
                    String id = rs1.getString("id");
                    
                    String query2 = "select id_pelicula, AVG(puntuacion) from rating WHERE rating.id_pelicula="+id+"";
                    Statement st2 = conn.createStatement();
                    ResultSet rs2 = st2.executeQuery(query1);
                    
                     Statement st=conn.createStatement();
                     int i=st.executeUpdate("insert into calificacion (id_pelicula, calificacion) "
                            + "VALUES ("+rs2.getString("id_pelicula")+", "+rs2.getString("calificacion")+"");
                    
                }
                    

 %>
<div id="banner-wrapper">
   <div id="banner" class="box container">
                                        
        
         <section class="box feature">
             <div style="float:left">
                
             </div>
                        <div style="margin-left: 25px;">
                            <header>
                                <h2>Promedios calculados!</h2>
                                
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
