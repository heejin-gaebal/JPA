package com.kh.app01.notice.repository;

import com.kh.app01.notice.entity.NoticeEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;

    public void insert(NoticeEntity entity) {
        em.persist(entity);
    }

    public List<NoticeEntity> getNoticeAll() {
        String jpql = "SELECT n FROM NoticeEntity n";
        return em.createQuery(jpql, NoticeEntity.class).getResultList();
    }

    public NoticeEntity getNoticeByNo(Long no) {
        return em.find(NoticeEntity.class, no);
    }

    public void deleteNoticeByNo(NoticeEntity entity) {
        //번호를 찾아가서 삭제해주기
//        NoticeEntity entity = em.find(NoticeEntity.class, no);
        em.remove(entity);
        //remove(삭제할 엔티티)
    }
}
