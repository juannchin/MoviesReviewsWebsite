<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="es_US"/>
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h3>Listado de Clientes</h3>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Edad</th>
                                <th>Telefono</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- iterando cada elemento de la lista de clientes -->
                            <c:forEach var="clie" items="${clientelista}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${clie.nombre} ${clie.apellido}</td>
                                    <td>${clie.edad}</td>
                                    <td>${clie.telefono}</td>
                                    <td><fmt:formatNumber value="${clie.saldo}" type="currency" />
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&id_cliente=${clie.id_cliente}"
                                           
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
            <!-- TARJETA PARA CALCULAR No CLIENTES Y VALOR TOTAL -->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${sTotal}" type="currency" />
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3" >
                    <div class="card-body">
                        <h3>Total de Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-user"></i>${totclientes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>

    </div>
</section>

<!-- AGREGA EL CLIENTE MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp" />

