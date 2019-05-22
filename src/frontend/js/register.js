
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
          $.ajax({
              url: "http://18.191.27.125:8082/user/register",
              type: 'POST',
              data : payload,
              dataType : 'json',
              success: function (data) {
                  console.log(data);
                  window.location.href = "Login.html";
              }

          })
      }
