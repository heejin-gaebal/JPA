package com.kh.app05.member.repository;

import com.kh.app05.member.dto.MemberDto;
import com.kh.app05.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity findById(Long writerNo) {
        return em.find(MemberEntity.class, writerNo);
    }

    public MemberEntity login(MemberDto mDto) {
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId = :x AND m.userPwd = :y";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("x" , mDto.getUserId())
                .setParameter("y" , mDto.getUserPwd())
                .getSingleResult();
    }

    public List<MemberEntity> findAllMember() {
        String jpql = "SELECT m FROM MemberEntity m";
         return em
                .createQuery(jpql, MemberEntity.class)
                .getResultList();
    }
}
