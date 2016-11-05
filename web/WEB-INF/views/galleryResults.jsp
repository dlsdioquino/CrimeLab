<div class="row">
    <div class="col-xs-12">
        <form name="insertGalleryResults" action="saveGalleryResults?${_csrf.parameterName}=${_csrf.token}" method="POST" id="galleryResults" enctype="multipart/form-data" class="form-horizontal">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="col-xs-4">
                        <input type="file" name="photo" data-validation="mime size"
                               data-validation-allowing="jpg, png"
                               />
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="caseNumber" class="col-md-4 control-label">Case Number</label>
                            <div class="col-md-6">
                                <input id="caseNumber" type="text" name="caseNo" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="caseDate" class="col-md-3 control-label">Date</label>
                            <div class="col-md-6 input-group date dtpicker">
                                <input id="caseNumber" type="date" name="caseDate" class="form-control"
                                       data-validation="required"
                                       data-validation-error-msg="You have not entered a valid date."
                                       />
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
                            <input id="caseOffense" type="text" name="offenseIncident" class="form-control"
                                   data-validation="required"
                                   />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="alias" class="col-md-1 control-label">Name/AKA</label>
                        <div class="col-xs-offset-1 col-md-5">
                            <input id="alias" type="text" name="nameAKA" class="form-control"
                                   data-validation="custom" data-validation-regexp="^([a-zA-Z-]+)$"
                                   data-validation-error-msg="You have not entered a valid name."
                                   />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <label class="col-md-1 control-label">Sex:</label>
                            <div class="col-md-4">
                                <div class="col-md-6">
                                    <div class="radio col-md-offset-1">
                                        <label>
                                            <input type="radio" name="sex" value="Male" checked="checked" />                                                  
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
                                <input type="text" name="age" class="form-control"
                                       data-validation="number"
                                       data-validation-error-msg="You have not entered a valid age."
                                       />
                            </div>
                        </div>						
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="height" class="col-md-1 control-label">Height</label>
                            <div class="col-xs-offset-1 col-sm-3">
                                <input type="text" name="height" class="form-control" 
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="weight" class="col-xs-4 control-label">Weight</label>
                            <div class="col-sm-3">
                                <input type="text" name="weight" class="form-control"
                                       data-validation="alphanumeric"
                                       data-validation-error-msg="You have not entered a valid weight."
                                       />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="built" class="control-label col-xs-1">Built</label>
                            <div class="col-sm-3 col-xs-offset-1">
                                <input type="text" name="built" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <label for="complexion" class="control-label col-xs-4">Complexion</label>
                            <div class="col-sm-3">
                                <input type="text" name="complexion" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="otherInfo" class="control-label col-xs-1">Others</label>
                            <div class="col-sm-9  col-xs-offset-1">
                                <textarea name="otherInfo" class="form-control fixedtextarea" rows="4"
                                          data-validation="required"
                                          ></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="description" class="control-label col-xs-2">Described by</label>
                            <div class="col-xs-offset-1 col-md-8">
                                <input type="text" name="describedBy" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="requestingParty" class="control-label col-xs-2">Requesting Party</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="requestingParty" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="investOnCase" class="control-label col-xs-2">Investigator on Case</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="investOnCase" class="form-control"
                                       data-validation="required"
                                       />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-8">
                            <label for="interviewer" class="control-label col-xs-2">CCCI/Interviewer</label>
                            <div class="col-md-8 col-xs-offset-1">
                                <input type="text" name="interviewer" class="form-control"
                                       data-validation="required"
                                       data-validation-error-msg="You have not entered a valid interviewer name."
                                       />
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
                                        <input type="radio" name="rating" value="Poor" checked="checked">
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


<script>
    $.validate({
        modules: 'file',
        validateOnBlur: false, // disable validation when input looses focus
        errorMessagePosition: 'top', // Instead of 'element' which is default
        scrollToTopOnError: true // Set this property to true if you have a long form
    });
</script>