package com.kh.app10.like.controller;

import com.kh.app10.like.service.LikeService;
import com.kh.app10.member.dto.MemberRespDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/like")
@RequiredArgsConstructor
public class LikeApiController {
    private final LikeService likeService;
    
    //좋아요 표시 - 유저정보/게시글 번호받기
    @PostMapping("{boardNo}")
    public void save(@PathVariable Long boardNo, HttpSession session){
        MemberRespDto loginMember = (MemberRespDto) session.getAttribute("loginMember");
        String userId = loginMember.getUserId();
        likeService.save(userId, boardNo);
    }

}
