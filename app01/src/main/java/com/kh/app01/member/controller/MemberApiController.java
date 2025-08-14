package com.kh.app01.member.controller;

import com.kh.app01.member.dto.ReqMemberDto;
import com.kh.app01.member.dto.RespMemberDto;
import com.kh.app01.member.entity.MemberEntity;
import com.kh.app01.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    @PostMapping
    public void join(@RequestBody ReqMemberDto reqDto){
        service.join(reqDto);
    }

    @PostMapping("login")
    public RespMemberDto login(@RequestBody ReqMemberDto reqDto){
        return service.login(reqDto);
    }
}
