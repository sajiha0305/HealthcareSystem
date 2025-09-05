package com.example.MediLink.Service;


import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpService {

    private final SecureRandom random = new SecureRandom();

    public String generateOtp(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // digits 0-9
        }
        
        return otp.toString();
    }
}
