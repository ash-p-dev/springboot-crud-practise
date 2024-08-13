package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.entites.User;
import com.jpa.test.service.UserService;

@SpringBootApplication
public class BootjpaexampleApplication {

    public static void main(String[] args) {
        // Run the Spring Boot application
        ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
        
        // Access UserService bean
        UserService userService = context.getBean(UserService.class);
        
        // Create a new user
        User user = new User();
        user.setName("Shantanu");
        user.setCity("MPune");
        user.setStatus("Java");
        
        // Save the user to the database
        User savedUser = userService.saveUser(user);
        System.out.println("Saved User: " + savedUser);
        
        // Read all users
        System.out.println("All Users:");
        userService.getAllUsers().forEach(System.out::println);
        
        // Read user by ID
        int userId = savedUser.getId();
        userService.getUserById(userId).ifPresentOrElse(
            u -> System.out.println("User with ID " + userId + ": " + u),
            () -> System.out.println("User with ID " + userId + " not found")
        );
        
        // Update user
        savedUser.setCity("Mumbai");
        User updatedUser = userService.updateUser(savedUser);
        if (updatedUser != null) {
            System.out.println("Updated User: " + updatedUser);
        } else {
            System.out.println("User not found for update");
        }
        
//        // Delete user
//        userService.deleteUserById(userId);
//        System.out.println("User with ID " + userId + " deleted");

        // Verify deletion
        userService.getUserById(userId).ifPresentOrElse(
            u -> System.out.println("User with ID " + userId + ": " + u),
            () -> System.out.println("User with ID " + userId + " not found")
        );
    }
}
