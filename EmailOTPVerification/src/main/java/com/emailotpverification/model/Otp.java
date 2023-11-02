package com.emailotpverification.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	
	@Entity
	@Table(name = "otps")
	public class Otp implements Serializable {

	    private static final long serialVersionUID = 2L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    private String otp;
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date timestamp;

	    @ManyToOne
	    @JoinColumn(name = "user_email", referencedColumnName = "email")
	    private User user;

	  
	    

	    public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		

	

	    public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Otp() {
	    }

	  

	    // Standard getters and setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	 

	}


