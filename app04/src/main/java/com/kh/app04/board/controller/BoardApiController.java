package com.kh.app04.board.controller;

import com.kh.app04.board.dto.BoardDto.BoardDto;
import com.kh.app04.board.entity.BoardEntity;
import com.kh.app04.board.service.BoardService;
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
    public void insert(@RequestBody BoardDto dto){
        //세션의 아이디 필요
        String loginMemberID = "guest01";
        service.insert(dto, loginMemberID);
    }

    //list
    @GetMapping
    public List<BoardEntity> list(){
        return service.list();
    }
}
