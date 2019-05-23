$(document).ready(function() {
    $.ajax({
        url: "http://xfchen.tech:8081/booking/professional/",
        type: 'POST',
        data : '',
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
                        +" <button type='button' id='"+item.id+"' class='btn btn-success delete_button'  data-toggle='modal' data-target='#myModal'>"
                        + "Delete"+"</button>"+"</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "PeriodStart" + "</th>"
                        +"<th>" + "PeriodEnd" + "</th>"
                        +"<th>" + "Book" + "Now" + "</th>"
                        +"<th>" + "Delete" + "It" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_Poduatrist_scheduleDate' value='"+item.id+"'></tbody>" //创建一个BODY
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divB = $("tbody[value='"+item.id+"']")
                    $.ajax({
                        url: finalUrl,
                        type: 'GET',
                        data : '',
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divB).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate + "</td>"
                                    +"<td>" + item.periodStart+ ":00" + "</td>"
                                    +"<td>" + item.periodEnd + ":00" + "</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Book Now"
                                    +"</button>" + "</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success delete_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Delete It"  //QUESTION1 id ?
                                    +"</button>" + "</td>"
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
                        +"<th>" + "Book" + "Now" + "</th>"
                        +"<th>" + "Delete" + "It" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_naturopath_scheduleDate'  value='"+item.id+"'></tbody>"
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divnaturopath_schedule = $("tbody[value='"+item.id+"']")
                    $.ajax({
                        url: finalUrl,
                        type: 'GET',
                        data : '',
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divnaturopath_schedule).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate + "</td>"
                                    +"<td>" + item.periodStart + ":00" + "</td>"
                                    +"<td>" + item.periodEnd +  ":00" +"</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Book Now"
                                    +"</button>" +"</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success delete_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Delete It"
                                    +"</button>" + "</td>"
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
                        +"<th>" + "Book" + "now" + "</th>"
                        +"<th>" + "Delete" + "It" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_chiropractor_scheduleDate' value='"+item.id+"'></tbody>"
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divchiropractor_schedule = $("tbody[value='"+item.id+"']")
                    $.ajax({
                        url: finalUrl,
                        type: 'GET',
                        data : '',
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divchiropractor_schedule).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate +  "</td>"
                                    +"<td>" + item.periodStart + ":00" + "</td>"
                                    +"<td>" + item.periodEnd + ":00" +"</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Book Now"
                                    +"</button>" + "</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success delete_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Delete It"
                                    +"</button>" + "</td>"
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
                $.ajax({
                    url: 'http://xfchen.tech:8081/booking/',
                    type: 'POST',
                    data : {
                        "userId":1,
                        "professionalId":professionalId,
                        "scheduledDate":ScheduleDate,
                        "scheduleStart": PeriodStart,
                        "scheduleEnd":periodEnd,
                        "description": $(".book_message").val()
                    },
                    dataType : 'json',
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

            var booking_id=$(this).val()
            var bookingUrl = 'http://xfchen.tech:8081/booking/';
            var finalbookingUrl = bookingUrl + booking_id;
            $.ajax({
                url: finalbookingUrl,
                type: 'DELETE',
                data : '',
                dataType : 'json',
                crossDomain : true,
                success: function (data) {
                    alert("Cancel Successfully");
                    window.location.reload();
                }

            })

        })



    })

    $(function () {
        $(document).on("click", "#singlebutton", function (){
            var options = $("#choose_type option:selected");
            console.log(options.val());
            console.log($("#charge1").val());
            $.ajax({
                url: 'http://18.191.27.125:8082/booking',
                type: 'POST',
                data : {
                    "type":options.val(),
                    "name": $("#textinput1").val(),
                    "email":$("#textinput2").val(),
                    "charge":$("#charge1").val()
                    },
                    dataType : 'json',
                    crossDomain : true,
                    success: function (data) {
                        alert(" Add successfully");
                        window.location.reload();
                    }

                })
        })



    })




})


