package com.acidonper.myapp.dtos;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    public String firstName;

    @NotEmpty
    public String lastName;

    public UserDto() {
        super();
    }

    public UserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[firstName='%s', lastName='%s']", firstName, lastName);
    }
}
