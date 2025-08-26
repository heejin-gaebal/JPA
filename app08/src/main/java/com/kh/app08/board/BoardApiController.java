package com.kh.app08.board;

import com.kh.app08.member.MemberDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    //insert
    @PostMapping
    public Long insert(@RequestBody BoardDto dto, HttpSession session){
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
        dto.setWriterNo(loginMember.getNo());
        return service.insert(dto);
    }

    //list
    @GetMapping
    public List<BoardDto> listAll(){
        return service.listAll();
    }

    //listOne
    @GetMapping("{no}")
    public BoardDto listOneByNo(@PathVariable Long no){
        return service.listOneByNo(no);
    }

    //delete
    @DeleteMapping("{no}")
    public void deleteBoardByNo(@PathVariable Long no, HttpSession session){
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
        Long loginMemberNo = loginMember.getNo();
        service.deleteBoardByNo(no, loginMemberNo);
    }

    //update
    @PutMapping
    public void update(@RequestBody BoardDto dto , HttpSession session){
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");
        Long loginMemberNo = loginMember.getNo();
        service.update(dto, loginMemberNo);
    }
}
