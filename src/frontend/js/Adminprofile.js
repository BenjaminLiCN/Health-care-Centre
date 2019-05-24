$(document).ready(function() {
    var wrappedData = {};
    wrappedData.dataType = "json";
    wrappedData.data = "";
    wrappedData.url = "http://18.191.27.125:8081/booking/professional/";
    wrappedData.type = "GET";
    wrappedData.crossDomain = true;
    $.ajax({
        url: "http://18.191.27.125:8082/booking/",
        type: 'POST',
        data : JSON.stringify(wrappedData),
        crossDomain : true,
        success: function (data) {
            $(".tbody_Podiatrist").empty();
            $(".tbody_naturopath").empty();
            $(".tbody_chiropractor").empty();
            $.each(data, function(index, item){
                if(item.type == 'Podiatrist'){
                    var divA = document.getElementById("tbody_Podiatrist");
                    $(divA).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name +"</div>"
                        +"<div class='detail_item_4'>"
                        +"</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "PeriodStart" + "</th>"
                        +"<th>" + "PeriodEnd" + "</th>"
                        +"<th>" + "</th>"
                        +"<th>" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_Poduatrist_scheduleDate' value='"+item.id+"'></tbody>" //创建一个BODY
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://18.191.27.125:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divB = $("tbody[value='"+item.id+"']")
                    var wrappedData = {};
                    wrappedData.dataType = "json";
                    wrappedData.data = "";
                    wrappedData.url = finalUrl;
                    wrappedData.type = "GET";
                    wrappedData.crossDomain = true;
                    $.ajax({
                        url: "http://18.191.27.125:8082/booking",
                        type: 'POST',
                        data : JSON.stringify(wrappedData),
                        crossDomain : true,
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divB).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate + "</td>"
                                    +"<td>" + item.periodStart+ ":00" + "</td>"
                                    +"<td>" + item.periodEnd + ":00" + "</td>"
                                    +"<td>" + "</td>"
                                    +"<td>" + "</td>"
                                    +"</tr>"

                                );
                                $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                $('button[id="'+item.id+'"]').data("professional_id",professional_id)

                                // QUESTION2 以上的作用

                                if(item.isBooked  == 1){
                                    $('button[id="'+item.id+'"]').prop('disabled', true);
                                }
                            })

                        }

                    })
                }

                if(item.type == 'Naturopath'){
                    var divnaturopath = document.getElementById("tbody_naturopath");
                    $(divnaturopath).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name + "</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "PeriodStart" + "</th>"
                        +"<th>" + "PeriodEnd" + "</th>"
                        +"<th>" + "</th>"
                        +"<th>" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_naturopath_scheduleDate'  value='"+item.id+"'></tbody>"
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://18.191.27.125:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divnaturopath_schedule = $("tbody[value='"+item.id+"']")
                    var wrappedData = {};
                    wrappedData.dataType = "json";
                    wrappedData.data = "";
                    wrappedData.url = finalUrl;
                    wrappedData.type = "GET";
                    wrappedData.crossDomain = true;
                    $.ajax({
                        url: "http://18.191.27.125:8082/booking",
                        type: 'POST',
                        data : JSON.stringify(wrappedData),
                        crossDomain : true,
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divnaturopath_schedule).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate + "</td>"
                                    +"<td>" + item.periodStart + ":00" + "</td>"
                                    +"<td>" + item.periodEnd +  ":00" +"</td>"
                                    +"<td>" + "</td>"
                                    +"<td>" + "</td>"
                                    +"</tr>"

                                );
                                $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                $('button[id="'+item.id+'"]').data("professional_id",professional_id)


                                if(item.isBooked  == 1){
                                    $('button[id="'+item.id+'"]').prop('disabled', true);
                                }
                            })

                        }

                    })
                }

                if(item.type == 'Chiropractor'){
                    var divchiropractor = document.getElementById("tbody_chiropractor");
                    $(divchiropractor).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name + "</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "PeriodStart" + "</th>"
                        +"<th>" + "PeriodEnd" + "</th>"
                        +"<th>" + "</th>"
                        +"<th>" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_chiropractor_scheduleDate' value='"+item.id+"'></tbody>"
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://18.191.27.125:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divchiropractor_schedule = $("tbody[value='"+item.id+"']");
                    var wrappedData = {};
                    wrappedData.dataType = "json";
                    wrappedData.data = "";
                    wrappedData.url = finalUrl;
                    wrappedData.type = "GET";
                    wrappedData.crossDomain = true;
                    $.ajax({
                        url: "http://18.191.27.125:8082/booking",
                        type: 'POST',
                        data : JSON.stringify(wrappedData),
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divchiropractor_schedule).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate +  "</td>"
                                    +"<td>" + item.periodStart + ":00" + "</td>"
                                    +"<td>" + item.periodEnd + ":00" +"</td>"
                                    +"<td>" + "</td>"
                                    +"<td>" + "</td>"
                                    +"</tr>"

                                );
                                $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                $('button[id="'+item.id+'"]').data("professional_id",professional_id)


                                if(item.isBooked  == 1){
                                    $('button[id="'+item.id+'"]').prop('disabled', true);
                                }
                            })

                        }

                    })
                }




            })
        }

    })

    $(function () {
        $(document).on("click", ".book_button", function (){
            var ScheduleDate =  $(this).data().scheduleDate;
            var PeriodStart =  $(this).data().PeriodStart;
            var periodEnd =  $(this).data().PeriodEnd;
            var professionalId =  $(this).data().professional_id;
            $(document).on("click", ".submit_booking", function (){  //用来激活弹窗
                var booking = {
                    "userId":window.localStorage.id,
                    "professionalId":professionalId,
                    "scheduledDate":ScheduleDate,
                    "scheduleStart": PeriodStart,
                    "scheduleEnd":periodEnd,
                    "description": $(".book_message").val()
                };
                var wrappedData = {};
                wrappedData.dataType = "json";
                wrappedData.data = booking;
                wrappedData.url = "http://18.191.27.125:8081/booking";
                wrappedData.type = "POST";
                wrappedData.crossDomain = true;

                $.ajax({
                    url: 'http://18.191.27.125:8082/booking',
                    type: 'POST',
                    data : JSON.stringify(wrappedData),
                    crossDomain : true,
                    success: function (data) {
                        alert(" Booking successfully");
                        window.location.reload();
                    }

                })
            })
        })



    })

    $(function () {
        $(document).on("click", ".cancel_booking", function (){

            var booking_id=$(this).val();
            console.log(booking_id.val());
            var bookingUrl = 'http://18.191.27.125:8081/booking/';
            var finalbookingUrl = bookingUrl + booking_id;


            var wrappedData = {};
            wrappedData.dataType = "json";
            wrappedData.data = "";
            wrappedData.url = finalbookingUrl;
            wrappedData.type = "DELETE";
            wrappedData.crossDomain = true;
            $.ajax({
                url: "http://18.191.27.125:8082/booking/",
                type: 'POST',
                data : JSON.stringify(wrappedData),
                crossDomain : true,
                success: function (data) {
                    alert("Cancel Successfully");
                    window.location.reload();
                }

            })

        })



    })

    $(function () {
        $(document).on("click", "#addProfessional", function (){
            var options = $("#choose_type option:selected");
            var pro = {
                "charge":$("#charge1").val(),
                "email":$("#textinput2").val(),
                "name": $("#textinput1").val(),
                "number":"",
                "type":options.val()
            }
            var wrappedData = {};
            wrappedData.dataType = "json";
            wrappedData.data = pro;
            wrappedData.url = "http://18.191.27.125:8081/booking/professional";
            wrappedData.type = "POST";
            wrappedData.crossDomain = true;
            $.ajax({
                url: 'http://18.191.27.125:8082/booking',
                type: 'POST',
                data : JSON.stringify(wrappedData),
                crossDomain : true,
                success: function (data) {
                    alert(" Add successfully");
                    window.location.reload();
                }

            })
        })



    })
    var wrappedData = {};
    wrappedData.dataType = "json";
    wrappedData.data = "";
    wrappedData.url = "http://18.191.27.125:8081/booking";
    wrappedData.type = "GET";
    wrappedData.crossDomain = true;
    $.ajax({
        url: 'http://18.191.27.125:8082/booking',
        type: 'POST',
        data : JSON.stringify(wrappedData),
        crossDomain : true,
        success: function (data) {
            $.each(data, function(index, item){
                console.log(item);
                var divbooking_history = document.getElementById("view_booking");
                $(divbooking_history).append(
                    "<tr>"
                    +"<td>" + item.professionalDO.name + "</td>"
                    +"<td>" + item.professionalDO.charge + "</td>"
                    +"<td>" + item.scheduleDate + "</td>"
                    +"<td>" + item.start + ":00" + "</td>"
                    +"<td>" + item.end + ":00" +"</td>"
                    +"<td>" + item.description +"</td>"
                    +"<td>" + item.isCancelled + "</td>"
                    +"<td>" + "<button type='button'  value='"+item.id+"' class='cancel_booking' class='btn btn-success'>" + 'Cancel Now'+ '</button>'
                    + "</td>"
                    +"</tr>"

                );
                if(item.isCancelled  == 1){
                    $('button[value="'+item.id+'"]').prop('disabled', true);
                }

            })

        }

    })




})


