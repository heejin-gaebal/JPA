package com.hj.prac01.board.controller;

import com.hj.prac01.board.entity.BoardEntity;
import com.hj.prac01.board.service.BoardService;
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
    public void insert(@RequestBody BoardEntity entity){
        service.insert(entity);
    }

    //selectList
    @GetMapping
    public List<BoardEntity> list(){
        return service.list();
    }

    //selectByNo
    @GetMapping("{no}")
    public BoardEntity listOne(@PathVariable Long no){
        return service.listOne(no);
    }

    //update
    @PutMapping
    public void update(@RequestBody BoardEntity vo){
        service.update(vo);
    }

    //delete
    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        service.delete(no);
    }
}
