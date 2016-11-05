<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${success}
<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <table id="assignmentsTable" class="table table-striped table-bordered">
            <thead>    
            <th>Result ID</th>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Description</th>
            <th>Date Created</th>
            <th>Assigned By</th>
            <th>Assigned To</th>
            <th>Priority</th>
            <th>Status</th>  
            <th>Submitted</th>
            </thead>            
            <tbody>                
            </tbody>
        </table>                        
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var taskid;
        var resid;
        var table = $('#assignmentsTable').DataTable({
            "ajax": {
                "url": "/CrimeLab/getAssignments",
                "dataSrc": ""
            },
            "columns": [
                {"data": "taskID"},
                {"data": "result_id"},
                {"data": "taskname"},
                {"data": "description"},
                {"data": "date_created"},
                {"data": "AssignedBy"},
                {"data": "AssignedTo"},
                {"data": "Priority"},
                {"data": "Status"},
                {"data": "Submitted"}
            ]
        });
        table.column(0).visible(false);//Hide Result ID
        table.column(1).visible(false);//Hide Task ID

        $('#assignmentsTable tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
                taskid = table.cell(this, 0).data();
                resid = table.cell(this, 1).data();
                var title = table.cell(this, 2).data();
                console.log(taskid + " :" + resid);
                console.log(table.cell(this, 9).data());
                var message;
                if(table.cell(this,9).data() === 'Submitted'){
                    message =  '<div class="row">  ' +
                            '<div class="col-md-12"> ' +
                            '<form id="taskForm" class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                            '<label class="col-md-4 control-label" for="taskStatus">Task Status:</label> ' +
                            '<div class="col-md-4"> <div class="radio"> <label for="taskStatus-0"> ' +
                            '<input type="radio" name="taskStatus" id="taskStatus-0" value="1" checked="checked"> ' +
                            'Complete </label> ' +
                            '</div><div class="radio"> <label for="taskStatus-1"> ' +
                            '<input type="radio" name="taskStatus" id="taskStatus-1" value="2">Cancel </label> ' +
                            '</div> ' +
                            '</div> </div>' +
                            '<input type="hidden" name="rid" value="' + resid + '">' +
                            '<input type="hidden" name="tid" value="' + taskid + '">' +
                            '<a href=# target ="_blank">View Report</a>' +
                            '</form> </div>  </div>';
                }else{
                    message =   '<div class="row">  ' +
                            '<div class="col-md-12"> ' +
                            '<form id="taskForm" class="form-horizontal"> ' +
                            '<div class="form-group"> ' +
                            '<label class="col-md-4 control-label" for="taskStatus">Task Status:</label> ' +
                            '<div class="col-md-4"> <div class="radio"> <label for="taskStatus-0"> ' +
                            '<input type="radio" name="taskStatus" id="taskStatus-0" value="1" checked="checked"> ' +
                            'Complete </label> ' +
                            '</div><div class="radio"> <label for="taskStatus-1"> ' +
                            '<input type="radio" name="taskStatus" id="taskStatus-1" value="2">Cancel </label> ' +
                            '</div> ' +
                            '</div> </div>' +
                            '<input type="hidden" name="rid" value="' + resid + '">' +
                            '<input type="hidden" name="tid" value="' + taskid + '">' +                            
                            '</form> </div>  </div>';
                }   
                bootbox.dialog({
                    title: title,
                    message:message,
                    buttons: {
                        success: {
                            label: "Save",
                            className: "btn-success",
                            callback: function () {
                                var answer = $("input[name='taskStatus']:checked").val();
                                alert($("#taskForm").serialize());
                            }
                        }
                    }
                }
                );
            }
        });
    });
</script>
<style>
    tr.group,
    tr.group:hover {
        background-color: #ddd !important;
    }
</style>