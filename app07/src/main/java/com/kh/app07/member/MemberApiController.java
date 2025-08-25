package com.kh.app07.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    //join
    @PostMapping("join")
    public Long join(@RequestBody MemberDto memberDto){
        return memberService.join(memberDto);
    }

    //login
    @PostMapping("login") //MemberDto 객체하나 리턴
    public MemberDto login(@RequestBody MemberDto memberDto){
        return memberService.login(memberDto);
    }
}
