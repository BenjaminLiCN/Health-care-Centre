$(document).ready(function() {
    for(var i = 0;i < 3;i++){
        if(window.localStorage.name!="")
            $("#name"+i).html(window.localStorage.name);
    }
    var wrappedData = {};
    //wrappedData.dataType = "json";
    wrappedData.data = "";
    wrappedData.url = "http://18.191.27.125:8081/booking/professional/";
    wrappedData.type = "POST";
    wrappedData.crossDomain = true;
    $.ajax({/*
        url: "http://18.191.27.125:8082/booking",
        type: "POST",
        data : wrappedData,*/
        url: wrappedData.url,
        type: wrappedData.type,
        data : "",
        dataType: "json",
        crossDomain : true,
        success: function (data) {
            console.log(data);
            $.each(data, function(index, item){
                if(item.type == 'podiatrist'){
                    var divA = document.getElementById("tbody_Podiatrist");
                    $(divA).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name + "</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "Start Period" + "</th>"
                        +"<th>" + "End Period" + "</th>"
                        +"<th>" + "Book" + " Now" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_Poduatrist_scheduleDate' value='"+item.id+"'></tbody>"
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
                        url: wrappedData.url,
                        type: wrappedData.type,
                        data : wrappedData.data,
                        dataType: "json",
                        crossDomain : true,
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

                if(item.type == 'naturopath'){
                    var divnaturopath = document.getElementById("tbody_naturopath");
                    $(divnaturopath).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name + "</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "Start Period" + "</th>"
                        +"<th>" + "End Period" + "</th>"
                        +"<th>" + "Book" + "now" + "</th>"
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
                        url: wrappedData.url,
                        type: wrappedData.type,
                        data : wrappedData.data,
                        dataType: "json",
                        crossDomain : true,
                        success: function (data) {
                            $.each(data, function(index, item){
                                $(divnaturopath_schedule).append(
                                    "<tr>"
                                    +"<td>" + item.scheduleDate + "</td>"
                                    +"<td>" + item.periodStart + ":00" + "</td>"
                                    +"<td>" + item.periodEnd +  ":00" +"</td>"
                                    +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                    + "Book Now"
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

                if(item.type == 'chiropractor'){
                    var divchiropractor = document.getElementById("tbody_chiropractor");
                    $(divchiropractor).append(
                        "<div class='table_content_style'>"
                        +"<table class='table table-striped' >"
                        +"<div class='detail row'>" + "ID" + "<div class='detail_item_1'>" + item.id + "</div></div>"
                        +"<div class='detail row'>" + "Name" + "<div class='detail_item_2'>" + item.name + "</div></div>"
                        +"<div class='detail row'>" + "Per-hour"+ "  " + "Charge" + "<div class='detail_item_3'>" + item.charge + "</div></div>"

                        +"<thead><tr>"
                        +"<th>" + "ScheduleDate" + "</th>"
                        +"<th>" + "Start Period" + "</th>"
                        +"<th>" + "End Period" + "</th>"
                        +"<th>" + "Book" + "now" + "</th>"
                        +"</tr></thead>"
                        +"<tbody class='tbody_chiropractor_scheduleDate' value='"+item.id+"'></tbody>"
                        +"</table>"
                        +"</div>"
                    );

                    var professional_id=item.id
                    var baseUrl = 'http://18.191.27.125:8081/booking/professional/availabletime/';
                    var a = item.id;
                    var finalUrl = baseUrl + a;
                    var divchiropractor_schedule = $("tbody[value='"+item.id+"']")
                    var wrappedData = {};
                    wrappedData.dataType = "json";
                    wrappedData.data = "";
                    wrappedData.url = finalUrl;
                    wrappedData.type = "GET";
                    wrappedData.crossDomain = true;
                    $.ajax({
                        url: wrappedData.url,
                        type: wrappedData.type,
                        data : wrappedData.data,
                        dataType: "json",
                        crossDomain: true,
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

            $(document).on("click", ".submit_booking", function (){
                var booking = {
                    userId: parseInt(window.localStorage.id),
                    professionalId:professionalId,
                    scheduledDate:ScheduleDate,
                    scheduleStart:PeriodStart,
                    scheduleEnd:periodEnd,
                    description: $(".book_message").val()
                }
                console.log(booking)
                $.ajax({
                    url: "http://18.191.27.125:8081/booking/",
                    type: "POST",
                    data : booking,
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
    var wrappedData = {};
    wrappedData.dataType = "json";
    wrappedData.data = "";
    wrappedData.url = "http://18.191.27.125:8081/booking/user/"+window.localStorage.id;
    wrappedData.type = "GET";
    wrappedData.crossDomain = true;
    $.ajax({
        url: wrappedData.url,
        type: wrappedData.type,
        data : wrappedData.data,
        crossDomain: true,
        dataType: "json",
        success: function (data) {
            $.each(data, function(index, item){
                var divbooking_history = document.getElementById("booking_history");
                $(divbooking_history).append(
                    "<tr>"
                    +"<td>" + item.professionalDO.name + "</td>"
                    +"<td>" + item.professionalDO.charge + "</td>"
                    +"<td>" + item.scheduleDate + "</td>"
                    +"<td>" + item.start + ":00" + "</td>"
                    +"<td>" + item.end + ":00" +"</td>"
                    +"<td>" + item.description + "</td>"
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

    $(function () {
        $(document).on("click", ".cancel_booking", function (){


            var booking_id=$(this).val()
            var bookingUrl = 'http://18.191.27.125:8081/booking/';
            var finalbookingUrl = bookingUrl + booking_id;
            var wrappedData = {};
            wrappedData.dataType = "json";
            wrappedData.data = "";
            wrappedData.url = finalbookingUrl;
            wrappedData.type = "DELETE"
            wrappedData.crossDomain = true;
            $.ajax({
                url: wrappedData.url,
                type: wrappedData.type,
                data : wrappedData.data,
                dataType: "json",
                crossDomain : true,
                success: function (data) {
                    alert("Cancel Successfully");
                    window.location.reload();
                }
            })
        })
    })

    $(function(){
        $(document).on("click", ".log_out", function(){
            window.localStorage.clear();
            window.location.reload();
            window.location = 'http://18.191.27.125/html/Login.html'
        })
    })




})

function logOut(){
    window.localStorage.clear();
    window.location.reload();
}


