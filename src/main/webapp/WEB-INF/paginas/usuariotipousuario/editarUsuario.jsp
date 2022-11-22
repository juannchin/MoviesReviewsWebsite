        <jsp:include page="/includes/admin_header.jsp" />
        
        <div class="page-wrapper">
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
        
        <!-- incluyendo la cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabeceraEditUsuario.jsp"/>
        <!-- incluyendo botones -->

        <form action="${pageContext.request.contextPath}/ServletUsuariosTipoUsua?accion=modificar&id=${usuarioTip.id}"
                method="POST" class="was-validated">
            
            <!-- Botones -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegadorEdicionUsuarios.jsp"/>
            
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Usuario</h4>
                                </div>
                                
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for "nombres">Nombre</label>
                                        <input type="text" class="form-control" name="nombres" required value="${usuarioTip.nombres}">
                                    </div>
                                    <div class="form-group">
                                        <label for "apellidos">Apellido</label>
                                        <input type="text" class="form-control" name="apellidos" required value="${usuarioTip.apellidos}">
                                    </div>
                                    <div class="form-group">
                                        <label for "email">Email</label>
                                        <input type="text" class="form-control" name="email" required value="${usuarioTip.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for "password">Contraseña</label>
                                        <input type="password" class="form-control" name="password" required value="${usuarioTip.password}">
                                    </div>
                                    <div class="form-group">
                                        <label for "fecha_nacimiento">Fecha de Nacimiento</label>
                                        <input type="text" class="form-control" name="fecha_nacimiento" required value="${usuarioTip.fecha_nacimiento}">
                                    </div>
                                    <div class="form-group">
                                        <label for "id_tipo_usuario">Tipo de Usuario</label>
                                        <select name="id_tipo_usuario" class="form-control" >
                                            <option value="${usuarioTip.id_tipo_usuario}">${usuarioTip.user_type}</option>
                                            <option value="1">Administrador</option>
                                            <option value="2">Usuario</option>
                                            <option value="3">Visitante</option>
                                        </select>
                                    </div>
                                </div>      
                            </div>
                        </div>
                    </div>
                </div>
 
            </section>
                       
        </form>
        
                </div>
        </div>
        </div>
        
        <jsp:include page="/includes/admin_footer.jsp" />