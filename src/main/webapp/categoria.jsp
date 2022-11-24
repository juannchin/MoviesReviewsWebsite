<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="datos.Conexion" %>
<%@page session="true" %>
<jsp:include page="/includes/header.jsp" />
<div id="features-wrapper">
            <div class="container">
                            <div class="row ">
<%
                String id = request.getParameter("categoria");
                try {
                    Connection conn = null; 
                    conn = Conexion.getConnection();
                    String query1 = "select peliculas.id, peliculas.nombre, peliculas.descripcion, peliculas.thumbnail, "
                    + "categorias.nombre as catenom, calificacion.calificacion as calificacion, "
                    + "casa_productora.nombre_productora as nombre_productora, "
                    + "clasificacion.nombre as clasificacion from peliculas "
                    + "INNER JOIN calificacion ON peliculas.id = calificacion.id_pelicula "
                    + "INNER JOIN casa_productora ON peliculas.id_productora = casa_productora.id_productora "
                    + "INNER JOIN categorias ON peliculas.id_categoria = categorias.id "
                    + "INNER JOIN clasificacion ON peliculas.id_clasificacion = clasificacion.id_clasificacion "
                    + "WHERE peliculas.id_categoria="+id+"";
                    Statement st1 = conn.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);

                    while (rs1.next()) {
                    
%>
    <!-- Features -->

                <div class="col-4 col-12-medium">	
                <section class="box feature">

                        <a href="pelicula.jsp?id=<%= rs1.getString("id")%>" class="image featured">
                            <img  style="margin-right: 25px;" src="<%= rs1.getString("thumbnail")%>" height="100%" width="80%" />
                        </a>

                            <div class="inner">
                                <header>
                                    <h2> <%= rs1.getString("nombre")%></h2>
                                    <p>Puntaje: <%= rs1.getString("calificacion")%> de 10</p>
                                </header>

                                <%= rs1.getString("descripcion")%> <br /> <br />

                                Categoria: <%= rs1.getString("catenom")%> <br />
                                Productora: <%= rs1.getString("nombre_productora")%> <br />
                                Clasificación: <%= rs1.getString("clasificacion")%><br />
                                <br />
                            </div>
                </section>
            </div>

        
        <%
            }
                Conexion.close(conn);

                } catch (Exception e1) {
            }
        %>
                </div>
        </div>
</div>
        
<jsp:include page="/includes/footer.jsp" />	
