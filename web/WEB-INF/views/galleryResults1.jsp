<div class="toppanel"></div>
<div class="row">
    <div class="col-xs-12">
        <form name="insertGalleryResults" action="savedGalleryResults" method="POST" id="galleryResults" enctype="multipart/form-data" class="form-horizontal">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="col-xs-4">
                        <input type="file" name="photo"/>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="caseNumber" class="col-md-4 control-label">Case Number</label>
                            <div class="col-md-6">
                                <input id="caseNumber" type="text" name="caseNo" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="caseDate" class="col-md-3 control-label">Date</label>
                            <div class="col-md-6 input-group date dtpicker">
                                <input id="caseNumber" type="date" name="caseDate" class="form-control"/>
                            </div>							
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <label for="caseOffense" class="col-md-1 control-label">Offense/Incident</label>
                        <div class="col-xs-offset-1 col-md-5">
                            <input id="caseOffense" type="text" name="offenseIncident" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="alias" class="col-md-1 control-label">Name/AKA</label>
                        <div class="col-xs-offset-1 col-md-5">
                            <input id="alias" type="text" name="nameAKA" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <label class="col-md-1 control-label">Sex:</label>
                            <div class="col-md-4">
                                <div class="col-md-6">
                                    <div class="radio col-md-offset-1">
                                        <label>
                                            <input type="radio" name="sex" value="Male">
                                            Male
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="radio col-md-offset-1">
                                        <label>
                                            <input type="radio" name="sex" value="Female">
                                            Female
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="age" class="col-xs-4 control-label">Age
                            </label>
                            <div class="col-md-3">
                                <input type="text" name="age" class="form-control"/>
                            </div>
                        </div>						
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="height" class="col-md-1 control-label">Height</label>
                            <div class="col-xs-offset-1 col-sm-3">
                                <input type="text" name="height" class="form-control" />
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="weight" class="col-xs-4 control-label">Weight</label>
                            <div class="col-sm-3">
                                <input type="text" name="weight" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="built" class="control-label col-xs-1">Built</label>
                            <div class="col-sm-3 col-xs-offset-1">
                                <input type="text" name="built" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="complexion" class="control-label col-xs-4">Complexion</label>
                            <div class="col-sm-3">
                                <input type="text" name="complexion" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="otherInfo" class="control-label col-xs-1">Others</label>
                            <div class="col-sm-9  col-xs-offset-1">
                                <textarea name="otherInfo" class="form-control fixedtextarea" rows="4"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="description" class="control-label col-xs-2">Described by</label>
                            <div class="col-xs-offset-1 col-md-8">
                                <input type="text" name="describedBy" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="requestingParty" class="control-label col-xs-2">Requesting Party</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="requestingParty" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="investOnCase" class="control-label col-xs-2">Investigator on Case</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="investOnCase" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="interviewer" class="control-label col-xs-2">CCCI/Interviewer</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="interviewer" class="form-control"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="col-xs-12">
                        <label class="col-md-3 control-label">The witness indicate this image is a:</label>
                        <div class="col-xs-8">          
                            <div class="col-md-3">
                                <div class="radio col-xs-offset-1">
                                    <label>
                                        <input type="radio" name="rating" value="Poor">
                                        Poor
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="radio col-xs-offset-1">
                                    <label>
                                        <input type="radio" name="rating" value="Good">
                                        Good
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="radio col-xs-offset-1">
                                    <label>
                                        <input type="radio" name="rating" value="Very Good">
                                        Very Good
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="radio col-xs-offset-1">
                                    <label>
                                        <input type="radio" name="rating" value="Excellent">
                                        Excellent
                                    </label>
                                </div>
                            </div>  
                        </div>
                    </div>

                </div>

            </div>
            <div class="form-group">
                <div class="col-xs-3">
                    <input type="submit" value="Generate Report" class="btn btn-primary form-control">
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>