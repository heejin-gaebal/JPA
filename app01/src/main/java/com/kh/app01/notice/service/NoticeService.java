package com.kh.app01.notice.service;

import com.kh.app01.notice.entity.NoticeEntity;
import com.kh.app01.notice.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository repository;

    public void insert(NoticeEntity entity) {
        repository.insert(entity);
    }

    public List<NoticeEntity> getNoticeAll() {
        return repository.getNoticeAll();
    }

    public NoticeEntity getNoticeByNo(Long no) {
        return repository.getNoticeByNo(no);
    }

    public void deleteNoticeByNo(Long no) {
        //삭제할 엔티티 번호 받아오기
        NoticeEntity entity = repository.getNoticeByNo(no);
        repository.deleteNoticeByNo(entity);
    }

    public void updateNotice(NoticeEntity vo) {
        //JPA가 관리하는 엔티티를 가져옴
        Long no = vo.getNo();
        String title = vo.getTitle();
        String content = vo.getContent();

        NoticeEntity entity = repository.getNoticeByNo(no);
        entity.setTitle(title);
        entity.setContent(content);
    }
}
