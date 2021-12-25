package com.buraktuysuz.springboottraining.jwt.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtTokenGenerator {

    @Value("${com.buraktuysuz.springboottraining.jwt.security.app.key}")
    private String APP_KEY;

    @Value("${com.buraktuysuz.springboottraining.jwt.security.expire.time}")
    private Long EXPIRE_TIME;
}
