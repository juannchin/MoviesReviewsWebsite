<section id="actions" class="py-4 nb-4 bg-ligth">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fas-arrow-left"></i> Retorno al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fas-check"></i> Guardar Cliente
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&id_cliente=${cliente.id_cliente}" 
                   class="btn btn-danger btn-block">
                    <i class="fas fas-trash"></i> Eliminar Cliente
                </a>
            </div>
        </div>
    </div>
</section>
