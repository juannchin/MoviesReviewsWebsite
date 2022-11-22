<!--Importamos la clase de conexion al index.jsp usando esta etiqueta de expresion-->
<%@page import="datos.Conexion" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />

        <!--Creamos el formulario de registro de usuarios -->
        <div id="contenedor_formularioR">
            <form method="post" action="UsuariosServlet">
                <h1 id="titulo_MR">Menu registrarse</h1>
                <br><br>
                Nombres

                <input type="text" class="controls_MR" placeholder="Escriba sus nombres" name="nombres_MR">
                
                Apellidos

                <input type="text" class="controls_MR" placeholder="Escriba sus apellidos" name ="apellidos_MR">
                 
            
                 Email

                <input type="email" class="controls_MR" placeholder="ejemplo@gmail.com" name="email_MR">
               
                 Contraseña

                <input type="password" class="controls_MR" placeholder="Escriba su contraseña" name="password_MR">
                
                 Verificar Contraseña

                <input type="password" class="controls_MR" placeholder="Escriba su contraseña otra vez">
                
                 fecha de nacimiento

                <input type="date" class="controls_MR" name = "fecha_nacMR">
                
                Pregunta de recuperación de contraseña
                <br><br>
                <select id="select_MR" name = "preguntaR_MR">
                    <option>Nombre de tu primera mascota</option>
                    <option>Nombre de tu lugar favorito</option>
                    <option>Nombre de tu comida favorita</option>
                    <option>Nombre de tu lugar de nacimiento</option>
                    <option>Nombre de tu familiar más cercano</option>
                </select>
                <br><br>
                Respuesta para recuperación de contraseña
                <br><br>
                <input type="text" class="controls_MR" placeholder="Escriba su respuesta a la pregunta" name ="respuestaR_MR">
                
                <br><br>
                <input type="submit" id="btn_registrarse" Value="Registrarse">
                
            </form>
        </div>
        
<jsp:include page="/includes/footer.jsp" />
    </body>
</html>
