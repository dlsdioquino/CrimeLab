var multip = 0;

var csrfToken; 
var csrfHeader;

var headers = [];

$(document).ready(function(){
    $('.minifeed').enscroll({
        showOnHover: true,
        verticalTrackClass: 'tracker',
        verticalHandleClass: 'scrollhandle'
    });
    $('.minifeed').attr("style", "overflow:hidden;padding-right:5px;");
    tinymce.init({
        selector: "textarea",
        menubar: false
    });
    csrfToken = $("meta[name='_csrf']").attr("content"); 
    csrfHeader = $("meta[name='_csrf_header']").attr("content");
});


$('.minifeed').bind('scroll', function() {
    if($(this).scrollTop() + $(this).innerHeight() >= this.scrollHeight) {
        
        $.ajax({
            url : "content/loadmore",
            data : "multiplier=" + multip,
            type : "GET",
            dataType : 'json',
            error : function(xhr, status, error) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message);
            },
            success : function(data) {
                if(data.length > 0) {
                    for(var key in data) {
                        var newel = "<div class='row postitem' id='post" + data[key]["content_id"] + "'>";
                        newel += "<div class='col-sm-12 feeditem'>";
                        if(data[key]["status"] === 1) {
                            newel += "<span class='activepost'>" + data[key]["title"] + "</span><br/>";
                        } else {
                            newel += "<span class='inactivepost'>" + data[key]["title"] + "</span><br/>";
                        }
                        newel += "<span class='help-block'>" + data[key]["dc"] + "</span>";
                        newel += '</div>';
                        newel += '</div>';
                        $(".postitem").parent().append(newel);
                    }
                    multip++;
                }
            }            
        });
    }
});

$("form[name='postform']").submit(function(e){
    e.preventDefault();
    
    tinymce.triggerSave();
    
    if($("input[name='title']").val().replace(/\s/g, '') !== ""
        && $("textarea[name='content']").val().replace(/\s/g, '') !== "") {
        var titleinput = $("input[name='title']");
        
        titleinput.attr("readonly", "readonly");
        tinyMCE.get('postcontent').getBody().setAttribute('contenteditable', false);
        
        headers[csrfHeader] = csrfToken;
        
        $.blockUI({
            message: "Loading...",
            css: {
                fontWeight: 'bold',
                padding: '10px'
            }
        });
        
        $.ajax({
            url: $(this).attr("action"),
            data: $(this).serialize(),
            headers: headers,
            type: 'POST',
            dataType: 'json',
            error: function(xhr, status, error) {
                titleinput.removeAttr("readonly");
                tinyMCE.get('postcontent').getBody().setAttribute('contenteditable', true);
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message);
                $.unblockUI();
            },
            success: function(data) {
                $.unblockUI();
                if(data["status"]) {
                    titleinput.removeAttr("readonly");
                    titleinput.val("");
                    tinyMCE.get('postcontent').getBody().setAttribute('contenteditable', true);
                    tinyMCE.get('postcontent').setContent('');
                    addLatestPost(data["postid"]);
                } else {
                    titleinput.removeAttr("readonly");
                    tinyMCE.get('postcontent').getBody().setAttribute('contenteditable', true);
                    alert('Something went wrong in the server.');
                }
            }
        });
    }
});

function addLatestPost(postid) {
    $.ajax({
        url : "content/latestcontent",
        data : "postid=" + postid,
        type : "GET",
        dataType : 'json',
        error : function(xhr, status, error) {
            var err = eval("(" + xhr.responseText + ")");
            console.log(err.Message);
        },
        success : function(data) {
            var newel = "<div class='row postitem newpostitem' id='post" + data["content_id"] + "' style='display:none;'>";
            newel += "<div class='col-sm-12 feeditem'>";
            if(data["status"] === 1) {
                newel += "<span class='activepost'>" + data["title"] + "</span>&nbsp;<span class='label label-success'>New</span><br/>";
            } else {
                newel += "<span class='inactivepost'>" + data["title"] + "</span><br/>";
            }
            newel += "<span class='help-block'>" + data["dc"] + "</span>";
            newel += '</div>';
            newel += '</div>';
            $(".postitem").parent().prepend(newel);
            
            slideNewPost();
        }            
    });
}

function slideNewPost() {
    $('.newpostitem:first').slideDown();
}