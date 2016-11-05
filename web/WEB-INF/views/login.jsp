<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<div class="row">
    <c:if test="${not empty error}">
        <div class="alert alert-danger col-sm-6 col-md-4 col-md-offset-4" role="alert" id="alertmsg" style="display:none;">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            ${error}
        </div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-success col-sm-6 col-md-4 col-md-offset-4" role="alert" id="alertmsg" style="display:none;">
            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
            <span class="sr-only">Success:</span>
            ${msg}
        </div>
    </c:if>
    <div class="col-sm-6 col-md-4 col-md-offset-4">
        <div class="panel panel-info">
            <div class="panel-heading">
                <strong> Sign in </strong>
            </div>
            <div class="panel-body">
                <form role="form" action="/CrimeLab/login" method="POST">
                    <fieldset>
                        <div class="row">
                            <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-user"></i>
                                        </span> 
                                        <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="glyphicon glyphicon-lock"></i>
                                        </span>
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                <a href="#">
                                    <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
                                </a>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </div>
</div>
                
<c:if test="${not empty msg || not empty error}">
    <script type="text/javascript">
        $('#alertmsg').delay(200).slideDown(500);
    </script>
</c:if>