<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Usuario</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletUsuariosTipoUsua?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for "nombres">Nombre</label>
                        <input type="text" class="form-control" name="nombres" required>
                    </div>
                    <div class="form-group">
                        <label for "apellidos">Apellido</label>
                        <input type="text" class="form-control" name="apellidos" required>
                    </div>
                    <div class="form-group">
                        <label for "email">Email</label>
                        <input type="text" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for "password">Contraseña</label>
                        <input type="password" class="form-control" name="password" required>
                    </div>
                    <div class="form-group">
                        <label for "fecha_nacimiento">Fecha de Nacimiento</label>
                        <input type="text" class="form-control" name="fecha_nacimiento" required>
                    </div>
                    <div class="form-group">
                        <label for "id_tipo_usuario">Tipo de Usuario</label>
                        <select name="id_tipo_usuario" class="form-control">
                            <option value="1">Administrador</option>
                            <option value="2" selected>Usuario</option>
                            <option value="3">Visitante</option>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
