package com.acidonper.myapp.dtos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserDtoTest {

    @Test
    public void getUserDto() throws Exception {
        UserDto userDto = new UserDto("pepe", "gimenez");
        assertNotNull(userDto);
        assertThat(userDto.toString()).isEqualTo("User[firstName='pepe', lastName='gimenez']");
    }
}