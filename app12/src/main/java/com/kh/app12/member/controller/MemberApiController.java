package com.kh.app12.member.controller;

import com.kh.app12.member.dto.MemberDto;
import com.kh.app12.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("join")
    public ResponseEntity<String> join(@RequestBody MemberDto.MemberReqDto reqDto){
        memberService.join(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }

    @PostMapping("login")
    public ResponseEntity<MemberDto.MemberRespDto> login(@RequestBody MemberDto.MemberReqDto dto){
        MemberDto.MemberRespDto respDto = memberService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(respDto);
    }
}
