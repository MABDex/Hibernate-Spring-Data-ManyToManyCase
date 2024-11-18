package vedio6youssfi.springbootvedio6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vedio6youssfi.springbootvedio6.entities.Role;
import vedio6youssfi.springbootvedio6.entities.User;
import vedio6youssfi.springbootvedio6.service.Userservice;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootVedio6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVedio6Application.class, args);
    }

    @Bean
    CommandLineRunner start(Userservice userservice) {
        return args -> {
            if (userservice.findUserByUsername("user1") == null) {
                User user1 = new User();
                user1.setUsername("user1");
                user1.setPassword("123456");
                userservice.addNewUser(user1);
            }

            Stream.of("Student", "User", "Admin").forEach(roleName -> {
                if (userservice.findRoleByUsername(roleName) == null) {
                    Role role = new Role();
                    role.setRolename(roleName);
                    userservice.addNewRole(role);
                }
            });

            userservice.addRoleToUser("user1", "Student");
        };
    }




}
