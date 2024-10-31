package com.example.hin_cheu.service;

import com.example.hin_cheu.models.User;
import com.example.hin_cheu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Change this import
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Change this to PasswordEncoder


    // Save user and hash the password
    public User saveUser(User user) {
        String rawPassword = user.getPassword();
        System.out.println("raw pass: " + rawPassword); // Get the raw password
        String encodedPassword = passwordEncoder.encode(rawPassword); // Encode the password
        user.setPassword(encodedPassword); // Set the encoded password back to the user object
        System.out.println("encoded code: " + encodedPassword);
        return userRepository.save(user); // Save the user with the encoded password
    }

    // Find user by email
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email)); // Returns Optional
    }

    // Verify user credentials for sign-in
    public boolean verifyUserCredentials(String email, String rawPassword) {
        // Find user by email
        Optional<User> userOptional = findByEmail(email);

        // Check if user exists
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Log whether the password matches
            boolean passwordMatches = passwordEncoder.matches(rawPassword, user.getPassword());
            System.out.println("Email: " + email + " found, Password Match: " + passwordMatches);
            return passwordMatches;
        } else {
            // Log if the email was not found
            System.out.println("User not found for email: " + email);
        }
        return false; // Return false if the user does not exist
    }

    public void testPasswordMatching() {
        // Raw password to test
        String rawPassword = "1234";  // Replace with the password you want to test
        // Generate the encoded password for testing
        String encodedPassword = "$2a$10$FQXkL1J8yhEA3.nrgCW/ZO8YYUSBjmvAxW1qQMx1TrlzwtFhDnImC";
        // Hashing the raw password
        System.out.println(encodedPassword);

        // Now check if the raw password matches the encoded password
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Password test match: " + matches);
    }
}
