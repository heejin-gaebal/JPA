package com.kh.app06.member.controller;

import com.kh.app06.member.dto.MemberDto;
import com.kh.app06.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    @PostMapping("join")
    public void join(@RequestBody MemberDto dto){
        service.join(dto);
    }

    @PostMapping("login") //객체 하나 뽑기
    public MemberDto login(@RequestBody MemberDto dto){
        return service.login(dto);
    }

    @GetMapping
    public List<MemberDto> findAllMember(){
        return service.findAllMember();
    }
}
