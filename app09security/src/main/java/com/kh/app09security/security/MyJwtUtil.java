package com.kh.app09security.security;

import com.kh.app09security.member.MemberVo;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class MyJwtUtil {
    @Value("${kh.jwt.secret}")
    private String secretKey;
    
    //JWT 생성
    public String createJWT(String userId, String userNick, String userRole){
//        String secretKey = "difldorxmfhdnpqdoqaksemfrlxkdlqtmzmflqxm";
        byte[] bytes = secretKey.getBytes(StandardCharsets.UTF_8);
        String algorithm = Jwts.SIG.HS256.key().build().getAlgorithm();
        Key key = new SecretKeySpec(bytes, algorithm);

        return Jwts.builder()
                .subject(userId)
                .claim("userNick" , userNick)
                .claim("userRole" , userRole)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) //expiration 만료시간 밀리세컨 단위
                .signWith(key) //서명 일반 문자열이 아님
                .compact();
    }
    
}
