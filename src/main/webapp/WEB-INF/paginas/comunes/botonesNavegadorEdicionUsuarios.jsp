<section id="actions" class="py-4 nb-4 bg-ligth">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletUsuariosTipoUsua" class="btn btn-ligth btn-block">
                    <i class="fas fas-arrow-left"></i> Retorno al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fas-check"></i> Guardar Usuario
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletUsuariosTipoUsua?accion=eliminar&id=${usuarioTip.id}" 
                   class="btn btn-danger btn-block">
                    <i class="fas fas-trash"></i> Eliminar Usuario
                </a>
            </div>
        </div>
    </div>
</section>
