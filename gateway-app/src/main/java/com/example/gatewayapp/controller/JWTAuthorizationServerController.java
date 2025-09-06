package com.example.gatewayapp.controller;

import com.example.gatewayapp.security.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class JWTAuthorizationServerController {

    @GetMapping("/token")
    @ResponseBody
    public String generateToken(@RequestParam(defaultValue = "user1") String userString) {
        return Jwts.builder()
                .setSubject(userString)
                .setExpiration(new Date(System.currentTimeMillis() + 60_000)) // expira em 1 min
                .signWith(JwtUtil.SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
