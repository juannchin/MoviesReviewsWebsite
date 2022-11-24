<div class="modal fade" id="agregarTipoCategoriaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Agregar Categoria</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletCategoria?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for "nombreCategorias">Nombre de la categoria </label>
                        <input type="text" class="form-control" name="nombreCategorias"required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
                  
