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
                                <th class="text-center">nombre</th>
                                <th class="text-center">edad_minima</th>
                                 <th class="text-center">recomendacion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- listado de clasificacion de las peliculas -->
                            <c:forEach var="clasificacion" items="${clasificacion}" varStatus="status">
                                <tr>
                                    <td class="text-center">${clasificacion.id_clasificacion}</td>
                                    <td class="text-center">${clasificacion.nombre} </td>
                                    <td class="text-center">${clasificacion.edad_minima} </td>
                                    <td class="text-center">${clasificacion.recomendacion} </td>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/ServletClasificacion?accion=editar&id_clasificacion=${clasificacion.id_clasificacion}"
                                           class="btn btn-secondary">
                                           
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                       
                <a href="${pageContext.request.contextPath}/ServletClasificacion?accion=eliminar&id_clasificacion=${clasificacion.id_clasificacion}" 
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

<!-- AGREGA LA CLASIFICACION MODAL -->
<jsp:include page="/WEB-INF/paginas/clasificacion/agregarClasificacion.jsp" />
