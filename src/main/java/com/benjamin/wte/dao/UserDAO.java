package com.benjamin.wte.dao;

import com.benjamin.wte.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/28/9 14:03
 */
public interface UserDAO extends JpaRepository<UserDO,String> ,JpaSpecificationExecutor<UserDO>{
}
