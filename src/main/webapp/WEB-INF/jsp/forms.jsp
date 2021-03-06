
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

    <title>Dorm Management System: Room Application</title>

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
            <a class="navbar-brand" href="{cp}/dashboard">Dorm Management System</a>
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
                        <a href="${cp}//dashboardStudent"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
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
                        <a href="${cp}/logout"><i class="fa fa-dashboard fa-fw"></i> Logout</a>
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
                <h1 class="page-header">Room Application form</h1>
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

                                <!--div>
                                    <c:if test="${not empty emr}">
                                        <c:choose>
                                            <c:when test="${fn:containsIgnoreCase(emr,'Success')}">
                                                <font color="green" style='vertical-align: auto'>${emr}</font>
                                            </c:when>
                                            <c:otherwise>
                                                <font color="red" style='vertical-align: auto'>${emr}</font>
                                            </c:otherwise>

                                        </c:choose>

                                    </c:if>
                                </div -->
                                <form:form role="form" id="formRoomApplication">
                                    <div class="form-group">
                                        <label>Building</label>
                                        <form:select class="form-control" id="buildingId" path="buildingNo">
                                            <form:options items="${buildings}" itemValue="value" itemLabel="label"/>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label>Room</label>
                                        <form:select class="form-control" id="roomNo" path="roomNo">
                                            <form:options items="${rooms}" itemValue="value" itemLabel="label"/>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label>Arrival Date</label>
                                        <input class="form-control" placeholder="YYYY-MM-DD" id="txtArivalDate">
                                    </div>

                                    <div class="form-group">
                                        <button type="button" class="btn btn-outline btn-primary" id="btnApply">Submit
                                            Application
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

        $(document).on("click", "#btnApply", function (e) {
            btnOperation();
        });


    });


    function btnOperation() {

        var jsonRequest = {};

        jsonRequest["roomNo"] = $("#roomNo").val();
        jsonRequest["buildingNo"] = $("#buildingId").val();
        jsonRequest["arrivingDate"] = $("#txtArivalDate").val();

         var userJson = JSON.parse(localStorage.getItem("data"));
         console.log(userJson);

        var param = JSON.stringify(jsonRequest);

        $.ajax({
                url: "${cp}/api/v1/dorm/student/room/apply",
                type: "POST",
                dataType: "json",
                beforeSend: function (xhr) {
                     xhr.setRequestHeader("X-Auth-Token", userJson.accessToken);
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
