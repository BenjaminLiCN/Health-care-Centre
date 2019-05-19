$(document).ready(function() {
    $.ajax({
        url: "http://xfchen.tech:8081/booking/professional/",
        type: 'POST',
        data : '',
        success: function (data) {
                $.each(data, function(index, item){
                    if(item.type == 'testType'){
                        var divA = document.getElementById("tbody_Podiatrist");
                        $(divA).append(
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
                            +"</tr></thead>"
                            +"<tbody id='tbody_Poduatrist_scheduleDate'></tbody>"
                            +"</table>"
                            +"</div>"
                        );

                        var professional_id=item.id
                        var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                        var a = item.id;
                        var finalUrl = baseUrl + a;
                        $.ajax({
                            url: finalUrl,
                            type: 'GET',
                            data : '',
                            success: function (data) {
                                $.each(data, function(index, item){
                                    var divB = document.getElementById("tbody_Poduatrist_scheduleDate");
                                    $(divB).append(
                                        "<tr>"
                                        +"<td>" + item.scheduleDate + "</td>"
                                        +"<td>" + item.periodStart + "</td>"
                                        +"<td>" + item.periodEnd + "</td>"
                                        +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                        + "Book Now"
                                        +"</button>" + "</td>"
                                        +"</tr>"

                                    );
                                    $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                    $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                    $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                    $('button[id="'+item.id+'"]').data("professional_id",professional_id)


                                    /*if(item.isBooked  == 1){
                                        $('button[id="'+item.id+'"]').prop('disabled', true);
                                    }*/
                                })

                            }

                        })
                    }

                    if(item.type == 'testType'){
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
                            +"<th>" + "Book" + "now" + "</th>"
                            +"</tr></thead>"
                            +"<tbody id='tbody_naturopath_scheduleDate'></tbody>"
                            +"</table>"
                            +"</div>"
                        );

                        var professional_id=item.id
                        var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                        var a = item.id;
                        var finalUrl = baseUrl + a;
                        $.ajax({
                            url: finalUrl,
                            type: 'GET',
                            data : '',
                            success: function (data) {
                                $.each(data, function(index, item){
                                    var divnaturopath_schedule = document.getElementById("tbody_naturopath_scheduleDate");
                                    $(divnaturopath_schedule).append(
                                        "<tr>"
                                        +"<td>" + item.scheduleDate + "</td>"
                                        +"<td>" + item.periodStart + "</td>"
                                        +"<td>" + item.periodEnd + "</td>"
                                        +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                        + "Book Now"
                                        +"</button>" + "</td>"
                                        +"</tr>"

                                    );
                                    $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                    $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                    $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                    $('button[id="'+item.id+'"]').data("professional_id",professional_id)


                                    /*if(item.isBooked  == 1){
                                        $('button[id="'+item.id+'"]').prop('disabled', true);
                                    }*/
                                })

                            }

                        })
                    }

                    if(item.type == 'testType'){
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
                            +"</tr></thead>"
                            +"<tbody id='tbody_chiropractor_scheduleDate'></tbody>"
                            +"</table>"
                            +"</div>"
                        );

                        var professional_id=item.id
                        var baseUrl = 'http://xfchen.tech:8081/booking/professional/availabletime/';
                        var a = item.id;
                        var finalUrl = baseUrl + a;
                        $.ajax({
                            url: finalUrl,
                            type: 'GET',
                            data : '',
                            success: function (data) {
                                $.each(data, function(index, item){
                                    var divchiropractor_schedule = document.getElementById("tbody_chiropractor_scheduleDate");
                                    $(divchiropractor_schedule).append(
                                        "<tr>"
                                        +"<td>" + item.scheduleDate + "</td>"
                                        +"<td>" + item.periodStart + "</td>"
                                        +"<td>" + item.periodEnd + "</td>"
                                        +"<td>" + " <button type='button' id='"+item.id+"' class='btn btn-success book_button'  data-toggle='modal' data-target='#myModal'>"
                                        + "Book Now"
                                        +"</button>" + "</td>"
                                        +"</tr>"

                                    );
                                    $('button[id="'+item.id+'"]').data("scheduleDate",item.scheduleDate)
                                    $('button[id="'+item.id+'"]').data("PeriodStart",item.periodStart)
                                    $('button[id="'+item.id+'"]').data("PeriodEnd",item.periodEnd)
                                    $('button[id="'+item.id+'"]').data("professional_id",professional_id)


                                    /*if(item.isBooked  == 1){
                                        $('button[id="'+item.id+'"]').prop('disabled', true);
                                    }*/
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

    $.ajax({
        url: 'http://xfchen.tech:8081/booking/user/1',
        type: 'GET',
        data : '',
        success: function (data) {
            $.each(data, function(index, item){
                var divbooking_history = document.getElementById("booking_history");
                $(divbooking_history).append(
                    "<tr>"
                    +"<td>" + item.professionalDO.name + "</td>"
                    +"<td>" + item.professionalDO.charge + "</td>"
                    +"<td>" + item.scheduleDate + "</td>"
                    +"<td>" + item.start + "</td>"
                    +"<td>" + item.end + "</td>"
                    +"<td>" + item.description + "</td>"
                    +"<td>" + "<button type='button' class='cancel_booking' class='btn btn-success'  data-dismiss='modal'>" + 'Cancel Now'+ '</button>'
                    + "</td>"
                    +"</tr>"

                );



                /*if(item.isBooked  == 1){
                    $('button[id="'+item.id+'"]').prop('disabled', true);
                }*/

            })

        }

    })




})


