package com.emailotpverification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emailotpverification.model.Otp;
import com.emailotpverification.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
//	  Optional<User> findByEmail(String email);
//	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmail(String email);
	@Query("SELECT o FROM Otp o WHERE o.user.email = :email")
	Optional<Otp> findByUser_Email(@Param("email") String email);


}
