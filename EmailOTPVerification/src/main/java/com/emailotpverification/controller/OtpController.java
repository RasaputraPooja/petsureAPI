package com.emailotpverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emailotpverification.model.OtpAndPasswordDTO;
import com.emailotpverification.service.OtpService;

@RestController
@RequestMapping("/api")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        otpService.generateAndSendOtp(email);
        return ResponseEntity.ok("OTP sent!");
    }
    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody OtpAndPasswordDTO otpAndPassword) {
        boolean success = otpService.verifyOtpAndResetPassword(otpAndPassword);
        if (success) {
            return ResponseEntity.ok("Password reset successful!");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP!");
        }
    }

    
}