var seconds = 0;

$(document).ready(function(){
    getCount();
    setInterval(function(){
        getCount();
    },3000);
});

function getCount() {
    $.ajax({
        url: "/CrimeLab/getNotificationCount" ,
        success: function(data){                           
            $("#notifbadge").text(data);
        }
     });
}