package com.kh.app09security.filter;

import com.kh.app09security.security.MyJwtUtil;
import com.kh.app09security.security.MyUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;

@RequiredArgsConstructor
//필터설정시 urlPattern 설정 필요
public class MyLoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final MyJwtUtil myJwtUtil;

    //로그인 시도
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("MyLoginFilter.attemptAuthentication");
        
        //로그인 정보 확인하기 - return 인증매니저.인증() | 스프링이 제공한 authConfig 통해서 인증매니저 얻기 | 아이디-비밀번호-권한
        Authentication authToken = new UsernamePasswordAuthenticationToken("user01" , "1234", null);
        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("MyLoginFilter.successfulAuthentication");
//        String token = "{no:777, id:usr01, pwd:1234, role:ADMIN}";

        MyUserDetails userDetails = (MyUserDetails) authResult.getPrincipal();
        String userId = userDetails.getUsername();
        String userNick = userDetails.getUserNick();
        String userRole = userDetails.getUserRole();

        String jwt = myJwtUtil.createJWT(userId, userNick, userRole);
        response.addHeader("Authorization", "Bearer " + jwt);
        //Bearer 로 토큰임을 명시해준다.
        //토큰 꺼낼때는 패치함수에서 split 으로 배열쪼개서 토큰만 추출
    }

    //로그인 실패
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        System.out.println("MyLoginFilter.unsuccessfulAuthentication");
        response.setStatus(HttpServletResponse.SC_CONFLICT);
    }
}
