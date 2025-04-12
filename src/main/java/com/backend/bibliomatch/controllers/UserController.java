package com.backend.bibliomatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bibliomatch.DTOs.LoginRequestDTO;
import com.backend.bibliomatch.DTOs.TestDTO;
import com.backend.bibliomatch.entities.User;
import com.backend.bibliomatch.services.UserService;



@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/pdfReturn")
    public String getPdf(@RequestBody TestDTO testDto) {
        String input = testDto.getInput();
        String capitalizedText =  userService.capitalizeNthLetter(input);
        String outputPath = "output.pdf";
       userService.createPdfWithText(capitalizedText, outputPath);
        System.out.println("PDF created successfully at: " + outputPath);
        return "pdf has successfully converted";
    }
    

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginReq) {
        String email = loginReq.getUsernameOrEmail();
        String password = loginReq.getPassword();
        System.out.println(email + " " + password);

        User loginedUser = userService.loginUser(email, password);

        System.out.println(loginedUser);

        if (loginedUser == null) {
            return ResponseEntity.status(403).body("Wrong Credentials, please try again");
        }

        return ResponseEntity.ok(loginedUser);
    }


    @PutMapping("/{userId}")
    public User updateUserProfile(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUserProfile(userId, user);
    }

    @PostMapping("/verify")
    public void verifyUser(@RequestParam String email, @RequestParam String otp) {
        userService.verifyUser(email, otp);
    }

    @GetMapping("/")
    public String entryPoint() {
        return "Welcome to my book store";
    }
    
}