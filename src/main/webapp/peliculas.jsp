<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="/includes/header.jsp" />
<!-- Banner -->
<div id="banner-wrapper">
    <div id="banner" class="box container">
        <h2>Bienvenidos.</h2>
        <p>Este es un espacio para comentar y calificar sobre nuestras peliculas favoritas!</p>
    </div>
</div>

<!-- Features -->
<div id="features-wrapper">
    <div class="container">

        <!-- Box -->

        <div class="row ">

            <c:forEach var="peliculas" items="${listapeliculas}" varStatus="status">
                <div class="col-4 col-12-medium">	
                    <section class="box feature">
                        <a href="#" class="image featured"><img src="${peliculas.thumbnail}" height="100%" width="80%"></a>

                        <div class="inner">
                            <header>
                                <h2> ${peliculas.nombrePelicula}</h2>
                                <p>Puntaje: ${peliculas.calificacion} de 10</p>
                            </header>

                            ${peliculas.descripcion} <br>
                            ${peliculas.categoria} <br>
                            ${peliculas.productora} <br>
                            ${peliculas.edad_minima}<br>


                            </section>
                        </div>
                    </c:forEach>


            </div>
        </div>
    </div>

    <!-- Main -->
    <div id="main-wrapper">
        <div class="container">
            <div class="row gtr-200">
                <div class="col-4 col-12-medium">

                    <!-- Sidebar -->
                    <div id="sidebar">
                        <section class="widget thumbnails">
                            <h3>Unete a nuestra comunidad</h3>
                            <div class="grid">
                                <div class="row gtr-50">
                                    <div class="col-6"><a href="#" class="image fit"><img src="images/pic04.jpg" alt="" /></a></div>
                                    <div class="col-6"><a href="#" class="image fit"><img src="images/pic05.jpg" alt="" /></a></div>
                                    <div class="col-6"><a href="#" class="image fit"><img src="images/pic06.jpg" alt="" /></a></div>
                                    <div class="col-6"><a href="#" class="image fit"><img src="images/pic07.jpg" alt="" /></a></div>
                                </div>
                            </div>
                        </section>
                    </div>

                </div>
                <div class="col-8 col-12-medium imp-medium">

                    <!-- Content -->
                    <div id="content">
                        <section class="last">
                            <h2>El poder de nuestra comunidad</h2>
                            <p>Somos <strong>Pelis</strong> Deathmatch, una comunindad de apasionados de las peliculas.<br />
                                Registrándote a nuestro sitio Web podrás calificar las peliculas que constantemente publicamos en nuestro portal de Internet, y formarás parte de la red más gran de cinéfilos en la Web</p>
                            <a href="#" class="button icon fa-file-alt">Registrarse</a>
                        </section>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/includes/footer.jsp" />		