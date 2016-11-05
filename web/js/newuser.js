var checker = false;

$("form[name='newuserform']").submit(function(){
    validateAll();
    
    if(validateString($("input[name='firstname']"))
        && validateString($("input[name='lastname']"))
        && validateString($("input[name='position']"))
        && validateString($("input[name='username']"))
        && validateString($("input[name='password']"))) {
        if($("input[name='role']:checked").val()) {
            if(checker) {
                $.blockUI({
                    message: "Creating user...",
                    css: {
                        fontWeight: 'bold',
                        padding: '10px'
                    }
                });
                return true;
            }
        } else {
            $('.norole').fadeIn(500);
        }
    }
    
    return false;
});

$("input[name='firstname']").blur(function(){
    validateString($(this));
});

$("input[name='lastname']").blur(function(){
    validateString($(this));
});

$("input[name='position']").blur(function(){
    validateString($(this));
});

$("input[name='username']").blur(function(){
    if(validateString($(this))) {
        validateUsername($(this));
    }
});

$("input[name='username']").change(function(){
    $(this).val($(this).val().replace(/\s/g, ""));
});

$("input[name='username']").keyup(function(evt){
    var curval = $(this).val();
    
    if(evt.keyCode === 32) {
        $(this).val(curval.substring(0, curval.length - 1));
    }
});

$("input[name='password']").blur(function(){
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

$("input[name='username']").click(function(){
    retPrevState($(this));
    
    $(this).parent().children("span").fadeOut(500);
});

$("input[name='password']").click(function(){
    retPrevState($(this));
});

$("input[name='role']").click(function(){
    $('.norole').fadeOut(500);
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

function validateAll(){
    validateString($("input[name='firstname']"));
    validateString($("input[name='lastname']"));
    validateString($("input[name='position']"));
    validateString($("input[name='username']"));
    validateString($("input[name='password']"));
    if(validateString($("input[name='username']"))) {
        validateUsername($("input[name='username']"));
    }
}

function retPrevState(itext) {
    var curspan = itext.parent().parent().children("span");
    var curpar = itext.parent().parent();

    curpar.attr('class', 'form-group');
    curspan.fadeOut(500);
}

function validateUsername(unamefield) {
    var fieldval = unamefield.val();
    
    $.ajax({
        url: 'newuser/usercheck',
        type: 'GET',
        data: 'username='+fieldval,
        error: function(){
            alert('There was an error on the side of the server.');
        },
        success: function(msg){ 
            if (msg){
                unamefield.parent().parent().attr('class', 'form-group has-success');
                checker = true;
            } else {
                unamefield.parent().children("span").fadeIn(500);
                var curclass = unamefield.parent().parent().attr('class');
                unamefield.parent().parent().attr('class', curclass+' has-error');
                checker = false;
            }
        }
    });
}

$(".admincheck").change(function(){
    if($(".admincheck:checked").length > 0) {
        $(".othercheck").attr("disabled", "disabled");
    } else {
        $(".othercheck").removeAttr("disabled");
    }
});