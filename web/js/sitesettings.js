tinymce.init({
    selector: "textarea",
    menubar: false
});

$(".settingform").submit(function(e){
    e.preventDefault();
    
    tinymce.triggerSave();

    var csrfToken = $("meta[name='_csrf']").attr("content"); 
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
    var headers = [];
    headers[csrfHeader] = csrfToken;
    
    $.ajax({
        url: $(this).attr("action"),
        data: $(this).serialize(),
        headers: headers,
        type: 'POST',
        error: function(xhr, status, error) {
            var err = eval("(" + xhr.responseText + ")");
            console.log(err.Message);
        },
        success: function(msg) {
            if(msg) {
                $.blockUI({
                    message: '<div class="alert alert-success" role="alert">'
                        + '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>'
                        +    '<span class="sr-only">Success:</span>'
                        +    'Changes Saved.'
                        + '</div>',
                    showOverlay: false,
                    centerY: 0,
                    timeout: 2000,
                    css: {
                        border: 'none',
                        background: 'none',
                        top: '10px',
                        left: '',
                        right: '10px'
                    }
                });
            } else {
                $.blockUI({
                    message: '<div class="alert alert-danger" role="alert">'
                        + '<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>'
                        +    '<span class="sr-only">Error:</span>'
                        +    'Saving changes failed.'
                        + '</div>',
                    showOverlay: false,
                    centerY: 0,
                    timeout: 2000,
                    css: {
                        border: 'none',
                        background: 'none',
                        top: '10px',
                        left: '',
                        right: '10px'
                    }
                });
            }
        }
    });
});

    