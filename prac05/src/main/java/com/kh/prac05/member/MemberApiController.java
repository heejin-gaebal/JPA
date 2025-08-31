package com.kh.prac05.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    //join
    @PostMapping("join")
    public Long join(@RequestBody MemberDto memberDto){
        return service.join(memberDto);
    }

    //login
    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto memberDto, HttpSession session){
        MemberDto loginMember = service.login(memberDto);
        session.setAttribute("loginMember", loginMember);
        return loginMember;
    }
}
