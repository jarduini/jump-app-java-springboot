package com.acidonper.myapp.mappers;

import com.acidonper.myapp.dtos.UserDto;
import com.acidonper.myapp.entities.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-19T00:05:15+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_265 (Red Hat, Inc)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;

        firstName = entity.firstName;
        lastName = entity.lastName;

        UserDto userDto = new UserDto( firstName, lastName );

        return userDto;
    }

    @Override
    public User userDTOtoUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.firstName = dto.firstName;
        user.lastName = dto.lastName;

        return user;
    }
}
