package com.kh.app09security.filter;

import com.kh.app09security.member.MemberRepository;
import com.kh.app09security.member.MemberVo;
import com.kh.app09security.security.MyUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    //로그인처리 필요 | UserDetails는 memberVo
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVo vo = memberRepository.login(username);
        MyUserDetails myUserDetails = new MyUserDetails(vo);
        return myUserDetails;
    }
}
