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

    <title>Create an account</title>

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

<body>

<div class="container">

    <form:form method="POST" modelAttribute="newUser" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="portalUserLogin">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="portalUserLogin" class="form-control" placeholder="Login"
                            autofocus="true"></form:input>
                <form:errors path="portalUserLogin"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="portalUserPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="portalUserPassword" class="form-control" placeholder="Password"></form:input>
                <form:errors path="portalUserPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="portalUserPasswordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="portalUserPasswordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="portalUserPasswordConfirm"></form:errors>
            </div>
        </spring:bind>

         <spring:bind path="portalUserFirstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                 <form:input type="text" path="portalUserFirstName" class="form-control" placeholder="First Name"></form:input>
                 <form:errors path="portalUserFirstName"></form:errors>
            </div>
         </spring:bind>

         <spring:bind path="portalUserLastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                 <form:input type="text" path="portalUserLastName" class="form-control" placeholder="Last Name"></form:input>
                 <form:errors path="portalUserLastName"></form:errors>
            </div>
         </spring:bind>

         <spring:bind path="portalUserEmail">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                 <form:input type="text" path="portalUserEmail" class="form-control" placeholder="Email"></form:input>
                 <form:errors path="portalUserEmail"></form:errors>
            </div>
         </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
</body>
</html>