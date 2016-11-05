<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${success} <!-- Success or Not -->
<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <form id="assignmentForm" action="/CrimeLab/assignment" method="POST">
            <b>${division}</b>
            <input type="hidden" value="${division}" name="division">
            Task Name:<input type="text" name="taskName"/><br/>
            Description:<textArea name="description"></textarea>
            High or Low Priority:<input type="text"name="priority"><br>
            Report Type: 
            <select name="reportType">
                <c:forEach items="${resultTypes}" var="rt">
                    <option  value="${rt.rtype}" >${rt.description}</option>
                </c:forEach>
            </select>
            <table id="userTable">
                <thead>                    
                        <th>User Name</th>
                        <th>Full Name</th>                
                </thead>
                <tbody>

                </tbody>
            </table>
        
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Assign Task"/>
        </form>
    </div>
</div>

<script type = "text/javascript" charset = "utf-8" >
    $(document).ready(function () {
        var table = $('#userTable').DataTable({
            "ajax": {
                "url": "/CrimeLab/getUsers",
                "dataSrc": ""
            },
            "columns": [
                {"data": "username"},
                {"data": "Name"}
            ]
        });
        $('#userTable').removeClass('display').addClass('table table-striped table-bordered');
        $('#userTable tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });

        $("#assignmentForm").submit(function () {
            $.map(table.cells('tr.selected', 0).data(), function (el) {
                $("#assignmentForm").append('<input type="hidden" name="users" value="' + el + '"/>');
            });
        });
    });

</script>    
