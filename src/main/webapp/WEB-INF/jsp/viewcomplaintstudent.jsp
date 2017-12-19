<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dorm Management System: View Complaints</title>

    <!-- Bootstrap Core CSS -->
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- MetisMenu CSS  -->
    <link href="${cp}/css/metisMenu.min.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- Timeline CSS -->
    <link href="${cp}/css/timeline.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- Custom CSS -->
    <link href="${cp}/css/startmin.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- Morris Charts CSS  -->
    <link href="${cp}/css/morris.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- Custom Fonts -->
    <link href="${cp}/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"/>

    <!-- DataTables CSS -->
    <link href="${cp}/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${cp}/css/dataTables/dataTables.responsive.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" type="text/javascript"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js" type="text/javascript"></script>
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
                <h1 class="page-header">View Complaints</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Complaint Lists
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">


                        <div class="dataTable_wrapper">

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>

                                    <th>#</th>
                                    <!--th>Student Name</th-->
                                    <th>Subject</th>
                                    <th>Description</th>
                                    <th>Feedback</th>
                                    <th>Date</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="complaint" items="${complaints}" varStatus="theCount">
                                    <tr class="odd gradeX">
                                        <th scope="row">${theCount.count}</th>
                                        <!--td>${complaint.studentId}</td -->
                                        <td>${complaint.subject}</td>
                                        <td>${complaint.description}</td>
                                        <td>${complaint.feedBack}</td>
                                        <td>${complaint.complainDate}</td>

                                    </tr>


                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${cp}/js/jquery.min.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>

<!-- DataTables JavaScript -->
<script src="${cp}/js/dataTables/jquery.dataTables.min.js"></script>
<script src="${cp}/js/dataTables/dataTables.bootstrap.min.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {

        $('#dataTables-example').DataTable({
            responsive: true
        });


    });


</script>


</body>
</html>
