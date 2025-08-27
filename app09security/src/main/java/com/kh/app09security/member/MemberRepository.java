package com.kh.app09security.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public MemberVo login(String userId){
//        em.createQuery(); 를 통해서,,, row 한개 조회
        //SELECT * FROM MEMBER WHERE USER_ID = ?
        MemberVo memberVo = new MemberVo();
        memberVo.setUserId("user01");
        memberVo.setUserPwd("$2a$12$5AxTxi0j3hcpxPLHYSxVk.paGb8WF/489XlnX1LdsBFM62sNIqqdu");
        memberVo.setUserNick("nick01");
        memberVo.setUserRole("ADMIN");

        return memberVo;
    }
}
