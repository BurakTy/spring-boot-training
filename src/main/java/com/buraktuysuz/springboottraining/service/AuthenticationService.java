package com.buraktuysuz.springboottraining.service;

import com.buraktuysuz.springboottraining.dto.UserRequestDto;
import com.buraktuysuz.springboottraining.entity.User;
import com.buraktuysuz.springboottraining.jwt.security.EnumJwtConstant;
import com.buraktuysuz.springboottraining.jwt.security.JwtTokenGenerator;
import com.buraktuysuz.springboottraining.service.entitySevice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;
    public String login(UserRequestDto userRequestDto){
        UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(),userRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String responseToken= jwtTokenGenerator.generateJwtToken(authentication);

        return EnumJwtConstant.BEARER.getConstant() + responseToken;
    }

    public User register(String username,String password){
        password = passwordEncoder.encode(password);
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);

        return userEntityService.save(user);
    }

    public void validateUserRequest(String username) {

        User user = userEntityService.findByUsername(username);

        if (user != null){
            throw new RuntimeException("Username already in use");
        }
    }
}
