package com.kh.prac02.member.controller;

import com.kh.prac02.member.dto.MemberDto;
import com.kh.prac02.member.service.MemberService;
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
    public void join(@RequestBody MemberDto memberDto){
        service.join(memberDto);
    }

    //login - 한 객체 필요
    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto memberDto){
        return service.login(memberDto);
    }

}
