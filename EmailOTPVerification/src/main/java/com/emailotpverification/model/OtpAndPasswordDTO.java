package com.emailotpverification.model;

public class OtpAndPasswordDTO {
	
	
	 private String email;
	    private String otp;
	    public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		private String newPassword;
	    
	    

}
