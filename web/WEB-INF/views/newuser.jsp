<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<div class="alert alert-success col-xs-10 col-xs-offset-1" role="alert" id="usersuccess" style="display:none;">
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
    <span class="sr-only">Success:</span>
    User has been successfully  created.
</div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <div class="page-header raised">
            <h3>Create New User <small>Account Creation by Site Admin</small></h3>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <form class="form-horizontal" role="form" action="newuser/adduser" name="newuserform" method="POST">
            
            <div class="row">
                <div class="col-sm-8">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-danger">
                                <div class="panel-heading">User Details</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="firstnamenew" class="col-sm-3 col-sm-offset-1 control-label">First Name</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="firstname" id="firstnamenew" placeholder="First Name">
                                        </div>
                                        <span class="help-block col-sm-1" style="display:none;">required</span>
                                    </div>
                                    <div class="form-group">
                                        <label for="middlenew" class="col-sm-4 control-label">Middle Name/Initial</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" name="middle" id="middlenew" placeholder="Middle Name/Initial">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="lastnamenew" class="col-sm-3 col-sm-offset-1 control-label">Last Name</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="lastname" id="lastnamenew" placeholder="Last Name">
                                        </div>
                                        <span class="help-block col-sm-1" style="display:none;">required</span>
                                    </div>

                                    <div class="form-group">
                                        <label for="positionnew" class="col-sm-2 col-sm-offset-2 control-label">Position</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="position" id="positionnew" placeholder="Position">
                                        </div>
                                        <span class="help-block col-sm-1" style="display:none;">required</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-danger">
                                <div class="panel-heading">Login Credentials</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="unamenew" class="col-sm-2 col-sm-offset-2 control-label">Username</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="username" id="unamenew" placeholder="Username">
                                            <span class="help-block" style="display:none;">&nbsp;&nbsp;Username already taken.</span>
                                        </div>
                                        <span class="help-block col-sm-1" style="display:none;">required</span>
                                    </div>

                                    <div class="form-group">
                                        <label for="passwordnew" class="col-sm-2 col-sm-offset-2 control-label">Password</label>
                                        <div class="col-sm-6">
                                            <input type="password" class="form-control" name="password" id="passwordnew" placeholder="Password">
                                        </div>
                                        <span class="help-block col-sm-1" style="display:none;">required</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-4">
                    <div class="panel panel-danger">
                        <div class="panel-heading">Division / Role</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <p class="help-block">
                                        Select user role:
                                    </p>
                                </div>
                                <div class="radio col-xs-offset-1">
                                    <label>
                                      <input type="checkbox" name="role" value="ADMIN" class="admincheck">
                                      Super User
                                    </label>
                                </div>
                                <c:forEach items="${divs}" var="divi">
                                    <div class="radio col-xs-offset-1">
                                        <label>
                                            <input type="checkbox" name="role" value="${divi.div_id}" class="othercheck">
                                            ${divi.div_name}
                                        </label>
                                    </div>
                                </c:forEach>
                                <div class="col-xs-offset-1 has-error">
                                    <span class="help-block norole" style="display:none;">Please choose a role for user.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-2 col-sm-offset-7 col-xs-4 col-xs-offset-2">
                    <input type="submit" class="btn btn-danger form-control" value="Create User" />
                </div>
                <div class="col-sm-2 col-xs-4">
                    <a href="/CrimeLab/" class="btn btn-default form-control" target="_self">Cancel</a>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</div>

<script src="/CrimeLab/js/newuser.js" type="text/javascript"></script>
<c:if test="${not empty saved}">
    <c:if test="${saved == 'true'}">
        <script type="text/javascript">
            $('#usersuccess').delay(200).slideDown(500);
        </script>
    </c:if>
</c:if>