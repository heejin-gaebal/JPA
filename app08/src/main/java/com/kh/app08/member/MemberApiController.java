package com.kh.app08.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    //join
    @PostMapping("join")
    public Long join(@RequestBody MemberDto dto){
        return service.join(dto);
    }

    //login
    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto, HttpSession session){
        MemberDto loginMember = service.login(dto);
        session.setAttribute("loginMember", loginMember);
        return loginMember;
    }
}
