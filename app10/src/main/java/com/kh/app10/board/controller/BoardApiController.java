package com.kh.app10.board.controller;

import com.kh.app10.board.dto.BoardReqDto;
import com.kh.app10.board.dto.BoardRespDto;
import com.kh.app10.board.service.BoardService;
import com.kh.app10.member.dto.MemberRespDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    //insert
    @PostMapping
    public void save(@RequestBody BoardReqDto reqDto, HttpSession session){
        MemberRespDto loginMember = (MemberRespDto) session.getAttribute("loginMember");
        boardService.save(reqDto, loginMember.getUserId());
    }

    //selectOne
    @GetMapping("{no}")
    public BoardRespDto findBoardByNo(@PathVariable Long no){
        return boardService.findBoardByNo(no);
    }

    //selectList
    @GetMapping
    public List<BoardRespDto> findBoardAll(){
        return boardService.findBoardAll();
    }

    //update
    @PutMapping("{no}")
    public void updateBoard(@RequestBody BoardReqDto reqDto, @PathVariable Long no){
        boardService.updateBoard(reqDto, no);
    }

    //delete
    @DeleteMapping("{no}")
    public void deleteBoard(@PathVariable Long no){
        boardService.deleteBoard(no);
    }
}
