package com.kh.app09security.filter;

import com.kh.app09security.member.MemberVo;
import com.kh.app09security.security.MyJwtUtil;
import com.kh.app09security.security.MyUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

//최초한번 검증
@RequiredArgsConstructor
public class MyJwtFilter extends OncePerRequestFilter {
    private final MyJwtUtil myJwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 신분증 검사 -> 인증 || 인가
        //패킷 헤더에서 값 꺼내옴
        String authorization = request.getHeader("Authorization");
        //토큰 있는지, null 값인지 검증하기
        if(authorization == null || !authorization.startsWith("Bearer ")){//만약 토큰이 제대로 들어있지않으면
            System.out.println("토큰이 없어용,,,");
            filterChain.doFilter(request,response);
            return;
        }
        
        //앞의 [Bearer ]를 제외하고 토큰 추출
        String accessToken = authorization.split(" ")[1];

        String userId = myJwtUtil.getUserId(accessToken);
        String userNick = myJwtUtil.getUserNick(accessToken);
        String userRole = myJwtUtil.getUserRole(accessToken);

        //토큰 만료 검증
        if(myJwtUtil.isExpired(accessToken)){
            System.out.println("토큰만료");
            filterChain.doFilter(request,response);
            return;
        }

        MemberVo vo = new MemberVo();
        vo.setUserId(userId);
        vo.setUserNick(userNick);
        vo.setUserRole(userRole);

        MyUserDetails principal = new MyUserDetails(vo);
        String credentials = null;
        Collection authorities = principal.getAuthorities();
        Authentication authToken = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }
}
