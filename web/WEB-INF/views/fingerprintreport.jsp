<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toppanel"></div>
<div class="row">
    <div class="col-xs-12">
        <ul class="nav nav-tabs" data-tabs="tabs">
            <li class="active"><a href="#civil" data-toggle="tab">Civilian</a></li>
            <li><a href="#crim" data-toggle="tab">Criminal</a></li>
            <li><a href="#monthly" data-toggle="tab">Monthly</a></li>
        </ul>
        <div class="tab-content">

            <div class="tab-pane active" id="civil">
                <form id="civilianInfo" name="insertCivilian" action="saveCivilianReport" method="GET" class="form-horizontal">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="reportNo" class="col-xs-2 control-label"> Report No.: </label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="reportNo" id="reportNo" data-validation="required">
                                </div>
                                <label for="stationTaken" class="col-xs-2 control-label"> Reg/Prov. & Station Taken: </label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="stationTaken" id="stationTaken" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="dateTaken" class="col-xs-2 control-label"> Time and Date Taken: </label>
                                <div class="input-group date col-md-8 dtpicker">
                                    <input type="text" class="form-control" name="dateTaken" id="dateTaken" data-validation="required">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="region" class="col-xs-2 control-label">Region: </label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="region" id="region" data-validation="required">
                                </div>
                                <label for="civilStatus" class="col-xs-2 control-label">Civil Status: </label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="civilStatus" id="civilStatus" data-validation="required">
                                </div>
                                <label for="voterNo" class="col-xs-2 control-label">Voter's ID No. : </label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="voterNo" id="voterNo" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="race" class="col-xs-2 control-label">Race: </label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="race" id="race" data-validation="required">
                                </div>
                                <label for="height" class="col-xs-2 control-label">Height:</label>
                                <div class="col-md-2">
                                    <input type="number" class="form-control" name="height" id="height" data-validation="required">
                                </div>
                                <label for="weight" class="col-xs-2 control-label">Weight:</label>
                                <div class="col-md-2">
                                    <input type="number" class="form-control" name="weight" id="weight" data-validation="required">
                                </div>

                            </div>

                            <div class="form-group">

                                <label for="hair" class="col-xs-2 control-label">Hair:</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="hair" id="hair" data-validation="required">
                                </div>
                                <label for="eyes" class="col-xs-2 control-label">Eyes:</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="eyes" id="eyes" data-validation="required">
                                </div>
                                <label for="complexion" class="col-xs-2 control-label">Complexion:</label>
                                <div class="col-md-2">
                                    <input type="text" class="form-control" name="complexion" id="complexion" data-validation="required">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="provincialAddress" class="col-xs-2 control-label">Provincial Address: </label>
                                <div class="col-md-10">
                                    <textarea name="provincialAddress" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="nameOfPerson" class="col-xs-4 control-label">Name of Person Fingerprinted:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="nameOfPerson" id="nameOfPerson" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="nameOfOfficial" class="col-xs-4 control-label"> Name of Official Taking Fingerprint: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="nameOfOfficial" id="nameOfOfficial" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="relativeAddress" class="col-xs-4 control-label">Name & Address of Relative:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="relativeAddress" id="relativeAddress" data-validation="required">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="spouseName" class="col-xs-2 control-label">Name of Spouse (if married): </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="spouseName" id="spouseName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="spouseAddress" class="col-xs-2 control-label">Spouse Address: </label>
                                <div class="col-md-8">
                                    <textarea name="spouseAddress" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="dialectSpoken" class="col-xs-2 control-label">Languages & Dialects Spoken:</label>
                                <div class="col-md-8">
                                    <textarea name="dialectSpoken" class="form-control fixedtextarea" rows="5" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="purpose" class="col-xs-2 control-label">Purpose of Fingerprinting: </label>
                                <div class="col-md-8">
                                    <textarea name="purpose" class="form-control fixedtextarea" rows="10" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="educationalAttainment" class="col-xs-2 control-label">Educational Attainment: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="educationalAttainment" id="educationalAttainment" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="parentsName" class="col-xs-2 control-label">Name of Parents: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="parentsName" id="parentsName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="parentsAddress" class="col-xs-2 control-label">Parent's Address: </label>
                                <div class="col-md-8">
                                    <textarea name="parentsAddress" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
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

            <div class="tab-pane" id="crim">
                <form id="criminalInfo" name="insertCriminal" action="saveCriminalReport" method="GET" class="form-horizontal">
                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="criminalDate" class="col-xs-2 control-label">Time and Date:</label>
                                <div class="input-group date col-md-8 dtpicker">
                                    <input type="text" class="form-control" name="criminalDate" id="criminalDate" data-validation="required"/>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="name" class="col-md-2 control-label">Name of Person</label>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="col-xs-2 control-label">Last Name:</label>
                                <div class="col-md-6 ">
                                    <input type="text" class="form-control" name="lastName" id="lastName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="firstName" class="col-xs-2 control-label">First Name:</label>
                                <div class="col-md-6 ">
                                    <input type="text" class="form-control" name="firstName" id="firstName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="middleName" class="col-xs-2 control-label">Middle Name:</label>
                                <div class="col-md-6 ">
                                    <input type="text" class="form-control" name="middleName" id="middleName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="civilStatus" class="col-xs-2 control-label">Civil Status:</label>
                                <div class="col-md-4 ">
                                    <input type="text" class="form-control" name="civilStatus" id="civilStatus" data-validation="required">
                                </div>
                                <label for="spouseName" class="col-xs-2 control-label">Name of Spouse (if married):</label>
                                <div class="col-md-4 ">
                                    <input type="text" class="form-control" name="spouseName" id="spouseName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="educationalAttainment" class="col-xs-2 control-label">Educational Attainment: </label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="educationalAttainment" id="educationalAttainment" data-validation="required">
                                </div>
                                <label for="voterId" class="col-xs-2 control-label">Voter's ID Card Number: </label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="voterId" id="voterId" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="dialectSpoken" class="col-xs-2 control-label">Languages & Dialects Spoken:</label>
                                <div class="col-md-8">
                                    <textarea name="dialectSpoken" id="dialectSpoken" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="civicOrganization" class="col-xs-2 control-label">Membership Civic Organization/s</label>
                                <div class="col-md-8">
                                    <textarea name="civicOrganization" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="relativeAddress" class="col-xs-2 control-label">Name and Address of Relative (In case of emergency): </label>
                                <div class="col-md-8">
                                    <textarea name="relativeAddress" id="relativeAddress" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="provincialAddress" class="col-xs-4 control-label">Business or Provincial Address:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" name="provincialAddress" id="provincialAddress" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="spouseAddress" class="col-xs-4 control-label">Spouse Address:</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" name="spouseAddress" id="spouseAddress" data-validation="required">
                                </div>  
                            </div>

                            <div class="form-group">
                                <label for="fatherName" class="col-xs-4 control-label">Father's Name: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="fatherName" id="fatherName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="fatherAddress" class="col-xs-4 control-label">Father's Address: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="fatherAddress" id="fatherAddress" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="motherName" class="col-xs-4 control-label">Mother's Name: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="motherName" id="motherName" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="motherAddress" class="col-xs-4 control-label">Mother's Address: </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="motherAddress" id="motherAddress" data-validation="required">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                        <div class="panel-body">                     
                            <div class="form-group">
                                <label for="caseNo" class="col-xs-2 control-label">Case No.:</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="caseNo" id="caseNo" data-validation="required">
                                </div>
                                <label for="arrestNo" class="col-xs-2 control-label">Arrest No. :</label>
                                <div class="col-md-4 ">
                                    <input type="text" class="form-control" name="arrestNo" id="arrestNo" data-validation="required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="placeOfArrest" class="col-xs-2 control-label">Place of Arrest :</label>
                                <div class="col-md-4 ">
                                    <input type="text" class="form-control" name="placeOfArrest" id="placeOfArrest" data-validation="required">
                                </div>
                                <label for="timeDateArrest" class="col-xs-2 control-label">Time and Date of Arrest:</label>
                                <div class="input-group date col-md-4 dtpicker">
                                    <input type="text" class="form-control" name="timeDateArrest" id="timeDateArrest" data-validation="required"/>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>  
                            </div>

                            <div class="form-group">
                                <label for="arrestingOfficer" class="col-xs-2 control-label">Arresting Officer(s):</label>
                                <div class="col-md-4">
                                    <textarea name="arrestingOfficer" class="form-control fixedtextarea" rows="3" data-validation="required"></textarea>
                                </div>
                                <label for="offenseCharge" class="col-xs-2 control-label">Offense Charge:</label>
                                <div class="col-md-4 ">
                                    <input type="text" class="form-control" name="offenseCharge" id="offenseCharge" data-validation="required">
                                </div>   
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-3 col-xs-12">
                            <input type="submit" class="btn btn-primary form-control" value="Generate Report" data-validation="required" />
                        </div>
                    </div>
                </form>
            </div>

            <div class="tab-pane" id="monthly">
                <form id="monthly" name="monthly" action="saveTenprintsCards" method="GET" class="form-horizontal">
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

<script>
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}
var url = document.location.toString();
var temp;//Tab ID
  if(url.match('#')){
       temp = url.split('#')[1];
  }  
  switch(temp){
      case 'civil':
          $("#civilianInfo").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] +'"/>');
          break;
      default: 
          $("#criminalInfo").append('<input type="hidden" name="resultID" value="' + getUrlVars()["rid"] +'"/>');                    
          break;          
  }
</script>