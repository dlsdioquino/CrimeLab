<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toppanel"></div>
<div class="row">
    <div class="col-xs-12">
        <div class="panel panel-default">
            <ol class="breadcrumb">
                <li><a href="#">root</a></li>
                <li class="active">Folder 1</li>
            </ol>

            <div class="panel-body">
                <div class="pull-right">
                    <button class="btn btn-labeled btn-success btn-sm" data-toggle="modal" data-target="#EditFolder" data-original-title>
                        <span class="btn-label"><i class="glyphicon glyphicon-pencil"></i></span> Edit Folder
                    </button>

                    <button class="btn btn-labeled btn-danger btn-sm" data-toggle="modal" data-target="#DeleteFolder" data-original-title>
                        <span class="btn-label"><i class="glyphicon glyphicon-trash"></i></span> Delete Folder
                    </button>
                </div>
                <div class="row">
                    <div class="col-sm-2">
                        <div class="menu-itemF transparent text-center">
                            <a href="/CrimeLab/Chemistry/subfolder">
                                <i class="fa fa-folder-open-o"></i>
                                <p>Folder 1</p>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="menu-itemF transparent text-center">
                            <a href="#">
                                <i class="fa fa-file-word-o"></i>
                                <p>Word File</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </div>
</div>

<div class="modal fade" id="EditFolder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Edit Folder</h4>
            </div>
            <div class="form-group">
                <center>
                <br>
                <p>Rename Folder: &nbsp; <input type="text" value=" Folder 1"></p>
                <div class="form-group">
                    <div class="input-group">
                        <button class="btn btn-labeled btn-success btn-sm" data-toggle="modal" data-target="#" data-original-title>
                            <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span> Save
                        </button>
                        &nbsp;
                        <button class="btn btn-labeled btn-info btn-sm" data-toggle="modal" data-dismiss="modal" data-original-title>
                            <span class="btn-label"><i class="glyphicon glyphicon-remove-sign"></i></span> Cancel
                        </button>
                    </div>
                </div>
            </div>
        </div>
        </center>
    </div>
</div>

<div class="modal fade" id="DeleteFolder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Are you sure?</h4>
            </div>
            <div class="form-group">
                <center>
                <br>
                <p>Are you sure you want to delete <span>Folder 1</span>?</p>
                <div class="form-group">
                    <div class="input-group">
                        <button class="btn btn-labeled btn-danger btn-sm" data-toggle="modal" data-target="#" data-original-title>
                            <span class="btn-label"><i class="glyphicon glyphicon-trash"></i></span> Delete
                        </button>
                        &nbsp;
                        <button class="btn btn-labeled btn-info btn-sm" data-toggle="modal" data-dismiss="modal" data-original-title>
                            <span class="btn-label"><i class="glyphicon glyphicon-remove-sign"></i></span> Cancel
                        </button>
                    </div>
                </div>
                </center>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>
<script type="text/javascript">
        $("#fmanagement").attr("class", "active");
</script>