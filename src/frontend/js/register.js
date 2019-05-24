
     /**
   * 将form里面的内容序列化成json
   * 相同的checkbox用分号拼接起来
   * @param {dom} 指定的选择器
   * @param {obj} 需要拼接在后面的json对象
   * @method serializeJson
   * */

  function submitForm(){
          var payload = {};
          var t = $('#form').serializeArray();
          $.each(t, function() {
            payload[this.name] = this.value;
          });
          data = JSON.stringify(payload);
          event.preventDefault();
          $.ajax({
              url: "http://18.191.27.125:8082/user/register",
              type: 'POST',
              data : payload,
              dataType : 'json',
              crossDomain: true,
              success: function (data) {
                  console.log(data);
                  window.location.href = "Login.html";
              },
              error: function (XMLHttpRequest) {

                  if(XMLHttpRequest.status==500)
                    alert("Internal server error! 500");
                  else if(XMLHttpRequest.status==200){
                    window.location.href = "Login.html";
                  }else{
                    alert("Internal server error! else");
                    console.log(XMLHttpRequest.responseText);
                  }

              }
          })
  }