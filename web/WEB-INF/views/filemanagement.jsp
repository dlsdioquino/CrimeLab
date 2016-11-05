<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toppanel"></div>
<div class="row">
    <div class="col-xs-12">
        <div class="panel panel-default">
            <ol class="breadcrumb">
                <li class="active"><a href="#">root</a></li>
            </ol>

            <div class="panel-body">
                <div class="pull-right">
                    <button class="btn btn-labeled btn-success btn-sm" data-toggle="modal" data-target="#AddFolder" data-original-title>
                        <span class="btn-label"><i class="glyphicon glyphicon-plus"></i></span> Add Folder
                    </button>
                </div>
                <div class="row">
                    <div class="col-sm-2">
                        <div class="menu-itemF transparent text-center" id="MenuData">
                            <a href="/CrimeLab/Chemistry/subfolder">
                                <i class="fa fa-folder-open-o"></i>
                                <p>Folder 1</p>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="menu-itemF transparent text-center" id="MenuData">
                            <a href="#">
                                <i class="fa fa-file-word-o"></i>
                                <p>Word File</p>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="menu-itemF transparent text-center" id="MenuData">
                            <a href="#">
                                <i class="fa fa-file-pdf-o"></i>
                                <p>PDF File</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </div>
</div>

<div class="modal fade" id="AddFolder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Add Folder</h4>
            </div>
            <div class="form-group">
                <center>
                    <br>
                    <form>
                        <p>Add Folder: &nbsp; <input type="text" value=" New Folder"></p>
                        <div class="form-group">
                            <div class="input-group">
                                <input type="submit" class="btn btn-success form-control" value="Save"/>
                                <input type="submit" data-dismiss="modal" class="btn btn-primary form-control" value="Cancel"/>

                            </div>
                        </div>
                    </form>
            </div>
        </div>
        </center>
    </div>
</div>

<ul id="contextMenu" class="dropdown-menu" role="menu" style="display:none" >
    <li><a tabindex="-1" href="#">Edit</a></li>
    <li><a tabindex="-1" href="#">Delete</a></li>
    <li class="divider"></li>
    <li><a tabindex="-1" href="#">Make a copy</a></li>
    <li><a tabindex="-1" href="#">Move</a></li>
</ul>

<script src="/CrimeLab/js/rightclick.js" type="text/javascript"></script>
<script type="text/javascript">
    $(".dtpicker").datetimepicker();
</script>
<script type="text/javascript">
    $("#fmgmt").attr("class", "active");
</script>