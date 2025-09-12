package com.kh.app12.member.repository;

import com.kh.app12.member.entity.MemberEntity;
import com.kh.app12.member.enums.DelYn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    MemberEntity findByUserIdAndDelYn(String userId, DelYn delYn);

    boolean existsByUserId(String userId);
}
