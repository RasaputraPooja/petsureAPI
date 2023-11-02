package com.emailotpverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailotpverification.model.User;
import com.emailotpverification.repository.UserRepository;
import com.emailotpverification.service.OtpService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private OtpService otpService;
    
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/initiatePasswordReset")
//    public ResponseEntity<String> initiatePasswordReset(@RequestParam String email) {
//        otpService.initiatePasswordReset(email);
//        return ResponseEntity.ok("If an account with this email exists, an OTP has been sent.");
//    }
//
//    @PostMapping("/resetPassword")
//    public ResponseEntity<String> resetPassword(
//            @RequestParam String email,
//            @RequestParam String otp,
//            @RequestParam String newPassword
//    ) {
//        if (otpService.validateOtpAndResetPassword(email, otp, newPassword)) {
//            return ResponseEntity.ok("Password has been reset.");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP.");
//        }
//    }
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}

