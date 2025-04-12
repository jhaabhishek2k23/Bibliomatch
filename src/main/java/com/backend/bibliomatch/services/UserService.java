package com.backend.bibliomatch.services;

import com.backend.bibliomatch.entities.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    User updateUserProfile(Long userId, User user);
    void verifyUser(String email, String otp);
    public String capitalizeNthLetter(String input);
    public  void createPdfWithText(String text, String filePath);
}