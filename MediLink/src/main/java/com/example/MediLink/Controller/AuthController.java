package com.example.MediLink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediLink.Request.RegisterEmailRequest;
import com.example.MediLink.Response.RegisterEmailResponse;
import com.example.MediLink.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authSevice;
	
	@PostMapping("/register/initiate")
	private ResponseEntity<RegisterEmailResponse> registerEmail(@RequestBody RegisterEmailRequest request)
	{
		
		
		return authSevice.registerEmail(request.getEmail());
	}

}
