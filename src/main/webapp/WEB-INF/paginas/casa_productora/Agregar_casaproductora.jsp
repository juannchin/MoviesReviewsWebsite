<div class="modal fade" id="agregar_casaproductora">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Casa productora</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/Servletcasaproductora?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for "nombre">Nombre productora</label>
                        <input type="text" class="form-control" name="txtnombre_productora"required>
                    </div>
                    <div class="form-group">
                        <label for "apellido">fecha fundación</label>
                        <input type="date" class="form-control" name="txtfecha_funda"required>
                    </div>
                    <div class="form-group">
                        <label for "email">Subproductoras</label>
                        <input type="text" class="form-control" name="txtsub_productoras"required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>

