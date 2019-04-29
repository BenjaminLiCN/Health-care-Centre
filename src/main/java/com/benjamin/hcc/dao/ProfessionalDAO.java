package com.benjamin.hcc.dao;

import com.benjamin.hcc.domain.ProfessionalDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 */
public interface ProfessionalDAO extends JpaRepository<ProfessionalDO,String> ,JpaSpecificationExecutor<ProfessionalDO>{


}
