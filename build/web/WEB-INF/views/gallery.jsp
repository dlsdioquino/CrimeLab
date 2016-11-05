<div class="toppanel"></div>
<div class="row">
    <div class="panel panel-primary">
        <div class="panel-body">
            <div class="col-xs-12">
                <table id="GalleryTable" class="table table-bordered table-striped">
                    <thead>
                    <th>Case Number:</th>
                    <th>Image:</th>
                    </thead>

                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script type = "text/javascript" charset = "utf-8" >
    $(document).ready(function () {
        var table = $('#GalleryTable').DataTable({
            "ajax": {
                "url": "getGallery",
                "dataSrc": ""
            },
            "columns": [
                {"data": "caseNo",
                    "render": function (data) {
                        return '<a href="CompositeDetails?caseNo=' + data + '">' + data + '</a>';
                    }
                },
                {"data": "caseNo",
                    "render": function (data) {
                        return '<img src="imageDisplay?caseNo=' + data + '" width="120" >';
                    }
                }
            ]
        });
    }
    );

</script>