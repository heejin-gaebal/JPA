package com.hj.prac01.member.controller;

import com.hj.prac01.member.dto.ReqMemberDto;
import com.hj.prac01.member.dto.RespMemberDto;
import com.hj.prac01.member.service.MemberService;
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

    @GetMapping
    public RespMemberDto login(@RequestBody ReqMemberDto reqDto){
        return service.login(reqDto);
    }
}
