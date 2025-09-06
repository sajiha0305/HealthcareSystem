package com.example.MediLink.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Service
public class OtpService {
	@Autowired
    private StringRedisTemplate redisTemplate;

    private final SecureRandom random = new SecureRandom();
    

    public String generateOtp(int length,String email) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // digits 0-9
        }
        redisTemplate.opsForValue().set("OTP:" + email, String.valueOf(otp), 5, TimeUnit.MINUTES);
        return otp.toString();
    }
    
    public boolean verifyOtp(String email, String otp) {
        String storedOtp = redisTemplate.opsForValue().get("OTP:" + email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            redisTemplate.delete("OTP:" + email);
            return true;
        }
        return false;
    }
}
