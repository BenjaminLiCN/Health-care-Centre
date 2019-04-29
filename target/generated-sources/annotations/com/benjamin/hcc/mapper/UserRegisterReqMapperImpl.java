package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-29T18:21:43+1000",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190415-0656, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserRegisterReqMapperImpl implements UserRegisterReqMapper {

    @Override
    public UserRegisterReqDTO from(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserRegisterReqDTO userRegisterReqDTO = new UserRegisterReqDTO();

        userRegisterReqDTO.setNumber( userDO.getNumber() );
        userRegisterReqDTO.setPassword( userDO.getPassword() );
        userRegisterReqDTO.setGender( userDO.getGender() );
        userRegisterReqDTO.setId( userDO.getId() );
        userRegisterReqDTO.setEmail( userDO.getEmail() );
        userRegisterReqDTO.setUsername( userDO.getUsername() );
        userRegisterReqDTO.setHomeAddress( userDO.getHomeAddress() );
        userRegisterReqDTO.setCreateTime( userDO.getCreateTime() );
        userRegisterReqDTO.setDeleted( userDO.getDeleted() );
        userRegisterReqDTO.setRemark( userDO.getRemark() );

        return userRegisterReqDTO;
    }

    @Override
    public UserDO to(UserRegisterReqDTO userRegisterReqDTO) {
        if ( userRegisterReqDTO == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setCreateTime( userRegisterReqDTO.getCreateTime() );
        userDO.setDeleted( userRegisterReqDTO.getDeleted() );
        userDO.setId( userRegisterReqDTO.getId() );
        userDO.setRemark( userRegisterReqDTO.getRemark() );
        userDO.setEmail( userRegisterReqDTO.getEmail() );
        userDO.setGender( userRegisterReqDTO.getGender() );
        userDO.setHomeAddress( userRegisterReqDTO.getHomeAddress() );
        userDO.setNumber( userRegisterReqDTO.getNumber() );
        userDO.setPassword( userRegisterReqDTO.getPassword() );
        userDO.setUsername( userRegisterReqDTO.getUsername() );

        return userDO;
    }

    @Override
    public List<UserRegisterReqDTO> from(List<UserDO> userDOS) {
        if ( userDOS == null ) {
            return null;
        }

        List<UserRegisterReqDTO> list = new ArrayList<UserRegisterReqDTO>( userDOS.size() );
        for ( UserDO userDO : userDOS ) {
            list.add( from( userDO ) );
        }

        return list;
    }

    @Override
    public List<UserDO> to(List<UserRegisterReqDTO> userRegisterReqDTOS) {
        if ( userRegisterReqDTOS == null ) {
            return null;
        }

        List<UserDO> list = new ArrayList<UserDO>( userRegisterReqDTOS.size() );
        for ( UserRegisterReqDTO userRegisterReqDTO : userRegisterReqDTOS ) {
            list.add( to( userRegisterReqDTO ) );
        }

        return list;
    }
}
