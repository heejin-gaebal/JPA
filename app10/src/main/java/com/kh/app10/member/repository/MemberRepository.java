package com.kh.app10.member.repository;

import com.kh.app10.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
                                          // 제네릭으로 타입이랑 id(기본키) 준다
    //인터페이스이므로 추상메서드 사용 public 필요x
    //메서드 이름 기반으로 jpql이 작성되므로 메서드명을 잘 써야함,,,
    //jpql로 만들 필드를 파라미터에 적어준다
    MemberEntity findByUserIdAndDelYn(String userId, String delYn);
}
