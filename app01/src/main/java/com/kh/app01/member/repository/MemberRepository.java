package com.kh.app01.member.repository;

import com.kh.app01.member.dto.ReqMemberDto;
import com.kh.app01.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity login(ReqMemberDto reqDto) {
        String jpql = """
                SELECT m FROM MemberEntity m WHERE m.userId = :userId AND m.userPwd = :userPwd
                """;
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("userId", reqDto.getUserId())
                .setParameter("userPwd", reqDto.getUserPwd())
                .getSingleResult();
    }
}
