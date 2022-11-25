<div class="modal fade" id="agregarClasificacionModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Agregar Clasificacion</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletClasificacion?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for "nombre">nombre de la clasificacion</label>
                        <input type="text" class="form-control" name="nombre"required>
                    </div>
                    
                    <div class="form-group">
                        <label for "edad_minima">edad minima</label>
                        <input type="text" class="form-control" name="edad_minima"required>
                    </div>
                    
                    <div class="form-group">
                        <label for "recomendacion">recomendacion</label>
                        <input type="text" class="form-control" name="recomendacion"required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
