package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.UserRequestDto;
import com.buraktuysuz.springboottraining.entity.User;
import com.buraktuysuz.springboottraining.service.entitySevice.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String Login(@RequestBody UserRequestDto userRequestDto){
        return authenticationService.login(userRequestDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> Resgister(@RequestBody UserRequestDto userRequestDto){

        String username=userRequestDto.getUsername();
        String password=userRequestDto.getPassword();

        try {
            authenticationService.validateUserRequest(username);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        User user=  authenticationService.register(username,password);
        return new ResponseEntity<>("User registered", HttpStatus.CREATED);

    }
}
