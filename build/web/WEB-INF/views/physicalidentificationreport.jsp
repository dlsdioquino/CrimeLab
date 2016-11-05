<c:if test="${not empty msg}">
    <div class="alert alert-success col-sm-6 col-md-4 col-md-offset-4" role="alert" id="alertmsg" style="display:none;">
        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
        <span class="sr-only">Success:</span>
        ${msg}
    </div>
</c:if>
<div class="row">
    <div class="col-xs-12">
        <ul class="nav nav-tabs" data-tabs="tabs">
            <li class="active"><a href="#defPI" data-toggle="tab">Default</a></li>
            <li><a href="#macroEtching" data-toggle="tab">Macro Etching</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="defPI">
                <form id="insertPi" name="piReportInfo" action="savePiReport" method="POST" class="form-horizontal">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-xs-3 col-xs-offset-2">
                                    <input type="text" class="form-control" name="examType" id="examType" data-validation="required">
                                </div>
                                <label for="report" class="col-xs-2 control-label">Report No:</label>
                                <div class="col-xs-3">
                                    <input type="text" class="form-control" name="reportNo" id="reportNo" data-validation="required">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="caseType" class="col-xs-2 control-label">Case Type:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="caseType" id="caseType" data-validation="required">
                                </div>
                                <label for="suspects" class="col-xs-2 control-label">Suspect/s:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="suspects" id="suspects" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="victims" class="col-xs-2 col-md-offset-6 col-xs-offset-1 control-label">Victim/s:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="victims" id="victims" data-validation="required">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="timeDateReceived" class="col-md-3 control-label">Time and Date Received:</label>
                                <div class="input-group date col-md-6 dtpicker">
                                    <input type="text" class="form-control" name="timeDateReceived" id="timeDateReceived" data-validation="required"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="reqPartyUnit" class="col-md-3 control-label">Requesting Party/Unit:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" name="requestingParty" id="requestingParty" data-validation="required"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-6 col-xs-offset-1">Specimen Submitted:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="specimenSubmitted" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Purpose of Laboratory Examination:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="purposeOfLabExam" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Findings:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="findings" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Conclusions:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="conclusions" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Remarks:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="remarks" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="panel panel-success">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="timeDateCompleted" class="col-md-3 control-label">Date and Time Completed:</label>
                                        <div class="input-group date col-md-6 dtpicker">
                                            <input type="text" class="form-control" name="timeDateCompleted" id="timeDateCompleted" data-validation="required"/>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-success">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="col-md-4">
                                                    <div class="row">
                                                        <label class="col-xs-10 col-xs-offset-1">Examined By:</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerName" class="col-xs-4 control-label">Name:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerName" id="examinerName" data-validation="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerRank" class="col-xs-4 control-label">Rank:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerRank" id="examinerRank" data-validation="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerPosition" class="col-xs-4 control-label">Position:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerPosition" id="examinerPosition" data-validation="required">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="row">
                                                        <label class="col-xs-10 col-xs-offset-1">Approved:</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="appName" class="col-xs-4 control-label">Name:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="appName" id="appName" data-validation="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="appRank" class="col-xs-4 control-label">Rank:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="appRank" id="appRank" data-validation="required">
                                                        </div>
                                                    </div>   
                                                    <div class="form-group">
                                                        <label for="appPosition" class="col-xs-4 control-label">Position:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="appPosition" id="appPosition" data-validation="required">
                                                        </div>
                                                    </div> 
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="row">
                                                        <label class="col-xs-10 col-xs-offset-1">Noted By:</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="notedName" class="col-xs-4 control-label">Name:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedName" id="notedName" data-validation="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="notedRank" class="col-xs-4 control-label">Rank:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedRank" id="notedRank" data-validation="required">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="notedPosition" class="col-xs-4 control-label">Position:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedPosition" id="notedPosition" data-validation="required">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-3 col-xs-12">
                            <input type="submit" class="btn btn-primary form-control" value="Generate Report" />
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>	
            <div class="tab-pane" id="macroEtching">
                <form name="insertMe" id="meInfo" action="saveMacroEtchingReport" method="POST" class="form-horizontal">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-offset-xs-12">
                                    <label for="dateCreated" class="col-md-1 col-md-offset-5 col-xs-2 col-xs-offset-1 control-label">Date:</label>
                                    <div class="input-group col-md-5 col-xs-8 dtpicker">
                                        <input type="dtpicker" class="form-control" name="dateCreated" id="dateCreated" data-validation="required">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="rclo" class="control-label col-xs-4">RCLO:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control " name="rclo" id="rclo" data-validation="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label for="rclo" class="control-label col-xs-offset-1">MOTOR VEHICLE SUBMITTED:</label>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="make" class="control-label col-xs-4">MAKE/TYPE: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="make" id="make" data-validation="required">	
                                            </div>                                        
                                        </div>
                                        <div class="form-group">
                                            <label for="color" class="control-label col-xs-4">COLOR: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="color" id="color" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="engineNo" class="control-label col-xs-4">ENGINE NO: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="engineNo" id="engineNo" data-validation="required">	 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="chassisNo" class="control-label col-xs-4">CHASSIS NO: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="chassisNo" id="chassisNo" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="plateNo" class="control-label col-xs-4">PLATE NO: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="plateNo" id="plateNo" data-validation="required">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="owner" class="control-label col-xs-4">OWNER: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="owner" id="owner" data-validation="required">	
                                            </div>                                        
                                        </div>	
                                        <div class="form-group">
                                            <label for="address" class="control-label col-xs-4">ADDRESS: </label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="address" id="address" data-validation="required">
                                            </div>
                                        </div>		        			
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="cold-xs-12">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Examined By:</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="examinerName" class="control-label col-xs-1">Name:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="examinerName" id="examinerName" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="examinerRank" class="col-xs-1 control-label">Rank:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="examinerRank" id="examinerRank" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="examinerPosition" class="col-xs-1 control-label">Position:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="examinerPosition" id="examinerPosition" data-validation="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Approved By:</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="appName" class="col-xs-1 control-label">Name:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="appName" id="appName" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="appRank" class="col-xs-1 control-label">Rank:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="appRank" id="appRank" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="appPosition" class="col-xs-1 control-label">Position:</label>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="text" class="form-control" name="appPosition" id="appPosition" data-validation="required">
                                        </div>
                                    </div>							
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-3 col-xs-12">
                            <input type="submit" class="btn btn-primary form-control" value="Generate Certificate" />
                        </div>
                    </div>  
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>            
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>
<script type="text/javascript">
        $("#creport").attr("class", "active");
</script>
<script>
    $.validate({
        modules: 'file',
        validateOnBlur: false, // disable validation when input looses focus
        errorMessagePosition: 'top', // Instead of 'element' which is default
        scrollToTopOnError: true // Set this property to true if you have a long form
    });
</script>

<script>
    function getUrlVars()
    {
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for (var i = 0; i < hashes.length; i++)
        {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    }
    var url = document.location.toString();
    var temp;//Tab ID
    if (url.match('#')) {
        temp = url.split('#')[1];
    }
    switch (temp) {
        case 'macroEtching':
            $("#insertMe").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] + '"/>');
            break;
        default:
            $("#insertPi").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] + '"/>');
            break;
    }
</script>