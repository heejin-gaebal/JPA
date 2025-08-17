package com.hj.prac01.member.repository;

import com.hj.prac01.member.dto.ReqMemberDto;
import com.hj.prac01.member.entity.MemberEntity;
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
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId= :userId ANd m.userPwd = :userPwd";
        return em.createQuery(jpql, MemberEntity.class)
                .setParameter("userId", reqDto.getUserId())
                .setParameter("userPwd", reqDto.getUserPwd())
                .getSingleResult();
    }
}
