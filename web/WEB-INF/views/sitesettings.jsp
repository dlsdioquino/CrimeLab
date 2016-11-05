<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <div class="page-header raised">
            <h3>Site Settings <small>Manage Site Preferences (Click on a heading to expand)</small></h3>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="panel-group" id="accordion">
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Home Page Display</a>
                    </h4>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p class="help-block">
                                Edit the contents that will display on the site home page. This portion
                                allows editing of the About, CL - Cordillera, and Divisions Section of
                                the web site's home page.
                            </p>
                        </div>
                    </div>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="panel-group" id="accordion2">
                                    
                                    <div class="panel panel-danger">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOneOne">About</a>
                                            </h4>
                                        </div>
                                        <div id="collapseOneOne" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                <form method="POST" action="/CrimeLab/siteadmin/site/savesetting" class="settingform">
                                                    <div class="form-group">
                                                        <p class="help-block">
                                                            Write a short description of what the organization is about.
                                                            It will be displayed on the web site&apos;s home page on the &quot;About&quot; section
                                                        </p>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <textarea class="form-control" name="value" rows="7"><c:if test="${not empty siteabout}">${siteabout}</c:if></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            &nbsp;
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-xs-10 col-xs-offset-1 col-md-2 col-md-offset-5">
                                                            <input type="submit" class="btn btn-danger form-control" value="Save" />
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="setting" value="about" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                                        
                                    <div class="panel panel-danger">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOneTwo">Crime Lab History</a>
                                            </h4>
                                        </div>
                                        <div id="collapseOneTwo" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <form method="POST" action="/CrimeLab/siteadmin/site/savesetting" class="settingform">
                                                    <div class="form-group">
                                                        <p class="help-block">
                                                            Write a short history of the Crime Laboratory.
                                                            It will be displayed on the web site&apos;s home page on the &quot;CL &ndash; Cordillera&quot; section
                                                        </p>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <textarea class="form-control" name="value" rows="7"><c:if test="${not empty sitehistory}">${sitehistory}</c:if></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            &nbsp;
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-xs-10 col-xs-offset-1 col-md-2 col-md-offset-5">
                                                            <input type="submit" class="btn btn-danger form-control" value="Save" />
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="setting" value="history" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                                    
                                    <div class="panel panel-danger">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOneThree">Divisions</a>
                                            </h4>
                                        </div>
                                        <div id="collapseOneThree" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <form method="POST" action="/CrimeLab/siteadmin/site/savesetting" class="settingform">
                                                    <div class="form-group">
                                                        <p class="help-block">
                                                            List the divisions of Crime Laboratory Cordillera
                                                            It will be displayed on the web site&apos;s home page on the &quot;Divisions&quot; section
                                                        </p>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <textarea class="form-control" name="value" rows="7"><c:if test="${not empty sitedivisions}">${sitedivisions}</c:if></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            &nbsp;
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-xs-10 col-xs-offset-1 col-md-2 col-md-offset-5">
                                                            <input type="submit" class="btn btn-danger form-control" value="Save" />
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="setting" value="divisions" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                                                
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">File Upload Paths</a>
                    </h4>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p class="help-block">
                                Specify the path where files will be stored in the server.
                            </p>
                        </div>
                    </div>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">
                        
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</div>

<script src="/CrimeLab/js/sitesettings.js" type="text/javascript"></script>