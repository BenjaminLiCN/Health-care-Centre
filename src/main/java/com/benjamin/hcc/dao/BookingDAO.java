package com.benjamin.hcc.dao;

import com.benjamin.hcc.domain.BookingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/28/9 14:03
 */
public interface BookingDAO extends JpaRepository<BookingDO,String> ,JpaSpecificationExecutor<BookingDO>{
}
