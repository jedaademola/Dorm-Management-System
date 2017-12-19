
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

    <title>Dorm Management System: Check in and Checkout</title>

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
            <a class="navbar-brand" href="{cp}/index">Dorm Management System</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>


        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="${cp}/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>

                    <li>
                        <a href="${cp}/studentForm"><i class="fa fa-table fa-fw"></i> Apply for Room</a>
                    </li>
                    <li>
                        <a href="${cp}/complaint"><i class="fa fa-edit fa-fw"></i> Log Complaint</a>
                    </li>
                    <li>
                        <a href="${cp}/statement"><i class="fa fa-dashboard fa-fw"></i> Check in/Check out</a>
                    </li>

                    <li>
                        <a href="${cp}/logout"><i class="fa"></i> Logout</a>
                    </li>


                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Check in/Checkout form</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Please complete the form below:
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
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


                                <form:form role="form" id="checkinAndOut">


                                        <%--<div class="form-group">--%>
                                            <%--<label>Student Number</label>--%>
                                            <%--<input class="form-control" placeholder="Your student number" id="txtStudentNo">--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                        <%--<label>Building</label>--%>
                                        <%--<input class="form-control" placeholder="Building Number" id="txtBuilding">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group">--%>
                                        <%--<label>Room</label>--%>
                                        <%--<input class="form-control" placeholder="Room number" id="txtRoom">--%>
                                    <%--</div>--%>
                                    <div class="form-group">
                                        <label>Category</label>
                                        <div class="form-group">
                                        <select class="selectpicker">
                                            <option>---select---</option>
                                            <option id ="checkout">Checkout</option>
                                            <option id = "checkIn">Check in</option>
                                        </select>
                                        </div>
                                    </div>




                                    <div class="form-group">
                                        <label >Items</label>
                                        <select multiple="true"class="form-control" id="items" >
                                            <%--<option value="0">----Select---</option>--%>
                                            <options items="${items}" itemLabel="name" itemValue="id" />
                                        </select>
                                        <%--<div class="error"><errors path="blogCategory" /></div>--%>
                                    </div>

                                        <div class="form-group">
                                            <button type="button" class="btn btn-outline btn-primary" id="btnStatement">
                                                Submit
                                            </button>
                                        </div>

                                </form:form>

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

        $(document).on("click", "#btnStatement", function (e) {
            btnOperation();
        });


    });


    function btnOperation() {

        var jsonRequest = {};

        jsonRequest["category"] = $("#checkout").val();
        //jsonRequest["items"] =[ $("#chair").val(), $("#table").val(),$("#bed").val(),$("#wardrobe").val() ];
        // jsonRequest["subject"] = $("#chair").val();
        // jsonRequest["description"] = $("#table").val();
        // jsonRequest["subject"] = $("#bed").val();
        // jsonRequest["description"] = $("#wardrobe").val();


        var param = JSON.stringify(jsonRequest);

        $.ajax({
                url: "${cp}/api/v1/dorm/student/statement",
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
