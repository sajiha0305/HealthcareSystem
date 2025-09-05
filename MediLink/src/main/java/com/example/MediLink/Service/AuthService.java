package com.example.MediLink.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MediLink.Entity.UserEntity;
import com.example.MediLink.Repository.UserRepository;
import com.example.MediLink.Response.RegisterEmailResponse;

@Service
public class AuthService {
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepo;

	public ResponseEntity<RegisterEmailResponse> registerEmail(String email) {
		List<UserEntity> userEntity=userRepo.findByEmail(email);
		if(!userEntity.isEmpty())
		{
            return ResponseEntity.badRequest().body(new RegisterEmailResponse("error", "Email Already Exist"));
		}
		
		String otp = otpService.generateOtp(6); // 6-digit OTP
        emailService.sendOtp(email, otp);
        RegisterEmailResponse emailResponse=new RegisterEmailResponse("success","OTP Sent Successfully!!");
        return ResponseEntity.ok(emailResponse);
		
	}

	
}
