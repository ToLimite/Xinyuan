package com.xinyuan.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String signKey = "TmFua2FpVW5pdmVyc2l0eUNvbGxlZ2VPZlNvZnR3YXJl="; // NankaiUniversityCollegeOfSoftware 的 Base64编码
    private static final long expire = 43200000L; // 12小时

    private static Key getKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(signKey));
    }

    public static String generateJwt(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims parseJWT(String jwt){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
