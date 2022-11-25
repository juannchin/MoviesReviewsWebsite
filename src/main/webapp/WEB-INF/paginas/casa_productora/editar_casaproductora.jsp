<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar productora</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/64c8d7120b.js" crossorigin="anonymous"></script>
    </head>
    <body>

            <form action="${pageContext.request.contextPath}/Servletcasaproductora?accion=modificar&idProductora=${casa.id_productora}"
              method="POST" class="was-validated">
            <!-- Botones -->
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar casa productora</h4>
                                </div>
                                <div class="card-body">
                                    <!-- <div class="form-group">
                                        <label for "codEmpleado">Codigo de casa productora</label>
                                        <input type="number" class="form-control" name="codProductora" required value="${casa.id_productora}" step="any">
                                    </div> -->
                                    <div class="form-group">
                                        <label for "nombre">Nombre productora</label>
                                        <input type="text" class="form-control" name="nombreProductora" required value="${casa.nombre_productora}">
                                    </div>

                                    <div class="form-group">
                                        <label for "email">fecha fundacion</label>
                                        <input type="text" class="form-control" name="fecha_f" required value="${casa.fecha_fundacion}">
                                    </div>
                                    <div class="form-group">
                                        <label for "telefono">SubProductoras</label>
                                        <input type="text" class="form-control" name="subproductoras" required value="${casa.subproductoras}">
                                    </div>
                                    <br> <br>
                                    <div class="modal-footer">
                                        <button class="btn btn-primary" type="submit">Actualizar</button>
                                    </div>
                                    
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script><!-- comment -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    </body>
</html>
