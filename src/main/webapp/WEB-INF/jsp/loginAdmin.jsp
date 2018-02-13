<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"/>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dorm Management System: Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${cp}/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${cp}/css/startmin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${cp}/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">

                     <div>
                                    <c:if test="${not empty response}">
                                       
                                        <font color="red" style='vertical-align: auto'>${response}</font>
                                            
                                    </c:if>
                                </div>
                    <form:form role="form" method="POST"
                               action="${cp}/api/v1/dorm/user/authenticate/admin">
                        <fieldset>
                            <div class="form-group">
                                <form:input class="form-control" placeholder="E-mail" name="email" type="email"
                                            path="username"/>
                                
                            </div>
                            <div class="form-group">
                                <form:input class="form-control" placeholder="Password" name="password" type="password"
                                            value="" path="password"/>
                                       
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <div class="form-group">
                                <button type="submit" class="btn btn-outline btn-primary" id="btnLogin">Login
                                </button>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="${cp}/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${cp}/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${cp}/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${cp}/js/startmin.js"></script>

</body>
</html>
