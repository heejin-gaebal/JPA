package com.kh.app14.board.controller;

import com.kh.app14.board.dto.request.BoardReqDto;
import com.kh.app14.board.dto.response.BoardRespDto;
import com.kh.app14.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //insert
    @PostMapping
    public void register(@RequestBody BoardReqDto reqDto){
        boardService.save(reqDto);
    }

    @GetMapping
    public List<BoardRespDto> retrieveList(){
        return boardService.retrieveList();
    }
}
