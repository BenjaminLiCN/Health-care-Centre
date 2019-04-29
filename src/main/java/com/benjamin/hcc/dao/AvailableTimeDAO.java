package com.benjamin.hcc.dao;

import com.benjamin.hcc.domain.AvailableTimeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 */
public interface AvailableTimeDAO extends JpaRepository<AvailableTimeDO,String> ,JpaSpecificationExecutor<AvailableTimeDO>{


}
