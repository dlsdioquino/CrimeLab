<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <div class="page-header raised">
            <h3>Announcements <small> Add Home Page Contents</small></h3>
        </div>
    </div>
</div>

<div class="row">
    <div class="hidden-xs col-sm-2 col-sm-offset-1 minifeedbar">
        <div class="col-sm-12 minifeed">
            <c:choose>
                <c:when test="${empty contents}">
                    <div class="row">
                        <div class="col-sm-12 feeditem">
                            No recent announcements.
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${contents}" var="conts">
                        <div class="row postitem" id="post${conts.content_id}">
                            <div class="col-sm-12 feeditem">
                                <span class="${conts.status == 1 ?  'activepost' : 'inactivepost' }">${conts.title}</span><br/>
                                <fmt:formatDate value="${conts.date_created}" var="formattedDate" 
                                    type="date" pattern="MM/dd/yy h:m a" />
                                <span class="help-block">${formattedDate}</span>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="col-xs-10 col-sm-8 col-xs-offset-1 col-sm-offset-0">
        <div class="row">
            <div class="col-xs-12">
                <ul id="tabsup" class="nav nav-tabs" data-tabs="tabs">
                    <li class="active"><a href="#postup" data-toggle="tab">Post</a></li>
                    <li><a href="#photoup" data-toggle="tab">Photo</a></li>
                </ul>
                <div id="my-tab-content" class="tab-content">
                    <div class="tab-pane active" id="postup">
                        <form method="POST" class="form-horizontal" role="form" name="postform" action="content/savepost">
                            <div class="row">
                                <div class="form-group">
                                    <label for="titlenew" class="col-xs-1 control-label">Title</label>
                                    <div class="col-xs-11">
                                        <input type="text" class="form-control" name="title" id="titlenew" placeholder="Post Title" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-11 col-xs-offset-1">
                                    <div class="form-group">
                                        <textarea class="form-control" rows="10" name="content" id="postcontent"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-offset-1 col-sm-3">
                                    <input type="submit" class="btn btn-primary form-control" value="New" />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane" id="photoup">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/CrimeLab/js/content.js" type="text/javascript"></script>