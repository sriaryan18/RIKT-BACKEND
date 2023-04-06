package com.Project.RIKT.passwords;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;




@Component
public class PasswordEncoder {

    public String encode(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    public boolean matches(String password, String encodedPassword) {
        return BCrypt.checkpw(password, encodedPassword);
    }
}
