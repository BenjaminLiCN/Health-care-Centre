package com.benjamin.hcc.service.impl;

import com.benjamin.hcc.dao.BookingDAO;
import com.benjamin.hcc.domain.BookingDO;
import com.benjamin.hcc.dto.BookingDTO;
import com.benjamin.hcc.exceptions.hccException;
import com.benjamin.hcc.mapper.BookingMapper;
import com.benjamin.hcc.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.Path;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/30下午7:19
 */
@org.springframework.stereotype.Service
public class BookingServiceImpl extends BaseServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDao;
    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public void create(BookingDTO bookingDTO) {
        if (bookingDTO.getProfessional().equals("") ||bookingDTO.getDuration().equals("")|| bookingDTO.getTime().equals("")) {
            throw new hccException("Register information cannot be null!");
        } else {
            //查找账号是否存在
            long count = bookingDao.count((root, query, cb) -> {
                Path<String> professionalPath = root.get("professional");
                return cb.equal(professionalPath, bookingDTO.getProfessional());
            });
            if (count>0){
                BookingDO bookingDO = bookingMapper.to(bookingDTO);
                bookingDao.save(bookingDO);
            } else {
                throw new hccException("There's no such professional!");
            }
        }
    }
    @Override
    public void confirm(BookingDTO bookingDTO) {
        bookingDTO.setConfirm(1);
        BookingDO bookingDO = bookingMapper.to(bookingDTO);
        bookingDao.save(bookingDO);
    }

    @Override
    public void cancel(BookingDTO bookingDTO) {
        bookingDTO.setConfirm(0);
        BookingDO bookingDO = bookingMapper.to(bookingDTO);
        bookingDao.save(bookingDO);
    }



}