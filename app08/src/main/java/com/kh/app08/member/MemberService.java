package com.kh.app08.member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    
    public Long join(MemberDto dto) {
        MemberEntity memberEntity = MemberEntity.from(dto);
        memberRepository.join(memberEntity);
        return memberEntity.getNo();
    }

    public MemberDto login(MemberDto dto) {
        MemberEntity memberEntity = memberRepository.login(dto);
        MemberDto loginMember = MemberDto.from(memberEntity);
        return loginMember;
    }
}
