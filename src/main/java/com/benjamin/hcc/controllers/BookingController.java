package com.benjamin.hcc.controllers;

import com.benjamin.hcc.dto.BookingDTO;
import com.benjamin.hcc.service.BookingService;
import com.benjamin.hcc.utils.WebResults;
import com.benjamin.hcc.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther Benjamin(Jingyi Li) Li
 * @Email jili@student.unimelb.edu.au
 * @ID 961543
 * @Date 2019-04-24 18:37
 */
@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("create")
    public WebResults create(@RequestBody BookingDTO bookingDTO) {
        bookingService.create(bookingDTO);
        return WebUtils.success();
    }
    @PostMapping("cancel")
    public WebResults cancel(@RequestBody BookingDTO bookingDTO) {
        bookingService.cancel(bookingDTO);
        return WebUtils.success();
    }
    @PostMapping("confirm")
    public WebResults confirm(@RequestBody BookingDTO bookingDTO) {
        bookingService.confirm(bookingDTO);
        return WebUtils.success();
    }
}
