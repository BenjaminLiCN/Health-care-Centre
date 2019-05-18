package com.benjamin.hcc.dao;

import com.benjamin.hcc.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/28/9 14:03
 */
public interface UserDAO extends JpaRepository<UserDO,Long> ,JpaSpecificationExecutor<UserDO>{
}
