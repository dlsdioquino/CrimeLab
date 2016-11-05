<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-xs-12">

        <form name="insertPolygraph" id="polygraphInfo" action="savePolygraphReport?${_csrf.parameterName}=${_csrf.token}" method="POST" class="form-horizontal" enctype="multipart/form-data">

            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="panel panel-success">
                        <div class="panel-body">
                            <div class="form-group">

                                <label for="subjectNo" class="col-xs-3 control-label"> Polygraph Subject No.:</label>
                                <div class="col-md-3">
                                    <input type="text" class="form-control" name="subjectNo" id="subjectNo">
                                </div>
                            </div>
                        </div>

                    </div>
                    <label for="victim"  control-label>Personal Information:</label>
                    <div class="form-group">
                        <label for="name" class="col-xs-2 control-label">Name:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <label for="img" class="col-xs-2 control-label">Photo:</label>
                        <div class="col-md-4">
                            <input type="file" class="form-control" name="img" id="img">
                        </div> 
                    </div>
                    <div class="form-group">
                        <label for="gender" class="col-xs-2 control-label">Gender:</label>
                        <div class="col-md-4">
                            <div class="col-md-6">
                                <div class="radio col-md-offset-1">
                                    <label>
                                        <input type="radio" name="gender" value="Male" checked="checked" />                                                  
                                        Male
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="radio col-md-offset-1">
                                    <label>
                                        <input type="radio" name="gender" value="Female">
                                        Female
                                    </label>
                                </div>
                            </div>
                        </div>
                        <label for="age" class="col-xs-2 control-label">Age:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="age" id="age">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="civilStatus" class="col-xs-2 control-label">Civil Status:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="civilStatus" id="civilStatus">
                        </div> 
                        <label for="birthdate" class="col-xs-2 control-label">Date of Birth:</label>
                        <div class="col-md-4">
                            <input type="date" class="form-control" name="birthdate" id="birthdate" />

                        </div>

                    </div> 

                    <div class="form-group"> 
                        <label for="idPresented" class="col-xs-2 control-label">ID Presented:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="idPresented" id="idPresented">
                        </div>
                        <label for="address" class="col-xs-2 control-label">Address: </label>
                        <div class="col-md-4">
                            <textarea name="address" class="form-control fixedtextarea" rows="3"></textarea>
                        </div>


                    </div>

                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-body">

                    <label for="victim"  control-label>Exam Information:</label>
                    <div class="form-group">
                        <label for="caseNo" class="col-xs-2 control-label">Case Number:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="caseNo" id="caseNo">
                        </div>
                        <label for="requestingParty" class="col-xs-2 control-label"> Requesting Party:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="requestingParty" id="requestingParty">
                        </div> 
                    </div>
                    <div class="form-group">
                        <label for="natureOfCase" class="col-xs-2 control-label">Nature of Case:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="natureOfCase" id="natureOfCase">
                        </div>
                        <label for="timeDateReceived" class="col-xs-2 control-label">Time / Date Received:</label>
                        <div class="input-group date col-md-4 dtpicker">
                            <input type="text" class="form-control" name="timeDateReceived" id="timeDateReceived" />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="examLocation" class="col-xs-2 control-label">Exam Location:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="examLocation" id="examLocation">
                        </div>
                        <label for="examDate" class="col-xs-2 control-label">Exam Date:</label>
                        <div class="col-md-4">
                            <input type="date" class="form-control" name="examDate" id="examDate" />
                        </div>
                    </div>





                </div>
            </div>

            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-6 col-xs-offset-1">Section 1: Purpose of Examination:</label>

                        </div>
                        <div class="col-xs-12">
                            <textarea name="purpose" class="form-control fixedtextarea" rows="5"></textarea>
                        </div>
                    </div>

                    <div class="div-divider"></div>
                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-10 col-xs-offset-1">Section 2: Pre-Test Interview:</label>
                        </div>
                        <div class="col-xs-12">
                            <textarea name="preTest" class="form-control fixedtextarea" rows="5"></textarea>
                        </div>
                    </div>
                    <div class="div-divider"></div>

                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-10 col-xs-offset-1">Section 3: In-Test Phase:</label>
                        </div>
                        <div class="col-xs-12">
                            <textarea name="inTest" class="form-control fixedtextarea" rows="5"></textarea>
                        </div>
                    </div>
                    <div class="div-divider"></div>

                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-10 col-xs-offset-1">Section 4: Result:</label>
                        </div>
                        <div class="col-xs-12">
                            <textarea name="result" class="form-control fixedtextarea" rows="5"></textarea>
                        </div>
                    </div>
                    <div class="div-divider"></div>

                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-10 col-xs-offset-1"> Section 5: Post-Test Interview:</label>
                        </div>
                        <div class="col-xs-12">
                            <textarea name="postTest" class="form-control fixedtextarea" rows="5"></textarea>
                        </div>
                    </div>
                    <div class="div-divider"></div>

                    <div class="form-group">
                        <div class="row">
                            <label class="col-xs-10 col-xs-offset-1"> Remarks:</label>
                        </div>
                        <div class="col-xs-12">
                            <textarea name="remarks" class="form-control fixedtextarea" rows="5"></textarea>
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
                                    <input type="text" class="form-control" name="timeDateCompleted" id="timeDateCompleted" />
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
                                                    <input type="text" class="form-control" name="examinerName" id="examinerName">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="examinerRank" class="col-xs-4 control-label">Rank:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="examinerRank" id="examinerRank">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="examinerPosition" class="col-xs-4 control-label">Position:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="examinerPosition" id="examinerPosition">
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
                                                    <input type="text" class="form-control" name="notedName" id="notedName">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="notedRank" class="col-xs-4 control-label">Rank:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="notedRank" id="notedRank">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="notedPosition" class="col-xs-4 control-label">Position:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="notedPosition" id="notedPosition">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-xs-10 col-xs-offset-1">Approved By:</label>
                                            </div>

                                            <div class="form-group">
                                                <label for="approvedName" class="col-xs-4 control-label">Name:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="approvedName" id="approvedName">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="approvedRank" class="col-xs-4 control-label">Rank:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="approvedRank" id="approvedRank">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="approvedPosition" class="col-xs-4 control-label">Position:</label>
                                                <div class="col-xs-8">
                                                    <input type="text" class="form-control" name="approvedPosition" id="approvedPosition">
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

            
            <!--ETO YUN-->
           


            <div class="form-group">
                <div class="col-sm-3 col-xs-12">
                    <input type="submit" class="btn btn-primary form-control" value="Generate Report" />
                </div>
            </div>

        </form>

    </div>
</div>

<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>