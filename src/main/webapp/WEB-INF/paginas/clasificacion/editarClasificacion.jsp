<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Clasificacion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/64c8d7120b.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/clasificacion/cabecera_clasificacion.jsp" />

        <form action="${pageContext.request.contextPath}/ServletClasificacion?accion=modificar&id_clasificacion=${clasificacion.id_clasificacion}"
              method="POST" class="was-validated">
            <!-- Botones -->
            <jsp:include page="/WEB-INF/paginas/clasificacion/botones_NE_clasificacion.jsp" />
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Clasificacion</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                         
                                          <label for "nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${clasificacion.nombre}"> 
                                       
                                    </div>
                                           
                                           <div class="form-group">
                                         
                                          <label for "edad_minima">Edad_minima</label>
                                          <input type="text" class="form-control" name="edad_minima" required value="${clasificacion.edad_minima}">  
                                          
                                    </div>
                                          
                                          <div class="form-group">
                                         
                                              <label for "recomendacion">Recomendacion</label>
                                          <input type="text" class="form-control" name="recomendacion" required value="${clasificacion.recomendacion}">   
                                           
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