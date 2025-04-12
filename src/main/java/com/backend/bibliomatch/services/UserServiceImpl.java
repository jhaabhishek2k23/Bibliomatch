package com.backend.bibliomatch.services;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.bibliomatch.entities.User;
import com.backend.bibliomatch.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Generate OTP and set it to the user
        user.setOtp("123456"); // In real-world, generate a random OTP
        user.setVerified(false);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
    
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public String capitalizeNthLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
    
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
    
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase(); // start with lowercase
            int pos = i + 1; // word position (1-based)
            if (word.length() >= pos) {
                result.append(word.substring(0, pos - 1))
                      .append(Character.toUpperCase(word.charAt(pos - 1)))
                      .append(word.substring(pos));
            } else {
                // if word is shorter than its position, just add as-is
                result.append(word);
            }
            result.append(" ");
        }
    
        return result.toString().trim();
    }
    
    

    public  void createPdfWithText(String text, String filePath) {
        Document document = new Document();
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            PdfWriter.getInstance(document, fos);
            document.open();
            document.add(new Paragraph(text));
            document.close();
        } catch (DocumentException | IOException e) {
            System.out.println("LogERrorTrace "+e.getMessage());
            e.printStackTrace();
        }
    }
    

    @Override
    public User updateUserProfile(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void verifyUser(String email, String otp) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            user.setVerified(true);
            userRepository.save(user);
        }
    }
}