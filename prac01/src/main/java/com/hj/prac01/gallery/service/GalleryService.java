package com.hj.prac01.gallery.service;

import com.hj.prac01.gallery.entity.GalleryEntity;
import com.hj.prac01.gallery.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GalleryService {
    private final GalleryRepository repository;

    public void insert(GalleryEntity entity) {
        repository.insert(entity);
    }

    public List<GalleryEntity> list() {
        return repository.list();
    }

    public GalleryEntity listOne(Long no) {
        return repository.listOne(no);
    }

    public void update(GalleryEntity vo) {
        Long no = vo.getNo();
        String title = vo.getTitle();
        String content = vo.getContent();

        GalleryEntity entity = repository.listOne(no);
        entity.setTitle(title);
        entity.setContent(content);
    }

//    public void delete(Long no) {
//        GalleryEntity entity = repository.listOne(no);
//        repository.delete(entity);
//    }

    public void delete(Long no) {
        GalleryEntity entity = repository.listOne(no);
        entity.setDelYn("Y");
    }
}
