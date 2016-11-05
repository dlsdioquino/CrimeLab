<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toppanel">
<div class="panel panel-primary">
    <div class="panel-body">
        <div class="row">
            <c:forEach var="photo" items="${compositeDetails}">
                <table class="table table-hover table-condensed table-responsive table-striped table-bordered">
                    <thead>
                        <tr>
                            <td colspan="2" style="padding: 25px;">
                    <center><img src="imageDisplay?caseNo=${photo.caseNo}" width="150"></center>
                    </td>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Case Number: ${photo.caseNo}</td>
                            <td>Date: ${photo.date}</td>
                        </tr>
                        <tr>
                            <td>Offense/Incident: ${photo.offenseIncident}</td>
                            <td>Name/AKA: ${photo.nameAKA}</td>
                        </tr>
                        <tr>
                            <td>Sex: ${photo.sex}</td>
                            <td>Height: ${photo.height}</td>
                        </tr>
                        <tr>
                            <td>Built: ${photo.built}</td>
                            <td>Other Information: ${photo.otherInfo}</td>
                        </tr>
                        <tr>
                            <td>Described By: ${photo.describedBy}</td>  
                            <td>Requesting Party: ${photo.requestingParty}</td>
                        </tr>
                        <tr>
                            <td>Investigator on Case: ${photo.investOnCase}</td> 
                            <td>Interviewer: ${photo.interviewer}</td>
                        </tr>
                        <tr>
                            <td>Age: ${photo.age}</td>
                            <td>Weight: ${photo.weight}</td>
                        </tr>
                        <tr>
                            <td>Complexion: ${photo.complexion}</td>
                            <td>Rating: ${photo.rating}</td>                    
                        </tr>			
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </div>
</div>
