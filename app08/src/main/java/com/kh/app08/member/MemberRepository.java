package com.kh.app08.member;

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

    public MemberEntity login(MemberDto dto) {
        String jpql =
                "SELECT m FROM MemberEntity m WHERE m.userId = :userId AND m.userPwd = :userPwd AND m.delYn = 'N'";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("userId" , dto.getUserId())
                .setParameter("userPwd" , dto.getUserPwd())
                .getSingleResult();
    }

    public MemberEntity findByNo(Long writerNo) {
        return em.find(MemberEntity.class, writerNo);
    }
}
