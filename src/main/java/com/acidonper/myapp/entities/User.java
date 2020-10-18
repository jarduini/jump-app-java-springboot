package com.acidonper.myapp.entities;

public class User  {
    public String firstName;
    public String lastName;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[firstName='%s', lastName='%s']",firstName, lastName);
    }

}

