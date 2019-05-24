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
            url: "http://18.191.27.125:8082/user/login",
            type: 'POST',
            data : payload,
            crossDomain : true,
            contentType: "application/json",
            success: function (data) {
                var id = data.id;
                var admin = data.admin;
                var name = data.name;
                var storage=window.localStorage;
                storage.id = id;
                storage.admin = admin;
                storage.name = name;
                window.location.href = admin == 1 ? "Adminprofile.html" : "Userprofile.html";
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                if(XMLHttpRequest.status==500)
                    alert("Internal server error! 500");
                  else if(XMLHttpRequest.status==200){
                    alert("200 but not data!")
                  }else{
                    alert("Internal server error! else");
                    console.log(XMLHttpRequest.responseText);
                  }
            }

        })
    })


})