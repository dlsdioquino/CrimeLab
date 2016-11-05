<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <nav class="navbar navbar-custom">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <span class="navbar-brand">Site Administration</span>
            </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href="/CrimeLab/">Home</a></li>
                <li><a href="/CrimeLab/siteadmin/content">Announcements</a></li>
                <li><a href="/CrimeLab/siteadmin/site">Site Settings</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User Management <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="/CrimeLab/siteadmin/users">View/Edit Users</a></li>
                    <li><a href="/CrimeLab/siteadmin/newuser">Add New User</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Assign Division Head</a></li>
                  </ul>
                </li>
                <li><a href="/CrimeLab/tasks">Tasks</a></li>
                <li><a href="/CrimeLab/siteadmin/logs">Activity Log</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                  <li>
                    <c:url var="logoutUrl" value="/logout"/>
                    <form class="form-inline" action="${logoutUrl}" method="POST" name="logoutForm">
                        <input class="btn navbar-btn" name="logout_btn" type="submit" value="Log out"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                  </li>
              </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</sec:authorize>