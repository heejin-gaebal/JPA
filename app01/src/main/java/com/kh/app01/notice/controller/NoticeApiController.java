package com.kh.app01.notice.controller;

import com.kh.app01.board.entity.BoardEntity;
import com.kh.app01.notice.entity.NoticeEntity;
import com.kh.app01.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
public class NoticeApiController {
    private final NoticeService service;

    @PostMapping
    public void insert(@RequestBody NoticeEntity entity){
        service.insert(entity);
    }

    @GetMapping
    public List<NoticeEntity> getNoticeAll(){
        return service.getNoticeAll();
    }

    @GetMapping("{no}")
    public NoticeEntity getNoticeByNo(@PathVariable Long no){
        return service.getNoticeByNo(no);
    }

    //hard delete
    @DeleteMapping("{no}")
    public void deleteNoticeByNo(@PathVariable Long no){
        service.deleteNoticeByNo(no);
    }

    //soft delete
    @PutMapping
    public void updateNotice(@RequestBody NoticeEntity vo){
        service.updateNotice(vo);
    }
}
