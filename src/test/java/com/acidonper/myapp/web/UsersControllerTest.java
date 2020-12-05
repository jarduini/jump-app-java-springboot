package com.acidonper.myapp.web;


import com.acidonper.myapp.dtos.JumpDto;
import com.acidonper.myapp.dtos.UserDto;
import com.acidonper.myapp.entities.User;
import com.acidonper.myapp.entities.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repository;

    @AfterEach
    void run(){
        repository.deleteAll();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getUsers() throws Exception {
        createLocalUser();
        mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"message\":\"[User[id='0000000X', firstName='test', lastName='01']]\",\"code\":200}")));
    }

    @Test
    public void getSpecificUsersOk() throws Exception {
        createLocalUser();
        mvc.perform(MockMvcRequestBuilders.get("/users/0000000X").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"firstName\":\"test\",\"lastName\":\"01\",\"id\":\"0000000X\"}")));
    }

    @Test
    public void getSpecificUsersError() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/0000000X").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void postUserExists() throws Exception {
        createLocalUser();
        UserDto userDto = new UserDto("0000000X","test", "01");
        mvc.perform(MockMvcRequestBuilders.post("/users")
                .content(asJsonString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("User test exists")));
    }

    private void createLocalUser() {
        User user = new User("0000000X","test", "01");
        repository.save(user);
    }

    @Test
    public void postUser() throws Exception {
        UserDto userDto = new UserDto("0000000X","test", "01");
        mvc.perform(MockMvcRequestBuilders.post("/users")
                .content(asJsonString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("User test created")));
    }
}