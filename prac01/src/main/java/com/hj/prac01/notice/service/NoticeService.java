package com.hj.prac01.notice.service;

import com.hj.prac01.notice.entity.NoticeEntity;
import com.hj.prac01.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository repository;

    public void insert(NoticeEntity entity) {
        repository.insert(entity);
    }

    public List<NoticeEntity> list() {
        return repository.list();
    }

    public NoticeEntity listOne(Long no) {
        return repository.listOne(no);
    }

    public void update(NoticeEntity vo) {
        Long no = vo.getNo();
        String title = vo.getTitle();
        String content = vo.getContent();

        NoticeEntity entity = repository.listOne(no);
        entity.setTitle(title);
        entity.setContent(content);
    }

    public void delete(Long no) {
        NoticeEntity entity = repository.listOne(no);
        repository.delete(entity);
    }
}
