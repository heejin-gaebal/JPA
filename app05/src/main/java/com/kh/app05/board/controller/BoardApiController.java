package com.kh.app05.board.controller;

import com.kh.app05.board.dto.BoardDto;
import com.kh.app05.board.service.BoardService;
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
    public void insert(@RequestBody BoardDto bDto){
        bDto.setWriterNo(1L);
        service.insert(bDto);
    }

    @GetMapping
    public List<BoardDto> findBoardAll(){
        return service.findBoardAll();
    }

    @GetMapping("{no}")
    public BoardDto findBoardByNo(@PathVariable Long no){
        return service.findBoardByNo(no);
    }

    @DeleteMapping("{no}")
    public void deleteBoardByNo(@PathVariable Long no){
        service.deleteBoardByNo(no);
    }
}
