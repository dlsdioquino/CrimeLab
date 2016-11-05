<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <div id="adminheader">
        <a href="/CrimeLab/"><img src="/CrimeLab/img/header.png" alt="header"/></a>
    </div>
</sec:authorize>

<sec:authorize access="isAuthenticated() && !hasRole('ROLE_ADMIN')">
    <div class="row">
        <nav class="navbar col-xs-12" role="navigation" id="grad1">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="top-navbar-1">
                <ul class="nav navbar-nav navhead">
                    <li class="col-sm-offset-5">
                        <a href="/CrimeLab/">
                            <img src="/CrimeLab/img/title.png" id="headerimg">
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right text-center">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
                            <i class="fa fa-search fa-2x"></i><br>Search <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-left" role="menu">
                            <li>
                                <form class="form-horizontal" style="padding-left:10px; padding-right:10px;">
                                    <input type="text" class="form-control" placeholder="Search" id="search"><br>
                                    <button type="submit" class="btn btn-success"><span class="fa fa-search"></span> Search</button>
                                </form>
                            </li>
                        </ul>
                    </li>
                    <li id="creport">
                        <a href="#"  id="menu"><i class="fa fa-pencil-square fa-2x"></i><br>Reports</a>
                    </li>
                    <li id="fmgmt">
                        <a href="#"><i class="fa fa-folder fa-2x"></i><br>File Management</a>
                    </li>
                    <li id="photog">
                        <a href="#"><i class="fa fa-file-image-o fa-2x"></i><br>Photo Gallery</a>
                    </li>
                    <li id="assignT">
                        <a href="#"><i class="fa fa-wrench fa-2x"></i><br>Assign Task</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
                            <i class="fa fa-user fa-2x"></i><br><sec:authentication property="principal.username" /> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                            <li id="notif">
                                <a href="#">
                                    Tasks
                                    <span class="badge" id="notifbadge">0</span>
                                </a>
                            </li>                          
                            <li id="acct">

                                <a href="#">Account Settings </a>
                            </li>
                            <li>
                                <a href="#" id="lgbtn">Logout</a>
                            </li>
                            <li>
                                <c:url var="logoutUrl" value="/logout"/>
                                <form action="${logoutUrl}" method="POST" name="logoutForm">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <div class="row" id="sitelogo">
        <div class="col-sm-4 col-sm-offset-4" style="text-align:center;">
            <a href="/CrimeLab/">
                <img src="/CrimeLab/img/title.png">
            </a>
        </div>
    </div>
</sec:authorize>
