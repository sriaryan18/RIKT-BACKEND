package com.Project.RIKT.controller;

import com.Project.RIKT.entity.USER;
import com.Project.RIKT.passwords.PasswordEncoder;
import com.Project.RIKT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserRegistration {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("registerUser")
    public ResponseEntity registerUser(@RequestBody Map<String,String> request)
    {
         String userName=request.get("userName");
         String name=request.get("name");
         String password=request.get("password");
        String encodedPass=passwordEncoder.encode(password);
        Optional<USER> userCheck= userRepository.findByUserName(userName);

        if(!userCheck.isEmpty()) return new ResponseEntity("USER WITH USERNAME " + userName + " ALREADY" +
                "EXITS", HttpStatus.BAD_REQUEST);

        USER user=new USER();
        user.setUserName(userName);
        user.setDateOfRegistration(LocalDate.now());
        user.setName(name);
        user.setHashPassword(encodedPass);

        userRepository.save(user);
        return new ResponseEntity("USER REGISTRATION SUCCESSFULL ", HttpStatusCode.valueOf(200));
    }

}
