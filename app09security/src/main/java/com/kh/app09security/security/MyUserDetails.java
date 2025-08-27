package com.kh.app09security.security;

import com.kh.app09security.member.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class MyUserDetails implements UserDetails {
    private final MemberVo vo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //컬렉션의 리스트 형태로 관리
        return List.of(new SimpleGrantedAuthority("ROLE_" + vo.getUserRole()));
    }

    @Override
    public String getPassword() {
        return vo.getUserPwd();
    }

    @Override
    public String getUsername() {
        return vo.getUserId();
    }
}
