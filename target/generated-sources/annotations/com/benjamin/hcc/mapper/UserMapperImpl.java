package com.benjamin.hcc.mapper;

import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-25T14:28:17+1000",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190513-1620, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO from(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername( userDO.getUsername() );
        userDTO.setEmail( userDO.getEmail() );
        userDTO.setPassword( userDO.getPassword() );

        return userDTO;
    }

    @Override
    public UserDO to(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setUsername( userDTO.getUsername() );
        userDO.setPassword( userDTO.getPassword() );
        userDO.setEmail( userDTO.getEmail() );

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
