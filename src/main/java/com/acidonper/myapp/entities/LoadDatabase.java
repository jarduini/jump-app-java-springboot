package com.acidonper.myapp.entities;

import com.acidonper.myapp.entities.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        CommandLineRunner runner = args -> {
            System.out.println("Created: " + repository.save(new User("Pepe", "Gimenez")));
            System.out.println("Created: " + repository.save(new User("Pepa", "Gutierrez")));
        };
        return runner;
    }

}
