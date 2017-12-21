<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Student Registration Form</title>

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

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="${cp}/index">Dorm Management System</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>


        <!-- /.navbar-top-links -->

        <!-- /.navbar-static-side -->
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Student Registration Form</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Please complete the form below:
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div>

                                    <div class="alert alert-success alert-dismissable" style="display:none"
                                         id="msgAlert">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                        <div id="resultsSuccess"></div>
                                    </div>

                                    <div class="alert alert-danger alert-dismissable" style="display:none"
                                         id="msgAlertFailed">
                                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                        <div id="resultsError"></div>
                                    </div>

                                    <form role="form" id="formSignUp">
                                        <div class="form-group">
                                            <label>Student Application</label>
                                            <input class="form-control" placeholder="Student ID" id="txtStudId">
                                        </div>
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input class="form-control" placeholder="First Name" id="txtFirstName">
                                            <!--p class="help-block">Example block-level help text here.</p -->
                                        </div>
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input class="form-control" placeholder="Last Name" id="txtLastName">
                                        </div>
                                        <div class="form-group">
                                            <label>Email Address</label>
                                            <input class="form-control" placeholder="Email Address" id="txtEmail">
                                        </div>

                                        <div class="form-group">
                                            <button type="button" class="btn btn-outline btn-primary" id="btnSign">Sign
                                                up
                                            </button>
                                        </div>


                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->


        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${cp}/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${cp}/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${cp}/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${cp}/js/startmin.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $(document).on("click", "#btnSign", function (e) {
            btnSignOperation();
        });


    });


    function btnSignOperation() {

        var jsonRequest = {};

        jsonRequest["fname"] = $("#txtFirstName").val();
        jsonRequest["lname"] = $("#txtLastName").val();
        jsonRequest["email"] = $("#txtEmail").val();
        jsonRequest["studentId"] = $("#txtStudId").val();
        


        var param = JSON.stringify(jsonRequest);

        $.ajax({
                url: "${cp}/api/v1/dorm/student",
                type: "POST",
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");

                },
                data: param,
                success: function (data) {

                    $("#resultsSuccess").html(data.description);
                    document.getElementById("msgAlert").style.display = '';
                    document.getElementById("msgAlertFailed").style.display = 'none';

                    setTimeout(
                        function () {
                            location.reload();
                        }, 7000);


                }
                ,
                error: function (xhr, errorType, exception) {


                    document.getElementById("msgAlertFailed").style.display = '';
                    document.getElementById("msgAlert").style.display = 'none';

                    var responseText = JSON.parse(xhr.responseText);


                    $("#resultsError").html(responseText.description);

                }
            }
        );
    }


</script>

</body>
</html>
