package me.williandrade.mapper;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import me.williandrade.dto.UserDTO;

import me.williandrade.entity.User;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-26T01:26:47-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class UserMapperImpl implements UserMapper {

    @Override

    public UserDTO userToUserDTO(User user) {

        if ( user == null ) {

            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );

        userDTO.setName( user.getName() );

        userDTO.setEmail( user.getEmail() );

        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override

    public User userDTOToUser(UserDTO userDTO) {

        if ( userDTO == null ) {

            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );

        user.setName( userDTO.getName() );

        user.setEmail( userDTO.getEmail() );

        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override

    public Set<UserDTO> usersToUserDTOs(Set<User> users) {

        if ( users == null ) {

            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>();

        for ( User user : users ) {

            set.add( userToUserDTO( user ) );
        }

        return set;
    }

    @Override

    public Set<User> userDTOsToUsers(Set<UserDTO> userDTOs) {

        if ( userDTOs == null ) {

            return null;
        }

        Set<User> set = new HashSet<User>();

        for ( UserDTO userDTO : userDTOs ) {

            set.add( userDTOToUser( userDTO ) );
        }

        return set;
    }
}

