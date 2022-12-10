package com.example.finalpractice;

import com.example.finalpractice.Entities.Users;
import com.example.finalpractice.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalpracticeApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            userRepository.save(new Users(1L , "Jam", "Abc"));
            userRepository.save(new Users(2L, "Jim", "Abc"));
            userRepository.save(new Users(3L, "JackYashvi", "Abc"));
            userRepository.findAll().forEach(a->{
                System.out.println(a.getName());
            });
        };
    }
}
