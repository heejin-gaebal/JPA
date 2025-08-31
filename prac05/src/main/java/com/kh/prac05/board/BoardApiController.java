package com.kh.prac05.board;

import com.kh.prac05.member.MemberDto;
import com.kh.prac05.util.AttachFileDto;
import com.kh.prac05.util.AttachFileEntity;
import com.kh.prac05.util.AttachFileUploader;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    //insert
    @PostMapping
    public Long insert(@RequestBody BoardDto boardDto) {
        return service.insert(boardDto);
    }

    //list
    @GetMapping
    public List<BoardDto> list(){
        return service.list();
    }

    //listOne
    @GetMapping("{no}")
    public BoardDto listOne(@PathVariable Long no){
        return service.listOne(no);
    }

    //update
    @PutMapping
    public void update(@RequestBody BoardDto boardDto){
//        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
//        Long loginMemberNo = loginMember.getNo();
        service.update(boardDto, 3L);
    }

    //delete
    @DeleteMapping("{no}")
    public void deleteNo(@PathVariable Long no){
//        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
//        Long loginMemberNo = loginMember.getNo();
        service.deleteNo(no, 3L);
    }
}
