package com.kh.app06.board.controller;

import com.kh.app06.board.dto.BoardDto;
import com.kh.app06.board.service.BoardService;
import lombok.Getter;
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
        dto.setWriterNo(1L);
        service.insert(dto);
    }

    //단건 조회 - 왜 엔티티아니고 dto를 주느냐,,,? DB의 정보를 다 보여줄필요없다...?
    @GetMapping("{no}")
    public BoardDto listOne(@PathVariable Long no){
        return service.listOne(no);
    }
    
    //목록 조회
    @GetMapping
    public List<BoardDto> boardAllList(){
        return service.boardAllList();
    }

}
