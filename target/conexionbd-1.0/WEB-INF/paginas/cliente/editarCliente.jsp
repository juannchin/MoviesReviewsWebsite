<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/473f21833f.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <!-- incluyendo la cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <!-- incluyendo botones -->

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&id_cliente=${cliente.id_cliente}"
                method="POST" class="was-validated">
            
            <!-- Botones -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegadorEdicion.jsp"/>
            
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for "nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for "apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for "email">Email</label>
                                        <input type="text" class="form-control" name="email" required value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for "telefono">Teléfono</label>
                                        <input type="text" class="form-control" name="telefono" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for "saldo">Saldo</label>
                                        <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any">
                                    </div>
                                    <div class="form-group">
                                        <label for "saldo">Edad</label>
                                        <input type="number" class="form-control" name="edad" required value="${cliente.edad}">
                                    </div>
                                </div>      
                            </div>
                        </div>
                    </div>
                </div>
 
            </section>
                       
        </form>
        
        <jsp:include page="/WEB-INF/paginas/comunes/piepagina.jsp"/>
    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    </body>
</html>
