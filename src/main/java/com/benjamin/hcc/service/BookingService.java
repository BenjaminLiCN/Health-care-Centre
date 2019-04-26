package com.benjamin.hcc.service;

import com.benjamin.hcc.dto.BookingDTO;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/8/9 14:04
 */
@org.springframework.stereotype.Service
public interface BookingService {


    /**
     * Create a booking request
     * @return
     */
    void create(BookingDTO bookingDTO);

    /**
     * Confirm the request
     * @return
     */
    void confirm(BookingDTO bookingDTO);

    /**
     * Cancel the request
     * @return
     */
    void cancel(BookingDTO bookingDTO);

}
