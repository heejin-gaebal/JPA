package com.hj.prac01.gallery.controller;

import com.hj.prac01.gallery.entity.GalleryEntity;
import com.hj.prac01.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gallery")
@RequiredArgsConstructor
public class GalleryApiController {
    private final GalleryService service;

    //insert
    @PostMapping
    public void insert(@RequestBody GalleryEntity entity){
        service.insert(entity);
    }

    //list
    @GetMapping
    public List<GalleryEntity> list(){
        return service.list();
    }

    //listOne
    @GetMapping("{no}")
    public GalleryEntity listOne(@PathVariable Long no){
        return service.listOne(no);
    }

    //update
    @PutMapping
    public void update(@RequestBody GalleryEntity vo){
        service.update(vo);
    }

    //delete
    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        service.delete(no);
    }
}
