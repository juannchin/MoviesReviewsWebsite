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


<div id="banner-wrapper">
   <div id="banner" class="box container">
                                        
        
         <div class="container">
  <div class="row header">
    <p>Contáctenos</p>
  </div>
  <div class="row body">
    <form action="gracias.jsp">
      <ul>
        
        <li>
          <p class="left">
            <label for="first_name">Nombres</label>
            <input type="text" name="names" placeholder="John" />
          </p>
          <p class="pull-right">
            <label for="last_name">Apellidos</label>
            <input type="text" name="apellidos" placeholder="Smith" />      
          </p>
        </li>
        
        <li>
          <p>
            <label for="email">Email <span class="req">*</span></label>
            <input type="email" name="email" placeholder="john.smith@gmail.com" />
          </p>
        </li>        
        <li>
            <p>
          <label for="comments">Tu comentario</label>
          <textarea cols="46" rows="3" name="comments"></textarea>
          </p>
        </li>
        
        <li>
          <input class="btn btn-submit" type="submit" value="Enviar" />
        </li>
        
      </ul>
    </form>  
  </div>
</div>
        
                                    </div>
                </div>
        
        
        
<jsp:include page="/includes/footer.jsp" />	
