$(document).ready(function() {
    $('#usertable').dataTable({
        "iDisplayLength" : 10,
        "bLengthChange" : false,
        "bInfo" : false,
        "columns" : [
            { "width" : "20%" },
            { "width" : "40%" },
            {
                "width" : "5%",
                "orderable" : false
            },
            { "width" : "11%" },
            {
                "width" : "7%",
                "orderable" : false
            },
            { "width" : "15%" },
            {
                "width" : "2%",
                "orderable" : false
            }
        ]
    });

    $('[data-toggle="tooltip"]').tooltip();
} );

$('.togglebut').click(function(e){
    e.preventDefault();
    
    $.blockUI({
        message: "Processing...",
        css: {
            fontWeight: 'bold',
            padding: '10px'
        }
    });
    
    var tbut = $(this);
    var username = $(this).parent().siblings("[class^='unameholder']").text().replace(/\s/g, "");
    
    $.ajax({
        url: 'users/edituser',
        type: 'GET',
        data: 'username='+username,
        error: function(){
            alert('There was an error on the side of the server.');
        },
        success: function(msg){
            if (msg){
                if(tbut.children("span").attr("class") === 'glyphicon glyphicon-ok') {
                    tbut.parent().siblings("[class^='unameholder']").attr("class", "unameholder");
                    tbut.children("span").attr("class", "glyphicon glyphicon-remove");
                    tbut.children("span").tooltip('hide').attr('data-original-title', "Deactivate").tooltip('fixTitle').tooltip('show');
                } else {
                    tbut.parent().siblings("[class^='unameholder']").attr("class", "unameholder userdisabled");
                    tbut.children("span").attr("class", "glyphicon glyphicon-ok");
                    tbut.children("span").tooltip('hide').attr('data-original-title', "Activate").tooltip('fixTitle').tooltip('show');
                }
            }
        }
    }).done(function(){
        $.unblockUI();
    });
});

$('.confbut').click(function(e){
    e.preventDefault();
    
    var username = $(this).parent().siblings("[class^='unameholder']").text().replace(/\s/g, "");
    
    $.ajax({
        url: 'users/loaduser',
        type: 'GET',
        data: 'username='+username,
        datatype: 'json',
        error: function(){
            alert('There was an error on the side of the server.');
        },
        success: function(data){
            $(".unameheader").text(data["username"]);
            $("input[name='username']").val(data["username"]);
            $("input[name='firstname']").val(data["firstname"]);
            $("input[name='middle']").val(data["middle"]);
            $("input[name='lastname']").val(data["lastname"]);
            $("input[name='position']").val(data["position"]);
            for(var i = 0; i < data["role"].length; i++) {
                $("input[value='" + data["role"][i] + "']").attr("checked", "checked");
            }
            checkAdmin();
            $('#updateModal').modal('show');
        }
    });
});

$("#updateModal").submit(function(){
    validateAll();
    
    if(validateString($("input[name='firstname']"))
        && validateString($("input[name='lastname']"))
        && validateString($("input[name='position']"))) {
        if($("input[name='role']:checked").val()) {
            $.blockUI({
                message: "Updating user...",
                css: {
                    fontWeight: 'bold',
                    padding: '10px'
                }
            });
            
            $('#updateModal').modal('hide');
            
            return true;
        } else {
            $('.norole').fadeIn(500);
        }
    }
    
    return false;
});

function validateString(itext) {
    if(itext.val().replace(/\s/g, "") === "") {
        var curspan = itext.parent().parent().children("span");
        var curpar = itext.parent().parent();
        var curclass = itext.parent().parent().attr('class');

        curpar.attr('class', curclass+' has-error');
        curspan.fadeIn(500);
        
        itext.val('');
        
        return false;
    }
    
    return true;
}

$("input[name='firstname']").blur(function(){
    validateString($(this));
});

$("input[name='lastname']").blur(function(){
    validateString($(this));
});

$("input[name='position']").blur(function(){
    validateString($(this));
});

$("input[name='firstname']").click(function(){
    retPrevState($(this));
});

$("input[name='lastname']").click(function(){
    retPrevState($(this));
});

$("input[name='position']").click(function(){
    retPrevState($(this));
});

function retPrevState(itext) {
    var curspan = itext.parent().parent().children("span");
    var curpar = itext.parent().parent();

    curpar.attr('class', 'form-group');
    curspan.fadeOut(500);
}

function validateAll(){
    validateString($("input[name='firstname']"));
    validateString($("input[name='lastname']"));
    validateString($("input[name='position']"));
}

$(".admincheck").change(function(){
    checkAdmin();
});

function checkAdmin() {
    if($(".admincheck:checked").length > 0) {
        $(".othercheck").attr("disabled", "disabled");
    } else {
        $(".othercheck").removeAttr("disabled");
    }
}