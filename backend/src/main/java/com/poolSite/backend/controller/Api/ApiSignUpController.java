package com.poolSite.backend.controller.Api;

import com.poolSite.backend.entity.User;
import com.poolSite.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class ApiSignUpController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/api/account/signup")
    public void signUp(
            @RequestBody Map<String,String> params
    ){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("params test : " + params);

        User newUser = new User();
        newUser.setUserId(params.get("userId"));
        newUser.setAdmin(Boolean.valueOf(params.get("admin")));
        newUser.setName(params.get("name"));
        newUser.setPassword(params.get("password"));
        newUser.setEmail(params.get("email"));
        newUser.setPhoneNumber(params.get("phoneNumber"));
        newUser.setBirthday(params.get("birthday"));

        newUser.setCreatedAt(currentTime);

        //userRepository.save(newUser);
    }
}
