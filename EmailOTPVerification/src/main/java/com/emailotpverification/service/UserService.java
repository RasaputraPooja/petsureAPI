package com.emailotpverification.service;



import com.emailotpverification.model.User;
import com.emailotpverification.repository.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public void resetPassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Hash the new password using BCrypt
//            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            
            
//            user.setPassword(hashedPassword);
            user.setPassword(newPassword);

            userRepository.save(user);
        }
        // Handle the case where no user exists with the given email (Optional but recommended).
    }
}

