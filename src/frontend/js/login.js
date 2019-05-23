$(document).ready(function() {
    $(".login_btn").click(function(){
        payload = {};
        var username = $("#username").val();
        var password = $("#password").val();
        payload.email = username;
        payload.password = password;
        event.preventDefault();
        //18.191.27.125
        $.ajax({
            url: "http://localhost:8082/user/login",
            type: 'POST',
            data : payload,
//            crossDomain : true,
            dataType : 'json',
            success: function (data) {
                var id = data.id;
                var admin = data.admin;
                var name = data.name;
                var storage=window.localStorage;

                storage.id = id;
                storage.admin = admin;
                storage.name = name;
                console.log(name)
                console.log(admin == 1)
                alert();
                window.location.href = admin == 1 ? "Adminprofile.html" : "Userprofile.html";
            },
            error: function(data){
                console.log(data);
            }

        })
    })


})