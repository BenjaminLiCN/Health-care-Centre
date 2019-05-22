$(document).ready(function() {
    $(".login_btn").click(function(){
        payload = {};
        var username = $("#username").val();
        var password = $("#password").val();
        payload.username = username;
        payload.password = password;
        event.preventDefault();
        $.ajax({

            url: "http://18.191.27.125:8082/user/login",
            type: 'POST',
            data : payload,
//            crossDomain : true,
            dataType : 'json',
            success: function (data) {
                console.log(data);
                window.location("html/Userprofile.html");
            }

        })
    })


})