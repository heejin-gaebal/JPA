package com.hj.prac01.notice.controller;

import com.hj.prac01.notice.entity.NoticeEntity;
import com.hj.prac01.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
public class NoticeApiController {
    private final NoticeService service;

    //insert
    @PostMapping
    public void insert(@RequestBody NoticeEntity entity){
        service.insert(entity);
    }

    //selectList
    @GetMapping
    public List<NoticeEntity> list(){
        return service.list();
    }

    //listOne
    @GetMapping("{no}")
    public NoticeEntity listOne(@PathVariable Long no){
        return service.listOne(no);
    }

    //update
    @PutMapping
    public void update(@RequestBody NoticeEntity vo){
        service.update(vo);
    }

    //delete
    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        service.delete(no);
    }
}
