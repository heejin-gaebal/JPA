package com.kh.app01.board.controller;

import com.kh.app01.board.entity.BoardEntity;
import com.kh.app01.board.service.BoardService;
import com.kh.app01.notice.entity.NoticeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @PostMapping
    public void insert(@RequestBody BoardEntity entity){
        service.insert(entity);
    }

    @GetMapping
    public List<BoardEntity> getBoardAll(){
        return service.getBoardAll();
    }

    @GetMapping("{no}")
    public BoardEntity getBoardByNo(@PathVariable Long no){
        return service.getBoardByNo(no);
    }

    //soft delete
    @DeleteMapping("{no}")
    public void deleteBoardByNo (@PathVariable Long no){
        service.deleteBoardByNo(no);
    }
}
