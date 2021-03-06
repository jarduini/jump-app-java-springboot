package com.acidonper.myapp.web;

import com.acidonper.myapp.dtos.UserDto;
import com.acidonper.myapp.entities.Response;
import com.acidonper.myapp.entities.User;
import com.acidonper.myapp.entities.repositories.UserRepository;
import com.acidonper.myapp.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    private final UserRepository repository;
    UsersController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    Response run() {
        System.out.println("Received GET /users");

        // Obtain all users
        List<UserDto> usersDto  = new ArrayList<UserDto>();
        List<User> users = repository.findAll();

        for(User user : users) {
            UserDto userDto = UserMapper.INSTANCE.userToUserDTO(user);
            usersDto.add(userDto);
        }

        Response response = new Response(usersDto.toString(),200 );
        return response;
    }

    @GetMapping("/users/{id}")
    UserDto run(@PathVariable String id) throws Exception {
        System.out.println("Received GET /users");

        // Obtain user received in call parameters
        List<UserDto> usersDto  = new ArrayList<UserDto>();
        List<User> users = repository.findByDni(id);

        try{
            UserDto userDto = UserMapper.INSTANCE.userToUserDTO(users.get(0));
            return(userDto);
        }
        catch(Exception handlerException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    String run(@Valid @RequestBody UserDto newUser) {
        System.out.println("Received POST /users");

        // Map object received
        User user = UserMapper.INSTANCE.userDTOtoUser(newUser);

        // Obtain User with DNI in the database
        List<User> usersCreated = repository.findByDni(user.dni);

        // Save creation status
        String reqStatus = null;

        if(usersCreated.isEmpty()) {
            repository.save(user);
            reqStatus = "created";
        }
        else {
            reqStatus = "exists";
        }
        return "User " + user.firstName + " " + reqStatus;
    }
}