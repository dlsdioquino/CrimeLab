<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1">                    
        <table id="assignmentTable">
            <thead>                    
            <th>Task</th>
            <th>Description</th>
            <th>Priority</th>              
            <th>Report Type</th>                
            <th>Date Created</th>       
            <th>Result ID</th>
            </thead>
            <tbody>
            </tbody>
        </table>                    
    </div>
</div>
<script type = "text/javascript" charset = "utf-8" >
    $(document).ready(function () {
        var val, resID;
        var table = $('#assignmentTable').DataTable({
            "ajax": {
                "url": "/CrimeLab/getUserTasks",
                "dataSrc": ""
            },
            "columns": [
                {"data": "taskname"},
                {"data": "description"},
                {"data": "Priority"},
                {"data": "Report Type"},
                {"data": "date_created"},
                {"data": "result_id"}
            ]
        });
        table.column(5).visible(false);//Hide Result ID
        $('#assignmentTable tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
                val = table.cell(this, 3).data();
                resID = table.cell(this, 5).data();
                bootbox.confirm("Are you sure you want to do this task?", function (result) {
                    if (result) {
                        window.location.href = '/CrimeLab/' + evaluateReportType(val) + "?rid=" + resID;
                    }
                });
            }
        });
        function evaluateReportType(val) {
            switch (val) {
                case "CH":
                    return "Chemistry/report";//Default
                case "CR":
                    return "Fingerprint/report#Crim";//Criminal
                case "CV":
                    return "Civilian/report#Civil";//Civillian
                case "DT":
                    return "Chemistry/report#drugTest";//Drug Test
                case "FA":
                    return "Firearms/report";   //Default
                case "ME":
                    return "PhysicalIdentification/report#macroEtching";//Macro Etching
                case "ML":
                    return "MedicoLegal/report";//Default
                case "PI":
                    return "PhysicalIdentification/report";//Default
                case "QD":
                    return "QuestionedDocument/report";//Default
            }
        }

    });

</script>    
