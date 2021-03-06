package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Benjamin Li li.benjamincn@gmail.com
 * @date 2018/5/22 21:15
 */
@Mapper(componentModel = "spring")
public interface UserRegisterReqMapper {
    /**
     * UserDO to UserRegisterReqDTO
     * @param userDO
     * @return
     */
    @Mappings({
    })
    public UserRegisterReqDTO from(UserDO userDO);

    /**
     * UserRegisterReqDTO to UserDO
     * @param userRegisterReqDTO
     * @return
     */
    @Mappings({
            @Mapping(source = "isAdmin",target = "isAdmin")
    })
    public UserDO to(UserRegisterReqDTO userRegisterReqDTO);

    /**
     * List<UserDO> to List<UserRegisterReqDTO>
     * @param userDOS
     * @return
     */
    public List<UserRegisterReqDTO> from(List<UserDO> userDOS);

    /**
     * List<userRegisterReqDTOS> to List<UserDO>
     * @param userRegisterReqDTOS
     * @return
     */
    public List<UserDO> to(List<UserRegisterReqDTO> userRegisterReqDTOS);

}
