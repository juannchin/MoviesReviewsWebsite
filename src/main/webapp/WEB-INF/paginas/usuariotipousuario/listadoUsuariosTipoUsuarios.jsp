<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="es_US"/>
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h3>Listado de Usuarios</h3>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Tipo de Usuario</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- iterando cada elemento de la lista de usuarios y tipo de usuario -->
                            <c:forEach var="usuaT" items="${usuarioslista}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${usuaT.nombres} ${usuaT.apellidos}</td>
                                    <td>${usuaT.email}</td>
                                    <td>${usuaT.password}</td>
                                    <td>${usuaT.fecha_nacimiento}</td>
                                    <td>${usuaT.user_type}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletUsuariosTipoUsua?accion=editar&id=${usuaT.id}"
                                           
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- TARJETA PARA CALCULAR No USUARIOS -->
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3" >
                    <div class="card-body">
                        <h3>Total de Usuarios</h3>
                        <h4 class="display-4">
                            <i class="fas fa-user"></i>${totusuarios}
                        </h4>
                    </div>
                </div>
            </div>
        </div>

    </div>
</section>

<!-- AGREGA EL CLIENTE MODAL -->
<jsp:include page="/WEB-INF/paginas/usuariotipousuario/agregarUsuario.jsp" />

