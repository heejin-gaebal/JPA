package com.kh.prac02.member.repository;

import com.kh.prac02.member.dto.MemberDto;
import com.kh.prac02.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void join(MemberEntity memberEntity) {
        em.persist(memberEntity);
    }

    public MemberEntity login(MemberDto memberDto) {
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId = :userId AND m.userPwd = :userPwd";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("userId" , memberDto.getUserId())
                .setParameter("userPwd" , memberDto.getUserPwd())
                .getSingleResult();
    }
}

