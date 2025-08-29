package com.kh.app09security.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class MyJwtUtil {
    private final SecretKey secretKey;

    //기본생성자로 초기화
    public MyJwtUtil(@Value("${kh.jwt.secret}") String str) {
        //시크릿키 생성
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        String algorithm = Jwts.SIG.HS256.key().build().getAlgorithm();
        this.secretKey = new SecretKeySpec(bytes, algorithm);
    }

    //JWT 생성
    public String createJWT(String userId, String userNick, String userRole){
        return Jwts.builder()
                .subject(userId)
                .claim("userNick" , userNick)
                .claim("userRole" , userRole)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) //expiration 만료시간 밀리세컨 단위
                .signWith(secretKey) //서명 일반 문자열이 아님
                .compact();
    }

    //유저ID 꺼내기
    public String getUserId(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }
    public String getUserNick(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("userNick", String.class);
    }
    public String getUserRole(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("userRole", String.class);
    }
    public Boolean isExpired(String token){ //토큰체크
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

}
