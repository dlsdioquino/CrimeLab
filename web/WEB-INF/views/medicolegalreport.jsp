<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="toppanel"></div>
<div class="row">
    <div class="col-xs-12">
        <ul class="nav nav-tabs" data-tabs="tabs">
            <li class="active"><a href="#default" data-toggle="tab">Default</a></li>
            <li><a href="#monthly" data-toggle="tab">Monthly</a></li>
        </ul>
        
        <div class="tab-content">
            <div class="tab-pane active" id="default">
                <form id="medicoLegalInfo" name="insertMedicoLegal" action="saveMedicoLegalReport?${_csrf.parameterName}=${_csrf.token}" method="GET" class="form-horizontal">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="division" class="col-xs-2 control-label">Division:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="division" id="division" data-validation="required" value="${report.division}">
                                </div>
                                <label for="reportNo" class="col-xs-2 control-label">Report No:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="reportNo" id="reportNo" data-validation="required" value="${report.reportNo}">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="caseType" class="col-xs-2 control-label">Nature of Case:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="caseType" id="caseType" data-validation="required" value="${report.caseType}">
                                </div>
                                <label for="suspect" class="col-xs-2 control-label">Suspect/s:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="suspect" id="suspect" data-validation="required" value="${report.suspect}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="caseNo" class="col-xs-2 control-label">Case No.:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="caseNo" id="caseNo" data-validation="required" value="${report.caseNo}">
                                </div>
                                <label for="victim" class="col-xs-2 control-label">Victim/s:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="victim" id="victim" data-validation="required"value="${report.victim}">
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
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="requestingParty" class="col-md-3 control-label">Requesting Party:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" name="requestingParty" id="requestingParty" data-validation="required" value="${report.requestingParty}">
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
                                    <textarea name="specimenSubmitted" class="form-control fixedtextarea" rows="12" data-validation="required" value="${report.specimenSubmitted}"></textarea>
                                </div>
                            </div>

                            <div class="div-divider"></div>
                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Purpose of Laboratory Examination:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="purposeOfLabExam" class="form-control fixedtextarea" rows="4" data-validation="required" value="${report.purposeOfLabExam}"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>

                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Findings:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="findings" class="form-control fixedtextarea" rows="4" data-validation="required" value="${report.findings}"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>

                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Conclusion:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="conclusion" class="form-control fixedtextarea" rows="4" data-validation="required" value="${report.conclusion}"></textarea>
                                </div>
                            </div>
                            <div class="div-divider"></div>

                            <div class="form-group">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Remarks:</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea name="remarks" class="form-control fixedtextarea" rows="4" data-validation="required" value="${report.remarks}"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="panel panel-success">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="timeDateCompleted" class="col-md-3 control-label">Time and Date Completed:</label>
                                        <div class="input-group date col-md-6 dtpicker">
                                            <input type="text" class="form-control" name="timeDateCompleted" id="timeDateCompleted" data-validation="required"/>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
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
                                                <div class="col-md-6">
                                                    <div class="row">
                                                        <label class="col-xs-10 col-xs-offset-1">Examined By:</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerName" class="col-xs-4 control-label">Name:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerName" id="examinerName" data-validation="required" value="${report.examinerName}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerRank" class="col-xs-4 control-label">Rank:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerRank" id="examinerRank" data-validation="required" value="${report.examinerRank}"> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="examinerPosition" class="col-xs-4 control-label">Position:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="examinerPosition" id="examinerPosition" data-validation="required" value="${report.examinerPosition}">
                                                        </div>
                                                    </div>
                                                </div>



                                                <div class="col-md-6">
                                                    <div class="row">
                                                        <label class="col-xs-10 col-xs-offset-1">Noted By:</label>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="notedName" class="col-xs-4 control-label">Name:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedName" id="notedName" data-validation="required" value="${report.notedName}">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="notedRank" class="col-xs-4 control-label">Rank:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedRank" id="notedRank" data-validation="required" value="${report.notedRank}">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="notedPosition" class="col-xs-4 control-label">Position:</label>
                                                        <div class="col-xs-8">
                                                            <input type="text" class="form-control" name="notedPosition" id="notedPosition" data-validation="required" value="${report.notedPosition}">
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
                            <input type="button" class="btn btn-primary form-control" value="Generate Report" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="tab-pane" id="monthly">
                <form id="monthly" name="monthly" action="saveMedicoMonthly?${_csrf.parameterName}=${_csrf.token}" method="GET" class="form-horizontal">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="month" class="col-xs-3 control-label">For the Month of:</label>
                                <div class="col-xs-5">
                                    <input type="month" class="form-control" name="month" id="month" data-validation="required">
                                </div>
                            </div>

                        </div>
                    </div>  
                    <div class="form-group">
                        <div class="col-sm-3 col-xs-12">
                            <input type="submit" class="btn btn-primary form-control" value="Generate Report" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


    <script type="text/javascript">
        $(".dtpicker").datetimepicker();
    </script>
    
    <script>
    $.validate({
        modules: 'file',
        validateOnBlur: false, // disable validation when input looses focus
        errorMessagePosition: 'top', // Instead of 'element' which is default
        scrollToTopOnError: true // Set this property to true if you have a long form
    });
</script>
