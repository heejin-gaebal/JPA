package com.kh.app05.member.controller;

import com.kh.app05.member.dto.MemberDto;
import com.kh.app05.member.entity.MemberEntity;
import com.kh.app05.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    //join
    @PostMapping("join")
    public void join(@RequestBody MemberDto mDto){
        service.join(mDto);
    }

    //login
    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto mDto){
        return service.login(mDto);
    }

    @GetMapping
    public List<MemberDto> findAllMember(){
        return service.findAllMember();
    }
}
