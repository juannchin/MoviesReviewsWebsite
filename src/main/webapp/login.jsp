<%-- 
    Document   : login
    Created on : Nov 19, 2022, 9:45:04 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />

<!-- Banner -->
				<div id="banner-wrapper">
                                    <div class="wrapper">
                                        <form class="form-signin"  action="ServletLogin" method="post">       
                                          <h2 class="form-signin-heading">Identifiquese</h2> 
                                          <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
                                          <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
                                          <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
                                        </form>
                                    </div>
				</div>

<jsp:include page="/includes/footer.jsp" />	
