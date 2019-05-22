$(document).ready(function() {
    $(".login_btn").click(function(){
        payload = {};
        var username = $("#username").val();
        var password = $("#password").val();
        payload.username = username;
        payload.password = password;

        $.ajax({
            url: "http://localhost:8082/user/login",
            type: 'POST',
            data : payload,
//            crossDomain : true,
            dataType : 'json',
            success: function (data) {
                console.log(data)
                window.location("Userprofile.html");
            },
            error:function(XMLHttpRequest, textStatus){
                console.log(XMLHttpRequest);  //XMLHttpRequest.responseText    XMLHttpRequest.status   XMLHttpRequest.readyState
                console.log(textStatus);
                alert("Something went wrong!");
            },
            complete:function(data){
                alert("Completed!")
            }


        })
    })


})