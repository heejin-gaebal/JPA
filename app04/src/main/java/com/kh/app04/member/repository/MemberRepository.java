package com.kh.app04.member.repository;

import com.kh.app04.member.dto.request.MemberJoinReqDto;
import com.kh.app04.member.dto.request.MemberLoginReqDto;
import com.kh.app04.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void join(MemberEntity entity) {
        em.persist(entity);
    }

    public MemberEntity findMemberEntityByUserInfo(MemberLoginReqDto reqDto) {
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId = :x AND m.userPwd = :y";
        return em
                .createQuery(jpql, MemberEntity.class)
                .setParameter("x", reqDto.getUserId())
                .setParameter("y", reqDto.getUserPwd())
                .getSingleResult();
    }

    //연관관계 맵핑
    public MemberEntity getMemberUserId(String loginMemberID) {
        String jpql = "SELECT m FROM MemberEntity m WHERE m.userId = :x";
        return em
                .createQuery(jpql,MemberEntity.class)
                .setParameter("x", loginMemberID)
                .getSingleResult();
    }
}
