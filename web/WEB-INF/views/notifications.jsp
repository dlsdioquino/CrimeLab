<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-xs-12">
        <table id="taskTable" class="table table-striped table-bordered">
            <thead>                    
            <th>Task</th>
            <th>Description</th>                
            <th>Date Created</th>                
            </thead>
            <tbody>
            </tbody>
        </table>            

    </div>
</div>

<script type = "text/javascript" charset = "utf-8" >
    $(document).ready(function () {
        var table = $('#taskTable').DataTable({
            "ajax": {
                "url": "getUserTasks",
                "dataSrc": ""
            },
            "columns": [
                {"data": "taskname"},
                {"data": "description"},
                {"data": "date_created"}
            ]
        });
        $('#userTable').removeClass('display').addClass('table table-striped table-bordered');
    });

</script>    
