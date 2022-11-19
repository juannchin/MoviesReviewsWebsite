<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <div class="card-header">
                    
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th class="text-center">#</th>
                                <th class="text-center">user_type</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- iterando cada elemento de la lista de clientes -->
                            <c:forEach var="tipousuario" items="${tipousuarios}" varStatus="status">
                                <tr>
                                    <td class="text-center">${tipousuario.idTipoUsuario}</td>
                                    <td class="text-center">${tipousuario.userType} </td>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/ServletTipoUsuario?accion=editar&idTipoUsuario=${tipousuario.idTipoUsuario}"
                                           class="btn btn-secondary">
                                           
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                       
                <a href="${pageContext.request.contextPath}/ServletTipoUsuario?accion=eliminar&idTipoUsuario=${tipousuario.idTipoUsuario}" 
                    class="btn btn-danger btn-block">
                   <i class="fas fa-trash"></i> Eliminar
                </a>
          
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
          
        </div>

    </div>
</section>

<!-- AGREGA EL CLIENTE MODAL -->
<jsp:include page="/WEB-INF/paginas/tipousuario/agregarTipoUsuario.jsp" />

