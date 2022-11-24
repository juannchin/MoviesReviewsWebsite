<%-- 
    Document   : clientes
    Created on : 29 sep. 2022, 19:24:31
    Author     : MilaCor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% //In case, if User session is not set, redirect to Login page.
    if((request.getSession(false).getAttribute("userName")!= null) )
    {
    response.sendRedirect("/progra4/login.jsp");
    %>
<%  } %>

        <jsp:include page="/includes/admin_header.jsp" />
        
        <div class="page-wrapper">
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
        
        <!-- incluyendo la cabecera -->
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>
        <!-- incluyendo botones -->
        <jsp:include page="../WEB-INF/paginas/comunes/botones.jsp"/>
        
        <jsp:include page="../WEB-INF/paginas/cliente/listadoCliente.jsp"/>
        
        </div>
            </div>
        </div>
 <jsp:include page="/includes/admin_footer.jsp" />