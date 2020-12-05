package com.acidonper.myapp.web;

import com.acidonper.myapp.entities.Response;

import org.springframework.web.bind.annotation.*;


@RestController
public class RootController {

    @RequestMapping("/")
    public Response index() {
        System.out.println("Received GET /");

        // Generate Response
        Response response = new Response("/ - Greetings from Spring Boot!",200 );
        return response;
    }

    @RequestMapping("/home")
    public Response home() {
        System.out.println("Received GET /home");

        // Generate Response
        Response response = new Response("/home - Greetings from Spring Boot!",200 );
        return response;
    }
}