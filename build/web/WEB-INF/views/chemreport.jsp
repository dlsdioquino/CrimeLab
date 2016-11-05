<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="toppanel">
    <div class="row">
        <div class="col-xs-12">
            <ul class="nav nav-tabs panel2" data-tabs="tabs" id="tabDisable">
                <li class="active"><a href="#defChem" data-toggle="tab">Default</a></li>
                <li><a href="#drugTest" data-toggle="tab">Drug Test</a></li>
                <li><a href="#chemMonthly" data-toggle="tab">Monthly</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="defChem">
                    <c:forEach items="${reports}" var="report">
                        <form id="insertChemistry" name="chemistryInfo" action="/CrimeLab/Chemistry/saveChemistryReport" method="POST" class="form-horizontal">
                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-xs-3 col-xs-offset-3">
                                        <p><input type="text" class="form-control" name="examType" id="examType" 
                                                  data-validation="required" value="${report.examType}">
                                        </p>
                                    </div>
                                    <label for="reportNo" class="col-xs-2 control-label">Report No:</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="reportNo" id="reportNo" 
                                               data-validation="required" value="${report.reportNo}">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="caseType" class="col-xs-2 control-label">Case Type:</label>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" name="caseType" id="caseType" 
                                               data-validation="required" value="${report.caseType}">
                                    </div>
                                    <label for="suspects" class="col-xs-2 control-label">Suspect/s:</label>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" name="suspects" id="suspects" 
                                               data-validation="required" value="${report.suspects}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="victims" class="col-xs-2 col-md-offset-6 col-xs-offset-1 control-label">Victim/s:</label>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" name="victims" id="victims" 
                                               data-validation="required" value="${report.victims}">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="timeDateReceived" class="col-md-3 control-label">Time and Date Received:</label>
                                    <div class="input-group date col-md-6 dtpicker">
                                        <input type="text" class="form-control" name="timeDateReceived" id="timeDateReceived" 
                                               data-validation="required"
                                               data-validation-error-msg="You have not entered a valid date."
                                               value="<fmt:formatDate value="${report.timeDateReceived}" pattern="MM/dd/yyyy h:ma" />"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="reqPartyUnit" class="col-md-3 control-label">Requesting Party/Unit:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="reqPartyUnit" id="reqPartyUnit" data-validation="required" value="${report.requestingParty}">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-xs-6 col-xs-offset-1">Specimen Submitted:</label>
                                        <label class="col-xs-4 col-xs-offset-1">Description of Evidence:</label>
                                    </div>
                                    <div class="col-xs-7">
                                        <textarea name="specimenSubmitted" id="specimenSubmitted" class="form-control fixedtextarea" rows="12" data-validation="required"></textarea>
                                    </div>
                                    <div class="col-xs-5">
                                        <div class="radio col-xs-offset-1">
                                            <label>
                                                <input type="radio" name="descriptionOfEvidence" value="Marijuana" <c:if test="${report.descriptionOfEvidence eq 'Marijuana'}">checked</c:if>>
                                                Marijuana
                                            </label>
                                        </div>
                                        <div class="radio col-xs-offset-1">
                                            <label>
                                                <input type="radio" name="descriptionOfEvidence"value="White Crystalline" <c:if test="${report.descriptionOfEvidence eq 'White Crystalline'}">checked</c:if>>
                                                White Crystalline
                                            </label>
                                        </div>
                                        <div class="radio col-xs-offset-1">
                                            <label>
                                                <input type="radio" name="descriptionOfEvidence" value="Paraphernalia" <c:if test="${report.descriptionOfEvidence eq 'Paraphernalia'}">checked</c:if>>
                                                Paraphernalia
                                            </label>
                                        </div>
                                        <div class="radio col-xs-offset-1">
                                            <label>
                                                <input type="radio" name="descriptionOfEvidence" value="Others" <c:if test="${report.descriptionOfEvidence ne 'Paraphernalia' && report.descriptionOfEvidence ne 'Marijuana' && report.descriptionOfEvidence ne 'White Crystalline'}">checked</c:if>>
                                                Others
                                            </label>
                                        </div>
                                        <div class="col-xs-offset-1 col-md-10">
                                            <label>
                                                <input type="text" class="form-control" name="others_descriptionOfEvidence" readonly="readonly" disabled="disabled" data-validation="required"></label>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-6">Weight (in grams):</label>
                                            <div class="col-md-3">
                                                <input type="text" name="specimenWeight" class="form-control" data-validation="required" value="${report.specimenWeight}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
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
                                        <textarea name="remarks" class="form-control fixedtextarea" rows="4" data-validation="required" ></textarea>
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

                                <div class="panel panel-success">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <div class="row">
                                                <label class="col-xs-8 col-xs-offset-1">Subscribed and sworn to:</label>
                                            </div>
                                            <div class="col-xs-8">
                                                <textarea name="subscribed" class="form-control fixedtextarea" rows="6" data-validation="required"></textarea>
                                            </div>
                                            <div class="col-xs-4">
                                                <div class="form-group">
                                                    <label for="subscribedName" class="col-sm-4 control-label">Name:</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="subscribedName" id="subscribedName" data-validation="required">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="subscribedRank" class="col-sm-4 control-label">Rank:</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="subscribedRank" id="subscribedRank" data-validation="required">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="subscribedPosition" class="col-sm-4 control-label">Position:</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control" name="subscribedPosition" id="subscribedPosition" data-validation="required">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="panel panel-success">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label for="typeOfOperation" class="col-sm-3 control-label">Type of Operation:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name="typeOfOperation" id="typeOfOperation" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="placeOfOperation" class="col-sm-3 control-label">Place of Operation:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name="placeOfOperation" id="placeOfOperation" data-validation="required">
                                            </div>
                                            <label for="custody" class="col-sm-2 control-label">Custody:</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" name="custody" id="custody" data-validation="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-3 col-xs-12">
                                <input type="submit" class="btn btn-primary form-control" value="Generate Report" data-validation="required"/>
                                <!--input type="button" value="Create Report" id="show_button" onclick="this.style.visibility = 'hidden';
                                        disable()"/>
                                <div id="newButtons" class="form-group">
                                    
                                </div-->
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                    </c:forEach>
                </div>

                <div class="tab-pane" id="drugTest">                
                    <form id="insertDrugTest" name="drugTestInfo" method="POST" action="saveDrugTestReport" class="form-horizontal">                    
                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="name" class="col-xs-4 control-label">Name:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="name" id="name" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="fadtNo" class="col-xs-4 control-label">FADT No:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="fadtNo" id="fadtNo" data-validation="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="address" class="col-xs-4 control-label">Address:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="address" id="address" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="sbrNo" class="col-xs-4 control-label">SBR No:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="sbrNo" id="sbrNo" data-validation="required">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="age" class="col-xs-4 control-label">Age:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" name="age" id="age" data-validation="required">
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="timeDate" class="col-xs-4 control-label">Time and Date:</label>
                                        <div class="input-group date col-xs-8 dtpicker">
                                            <input type="text" class="form-control" name="timeDate" id="timeDate" data-validation="required" data-validation-error-msg="You have not entered a valid date."/>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label class="col-xs-4 control-label">Sex:</label>
                                        <div class="col-xs-8">
                                            <div class="col-xs-6">
                                                <div class="radio col-xs-offset-1">
                                                    <label>
                                                        <input type="radio" name="sex" value="Male" selected>
                                                        Male
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="radio col-xs-offset-1">
                                                    <label>
                                                        <input type="radio" name="sex" value="Female">
                                                        Female
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="row">
                                    <label class="col-xs-10 col-xs-offset-1">Purpose</label>
                                </div>
                                <div class="form-group" data-validation="required">
                                    <div class="checkbox col-xs-offset-1">
                                        <label>
                                            <input type="checkbox" name="purpose" value="Firearm License" data-validation="required">
                                            Firearm License
                                        </label>
                                    </div>
                                    <div class="checkbox col-xs-offset-1">
                                        <label>
                                            <input type="checkbox" name="purpose" value="Permit to Carry Firearms Outside Residence (PTCFOR)" data-validation="required">
                                            Permit to Carry Firearms Outside Residence (PTCFOR)
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-xs-10 col-xs-offset-1">Specimen Submitted:</label>
                                    </div>
                                    <div class="col-xs-12">
                                        <textarea name="specimenSubmitted" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                    </div>
                                </div>
                                <div class="div-divider"></div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-xs-10 col-xs-offset-1">Purpose of Examination:</label>
                                    </div>
                                    <div class="col-xs-12">
                                        <textarea name="purposeOfExamination" class="form-control fixedtextarea" rows="4" data-validation="required"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-xs-10 col-xs-offset-1">Results:</label>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="col-xs-6">
                                            <label class="col-xs-12 control-label">Methamphetamine:</label>
                                        </div>
                                        <div class="col-md-6">
                                            <select class="form-control" name="methamphetamine" data-validation="required">
                                                <option value="" selected>Please Select...</option>
                                                <option value="POSITIVE">Positive</option>
                                                <option value="NEGATIVE">Negative</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="col-xs-6">
                                            <label class="col-xs-12 control-label">THC:</label>
                                        </div>
                                        <div class="col-md-6">
                                            <select class="form-control" name="thc" data-validation="required">
                                                <option value="" selected>Please Select...</option>
                                                <option value="POSITIVE">Positive</option>
                                                <option value="NEGATIVE">Negative</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-primary">
                            <div class="panel-body">
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
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label class="col-xs-10 col-xs-offset-1">Examined By:</label>
                                        </div>
                                        <div class="col-xs-6">
                                            <label class="col-xs-10 col-xs-offset-1">Approved By:</label>
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="form-group">
                                            <label for="examinerName2" class="col-xs-4 control-label">Name:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="examinerName" id="examinerName2" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="examinerRank2" class="col-xs-4 control-label">Rank:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="examinerRank" id="examinerRank2" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="examinerPosition2" class="col-xs-4 control-label">Position:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="examinerPosition" id="examinerPosition2" data-validation="required">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="form-group">
                                            <label for="appName2" class="col-xs-4 control-label">Name:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="appName" id="appName2" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="appRank2" class="col-xs-4 control-label">Rank:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="appRank" id="appRank2" data-validation="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="appPosition2" class="col-xs-4 control-label">Position:</label>
                                            <div class="col-xs-8">
                                                <input type="text" class="form-control" name="appPosition" id="appPosition2" data-validation="required">
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

                <div class="tab-pane" id="chemMonthly">
                    <form id="chemMonthly" name="chemMonthly" action="drugMonthlyReport" method="POST" class="form-horizontal">
                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="monthly" class=" col-md-3">For the month of: </label>
                                    <div class="input-group month  col-xs-offset-1">
                                        <input type="month" name="month" class="form-control" data-validation="required">
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

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>

<script>
    function save() {
        $.ajax({
            url: "saveChemistryReport", //target
            type: "POST",
            data: $("#insertChemistry").serialize(), //form data
            success: function (data) {
                if (data) {
                    console.log(data); //chrome only
                }
            },
            error: function (data) {
                alert(data);
            }

        });
    }

    $("input[name='descriptionOfEvidence']").click(function () {
        if ($(this).val() === 'Others') {
            $("input[name='others_descriptionOfEvidence']").removeAttr("readonly");
            $("input[name='others_descriptionOfEvidence']").removeAttr("disabled");
        } else {
            $("input[name='others_descriptionOfEvidence']").attr("readonly", "readonly");
            $("input[name='others_descriptionOfEvidence']").attr("disabled", "disabled");
            $("input[name='others_descriptionOfEvidence']").val("");
        }
    });
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
        default:
            $("#insertChemistry").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] + '"/>');
            break;
        case 'drugTest':
            $("#insertDrugTest").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] + '"/>');
            break;
    }
</script>

<script>
    function disable() {
        $(':input').attr('readonly', 'true');
        $("li").addClass("disabled");
        $('#tabDisable li.disabled a').removeAttr('data-toggle');
        
        var $save = $('<button/>', {
          type: 'button',
          'class': 'btn btn-danger ',
          id: 'edit',
          text: 'Edit'
        });
        
        var $print = $('<button/>', {
          type: 'button',
          'class': 'btn btn-success',
          id: 'print',
          text: 'Download'
        });        

        $save.appendTo('#newButtons');
        $print.appendTo('#newButtons');
    }
    
    $('#newButtons').on("click","#edit", function(){
       $(':input').removeAttr("readonly"); 
    });  
</script>

<c:if test="${not empty reports}">
    <script>
       $(':input').attr('readonly', 'true');       
    </script>
</c:if>