<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="alert alert-success col-xs-10 col-xs-offset-1" role="alert" id="usersuccess" style="display:none;">
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
    <span class="sr-only">Success:</span>
    User has been successfully updated.
</div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <div class="page-header raised">
            <h3>Site Users <small>View or Edit Users of this Website</small></h3>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <table id="usertable" class="table table-bordered table-responsive">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Division</th>
                    <th>Type</th>
                    <th>Created</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="cur">
                    <c:if test="${cur.user.username != adminin}">
                        <fmt:formatDate value="${cur.user.account_created}" var="formattedDate" 
                        type="date" pattern="MMMM dd yyyy" />

                        <tr>
                            <td class="unameholder${cur.user.enabled == 1 ? '' : ' userdisabled' }">${cur.user.username}</td>
                            <td>${cur.user.firstname} ${cur.user.middle!=null || cur.user.middle!=""? cur.user.middle.concat(" ") : ""}${cur.user.lastname}</td>
                            <td>${cur.user.position}</td>
                            <td>
                                <c:if test="${fn:length(cur.role) eq 1}">
                                    <c:choose>
                                        <c:when test="${cur.role[0] == 'ADMIN'}">
                                            Super User
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'ML'}">
                                            Medico-Legal
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'CHEM'}">
                                            Chemistry
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'PI'}">
                                            Physical ID
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'FIN'}">
                                            Fingerprint
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'FIRE'}">
                                            Firearms
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'POLY'}">
                                            Polygraph
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'DOCU'}">
                                            Document
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'FP'}">
                                            FP/CCI
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'AD'}">
                                            Admin
                                        </c:when>
                                        <c:when test="${cur.role[0] == 'SOCO'}">
                                            SOCO
                                        </c:when>
                                        <c:otherwise>
                                            unknown
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                                <c:if test="${fn:length(cur.role) gt 1}">
                                    Multiple
                                </c:if>
                            </td>
                            <td>${cur.user.registration_type == 0 ? 'Created' : 'Self-Registered'}</td>
                            <td>${formattedDate}</td>
                            <td class="actions">
                                <a href="#" class="togglebut">
                                    <span class="glyphicon glyphicon-${cur.user.enabled == 1 ? 'remove' : 'ok' }" data-toggle="tooltip" data-placement="left" title="${cur.user.enabled == 1 ? 'Deactivate' : 'Activate' }"></span>
                                </a>
                                <a href="#" class="confbut">
                                    <span class="glyphicon glyphicon-cog" data-toggle="tooltip" data-placement="right" title="Edit"></span>
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div id="updateModal" class="modal fade">
    <form action="users/updateuser" name="updateuserform" method="POST" class="form-horizontal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Edit: <span class="unameheader"></span></h4>
                    <input type="hidden" name="username" />
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="upassword" class="col-xs-3 col-xs-offset-1">Password:</label>
                        <div class="col-xs-6">
                            <input type="password" id="upassword" name="password" class="form-control" placeholder="password"/>
                            <span class="help-block"><small>If blank, no change is made</small></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ufname" class="col-xs-3 col-xs-offset-1">First Name:</label>
                        <div class="col-xs-6">
                            <input type="text" id="ufname" name="firstname" class="form-control" placeholder="First Name"/>
                        </div>
                        <span class="help-block col-xs-1" style="display:none;">required</span>
                    </div>
                    <div class="form-group">
                        <label for="umid" class="col-xs-3 col-xs-offset-1">Middle Name/Initial:</label>
                        <div class="col-xs-6">
                            <input type="text" id="umid" name="middle" class="form-control" placeholder="Middle Name/Initial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ulname" class="col-xs-3 col-xs-offset-1">Last Name:</label>
                        <div class="col-xs-6">
                            <input type="text" id="ulname" name="lastname" class="form-control" placeholder="Last Name"/>
                        </div>
                        <span class="help-block col-xs-1" style="display:none;">required</span>
                    </div>
                    <div class="form-group">
                        <label for="upos" class="col-xs-3 col-xs-offset-1">Position:</label>
                        <div class="col-xs-6">
                            <input type="text" id="upos" name="position" class="form-control" placeholder="Position"/>
                        </div>
                        <span class="help-block col-xs-1" style="display:none;">required</span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-10 col-xs-offset-1">
                        <label>
                            Select user role:
                        </label>
                    </div>
                    <div class="checkbox col-xs-offset-2">
                        <label>
                          <input type="checkbox" name="role" value="ADMIN" class="admincheck">
                          Super User
                        </label>
                    </div>
                    <c:forEach items="${divs}" var="divi">
                        <div class="checkbox col-xs-offset-2">
                            <label>
                                <input type="checkbox" name="role" value="${divi.div_id}" class="othercheck">
                                ${divi.div_name}
                            </label>
                        </div>
                    </c:forEach>
                    <div class="col-sm-10 col-sm-offset-1 has-warning">
                        <span class="help-block">If a user is a division head,
                            role would not be deleted even if unselected.
                            But if role is changed to &apos;Super User&apos;,
                            the division head status will be removed.
                        </span>
                    </div>
                    <div class="col-sm-offset-1 has-error">
                        <span class="help-block norole" style="display:none;">Please choose a role for user.</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Update" />
                </div>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<script src="/CrimeLab/js/edituser.js" type="text/javascript" charset="utf-8"></script>

<c:if test="${not empty updated}">
    <c:if test="${updated == 'true'}">
        <script type="text/javascript">
            $('#usersuccess').delay(200).slideDown(500);
        </script>
    </c:if>
</c:if>