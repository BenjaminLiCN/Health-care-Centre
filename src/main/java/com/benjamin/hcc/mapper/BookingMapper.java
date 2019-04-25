package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.BookingDO;
import com.benjamin.hcc.dto.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author xuwang <121894598@qq.com>
 * @date 2018/5/22 21:15
 */
@Mapper(componentModel = "spring")
public interface BookingMapper {
    /**
     * DO to DTO
     * @param bookingDO
     * @return
     */
    @Mappings({
            @Mapping(source = "professional",target = "professional"),
            @Mapping(source = "time",target = "time"),
            @Mapping(source = "duration",target = "duration"),
            @Mapping(source = "message",target = "message"),
            @Mapping(source = "confirm",target = "confirm")
    })
    public BookingDTO from(BookingDO bookingDO);

    /**
     * DTO to DO
     * @param bookingDTO
     * @return
     */
    public BookingDO to(BookingDTO bookingDTO);

    /**
     * List<DO> to List<DTO>
     * @param bookingDOS
     * @return
     */
    public List<BookingDTO> from(List<BookingDO> bookingDOS);

    /**
     * List<DTO> to List<DO>
     * @param bookingDTOS
     * @return
     */
    public List<BookingDO> to(List<BookingDTO> bookingDTOS);

}