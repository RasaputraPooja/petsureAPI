package com.emailotpverification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailotpverification.model.Otp;
import com.emailotpverification.model.User;

public interface OtpRepository extends JpaRepository<Otp, Long> {
	
//	User findByUsername(String username);
//	User findByEmail(String email);
	
//	Optional<Otp> findByEmail(String email);
//    Optional<Otp> findByEmailAndPurpose(String email, String purpose);
	Optional<Otp> findByUser(User user);
	Optional<Otp> findByUser_Email(String email);


}
