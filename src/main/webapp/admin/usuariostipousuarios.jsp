<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:include page="/includes/admin_header.jsp" />
 
         <div class="page-wrapper">
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
 
        <jsp:include page="/WEB-INF/paginas/comunes/cabeceraEditUsuario.jsp" />
        <jsp:include page="/WEB-INF/paginas/comunes/botonesUsuario.jsp" />
        
        
        <jsp:include page="/WEB-INF/paginas/usuariotipousuario/listadoUsuariosTipoUsuarios.jsp" />
         </div>
        </div>
        </div>
        
        <jsp:include page="/includes/admin_footer.jsp" />