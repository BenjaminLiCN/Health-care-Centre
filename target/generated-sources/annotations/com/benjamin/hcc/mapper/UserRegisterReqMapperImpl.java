package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-25T14:28:16+1000",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190513-1620, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class UserRegisterReqMapperImpl implements UserRegisterReqMapper {

    @Override
    public UserRegisterReqDTO from(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserRegisterReqDTO userRegisterReqDTO = new UserRegisterReqDTO();

        userRegisterReqDTO.setIsAdmin( userDO.getIsAdmin() );
        userRegisterReqDTO.setHomeAddress( userDO.getHomeAddress() );
        userRegisterReqDTO.setGender( userDO.getGender() );
        userRegisterReqDTO.setNumber( userDO.getNumber() );
        userRegisterReqDTO.setEmail( userDO.getEmail() );
        userRegisterReqDTO.setUsername( userDO.getUsername() );
        userRegisterReqDTO.setPassword( userDO.getPassword() );

        return userRegisterReqDTO;
    }

    @Override
    public UserDO to(UserRegisterReqDTO userRegisterReqDTO) {
        if ( userRegisterReqDTO == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setIsAdmin( userRegisterReqDTO.getIsAdmin() );
        userDO.setHomeAddress( userRegisterReqDTO.getHomeAddress() );
        userDO.setUsername( userRegisterReqDTO.getUsername() );
        userDO.setPassword( userRegisterReqDTO.getPassword() );
        userDO.setEmail( userRegisterReqDTO.getEmail() );
        userDO.setGender( userRegisterReqDTO.getGender() );
        userDO.setNumber( userRegisterReqDTO.getNumber() );

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
