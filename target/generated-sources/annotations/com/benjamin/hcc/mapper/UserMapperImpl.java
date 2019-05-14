package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-14T22:24:20+1000",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190430-1056, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO from(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setPassword( userDO.getPassword() );
        userDTO.setUsername( userDO.getUsername() );

        return userDTO;
    }

    @Override
    public UserDO to(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setPassword( userDTO.getPassword() );
        userDO.setUsername( userDTO.getUsername() );

        return userDO;
    }

    @Override
    public List<UserDTO> from(List<UserDO> userDOS) {
        if ( userDOS == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userDOS.size() );
        for ( UserDO userDO : userDOS ) {
            list.add( from( userDO ) );
        }

        return list;
    }

    @Override
    public List<UserDO> to(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<UserDO> list = new ArrayList<UserDO>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( to( userDTO ) );
        }

        return list;
    }
}
