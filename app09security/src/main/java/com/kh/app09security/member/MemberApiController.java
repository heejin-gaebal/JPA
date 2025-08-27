package com.kh.app09security.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping //("api/member")
public class MemberApiController {

    @GetMapping("home")
    public void home(){
        System.out.println("MemberApiController.home CALL");
    }
}
