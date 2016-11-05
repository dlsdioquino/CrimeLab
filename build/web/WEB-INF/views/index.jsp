<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                  <li><a href="/CrimeLab/login"><button class="btn btn-default">Login</button></a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</sec:authorize>

<div class="row">
    <div class="col-xs-12">
        <img src="/CrimeLab/img/headerimg.jpg" alt="header" class="headerimg"/>
    </div>
</div>
<div class="row indexcontent">
    <div class="col-md-4">
        <div class="column-header">
            <h4>About</h4>
        </div>
        <p>${siteabout}</p>
    </div>
    <div class="col-sm-4">
        <div class="column-header">
            <h4>CL &ndash; Cordillera</h4>
        </div>
        <p>${sitehistory}</p>
    </div>
    <div class="col-sm-4">
        <div class="column-header">
            <h4>Divisions</h4>
        </div>
        <p>${sitedivisions}</p>
    </div>
</div>