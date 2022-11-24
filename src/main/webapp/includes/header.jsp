<%-- 
    Document   : header
    Created on : Nov 19, 2022, 9:48:58 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>
<%@page language="java" import="datos.Conexion" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Pelis Deathmatch</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload homepage">
             <%
                ArrayList list = new ArrayList();
                ArrayList sublist = new ArrayList();
                try {
                    Connection conn = null; 
                    conn = Conexion.getConnection();
            %>
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
								<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
							</div>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li class="current"><a href="index.jsp">Inicio</a></li>
									<li>
										<a href="#">Categorias</a>
										<ul>
                                                                                    <%
                                                                                        String query1 = "select * from categorias";
                                                                                        Statement st1 = conn.createStatement();
                                                                                        ResultSet rs1 = st1.executeQuery(query1);

                                                                                        while (rs1.next()) {
                                                                                    %>
											<li><a href="ServletPeliculasPorCategoria?categoria=<%= rs1.getString("id")%>"> <%= rs1.getString("nombre")%></a></li>
                                                                                        <%
                                                                                            } } catch (Exception e1) {
                                                                                            }
                                                                                        %>
										</ul>
									</li>
									<li><a href="no-sidebar.html">Contactanos</a> | </li>
									<li><a href="login.jsp">Login</a></li>
                                                                        <li><a href="registro.jsp">Registrate</a></li>
								</ul>
							</nav>

					</header>
				</div>
