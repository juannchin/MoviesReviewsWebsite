<%-- 
    Document   : listadocasasproductoras
    Created on : 11-21-2022, 11:36:55 AM
    Author     : Marvin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>
<section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                
                    <h3>Listado de Casas productoras</h3>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre casa productora</th>
                                <th>Fecha fundación</th>
                                <th>Subproductoras</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- iterando cada elemento de la lista de productoras -->
                            <!-- iterando cada elemento de la lista de productoras -->
                            <c:forEach var="cas" items="${casalista}" varStatus="status">
                                <tr>
                                    <td>${cas.id_productora}</td>
                                    <td>${cas.nombre_productora}</td>
                                    <td>${cas.fecha_fundacion}</td>
                                    <td>${cas.subproductoras}</td>
                                    <td class="d-flex m-3">
                                                                                    
                                         <a href="${pageContext.request.contextPath}/Servletcasaproductora?accion=editar&idProductora=${cas.id_productora}"
                                           class="btn btn-secondary m-2">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/Servletcasaproductora?accion=eliminar&idProductora=${cas.id_productora}"
                                           class="btn btn-secondary m-2">
                                            <i class="fas fa-angle-double-right"></i>Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                
            </div>
        </div>

    </div>
</section>

<!-- AGREGA PRODUCTORA MODAL -->
<jsp:include page="/WEB-INF/paginas/casa_productora/Agregar_casaproductora.jsp" />



