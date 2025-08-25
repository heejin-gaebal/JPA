package com.kh.app07.member;

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
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId = :userId AND m.userPwd = :userPwd AND m.delYn = 'N'";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("userId" , memberDto.getUserId())
                .setParameter("userPwd" , memberDto.getUserPwd())
                .getSingleResult();
    }

    public MemberEntity findMemberByNo(Long writerNo) {
        return em.find(MemberEntity.class, writerNo);
    }
}
