
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Your User Details</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@ include file="../menu.jsp" %>
<%@ include file="../_details.jsp" %>


    <body>
        <div class="panel-group col-xs-offset-3 col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading"><h4>User Login</h4></div>
                <div class="panel-body">${login}</div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><h4>User Name</h4></div>
                <div class="panel-body">
                <span style="vertical-align:-33%">${firstName} ${lastName}</span>
                <button type="button" class="btn pull-right btn-primary"><span class="glyphicon glyphicon-pencil"></span>  Edit</button>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><h4>User Email</h4></div>
                <div class="panel-body">
                <span style="vertical-align:-33%">${email}</span>
                <button type="button" class="btn pull-right middle btn-primary" data-toggle="modal" data-target="#emailModal"><span class="glyphicon glyphicon-pencil"></span>  Edit</button></div>
                <div class ="clearfix"></div>
                </div>
            </div>
        </div>
    </body>
</html>