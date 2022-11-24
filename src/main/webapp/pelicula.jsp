<%-- 
    Document   : pelicula
    Created on : Nov 23, 2022, 11:38:27 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="datos.Conexion" %>
<%@page session="true" %>
<jsp:include page="/includes/header.jsp" />
<%
                String id = request.getParameter("id");
                try {
                    Connection conn = null; 
                    conn = Conexion.getConnection();
                    String query1 = "select peliculas.nombre, peliculas.descripcion, peliculas.thumbnail, "
                    + "categorias.nombre as catenom, calificacion.calificacion as calificacion, "
                    + "casa_productora.nombre_productora as nombre_productora, "
                    + "clasificacion.nombre as clasificacion from peliculas "
                    + "INNER JOIN calificacion ON peliculas.id = calificacion.id_pelicula "
                    + "INNER JOIN casa_productora ON peliculas.id_productora = casa_productora.id_productora "
                    + "INNER JOIN categorias ON peliculas.id_categoria = categorias.id "
                    + "INNER JOIN clasificacion ON peliculas.id_clasificacion = clasificacion.id_clasificacion "
                    + "WHERE peliculas.id="+id+"";
                    Statement st1 = conn.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);

                    while (rs1.next()) {
                    
%>
<div id="banner-wrapper">
   <div id="banner" class="box container">
                                        
        
         <section class="box feature">
             <div style="float:left">
                 <a href="#" class="featured"><img style="margin-right: 25px;" src="<%= rs1.getString("thumbnail")%>" width="300" /></a>
             </div>
                        <div style="margin-left: 25px;">
                            <header>
                                <h2> <%= rs1.getString("nombre")%></h2>
                                <p>Puntaje: <%= rs1.getString("calificacion")%> de 10</p>
                                 <%
                                    String uid = (String)session.getAttribute("User");
                                    if (uid != null)
                                    {
                                    %>
                                    <form name="vatacion" onsubmit="servletVotacion">
                                    <p>Tu puntuación: 
                                    <select name="votacion" style="width: 100px;">
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                    </select>
                                        <input class="clear" type="submit" name="votar" value="Votar" style="all:unset;border: 1px;background: #ff0000; color:#fcfdfd; font-weight: bold; width: 125px; text-align: center">
                                <%	
                                    } else {
                                %>
                                <p>Debes de estar registrado para poder votar</p>
                                 <%	
                                    } 
                                %>
                            </header>

                            <%= rs1.getString("descripcion")%> <br /> <br />

                            Categoria: <%= rs1.getString("catenom")%> <br />
                            Productora: <%= rs1.getString("nombre_productora")%> <br />
                            Clasificación: <%= rs1.getString("clasificacion")%><br />
                            <br />

                            
                        </div>

                            </section>
        
                                    </div>
                </div>
        
        <%
                    }
                        Conexion.close(conn);

                        } catch (Exception e1) {
                    }
                %>
        
<jsp:include page="/includes/footer.jsp" />	
