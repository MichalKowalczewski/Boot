<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="!isAuthenticated()">
            <li><a href=""><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="/details"><span class="glyphicon glyphicon-user"></span> User Details</a></li>
        </sec:authorize>
        <sec:authorize access="! isAuthenticated()">
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
        </sec:authorize>
      </ul>
    </div>
  </div>
</nav>