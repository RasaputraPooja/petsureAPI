package com.emailotpverification.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emailotpverification.model.Otp;
import com.emailotpverification.model.OtpAndPasswordDTO;
import com.emailotpverification.model.User;
import com.emailotpverification.repository.OtpRepository;
import com.emailotpverification.repository.UserRepository;



@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private UserRepository userRepository; 
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private UserService userService;

    public String generateOtp() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }
    
    public void generateAndSendOtp(String email) {
        String otpValue = generateOtp();
        
        // Retrieve or create User entity
        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(email);
            userRepository.save(newUser);
            return newUser;
        });

        // Create Otp entity
        Otp otpEntity = new Otp();
        otpEntity.setOtp(otpValue);
        otpEntity.setTimestamp(new Date());

        // Link the OTP to the user
        otpEntity.setUser(user);

        // Save Otp
        otpRepository.save(otpEntity);

        // Send the email
        mailService.sendMail(email, "Your OTP", "Your OTP is: " + otpValue);
    }


    public boolean verifyOtpAndResetPassword(OtpAndPasswordDTO otpAndPassword) {
        Optional<Otp> storedOtp = otpRepository.findByUser_Email(otpAndPassword.getEmail());
        
        if (storedOtp.isPresent() && storedOtp.get().getOtp().equals(otpAndPassword.getOtp())) {
            // If the OTP matches, reset the password
            userService.resetPassword(otpAndPassword.getEmail(), otpAndPassword.getNewPassword());
            
            // Optionally delete the OTP after successful use
            otpRepository.delete(storedOtp.get());
            
            return true;
        } else {
            return false;
        }
    }
 
    
}






