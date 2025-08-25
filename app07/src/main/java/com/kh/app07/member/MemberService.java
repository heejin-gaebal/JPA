package com.kh.app07.member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.from(memberDto);
        memberRepository.join(memberEntity);
        return memberEntity.getNo();
    }

    public MemberDto login(MemberDto memberDto) {
        MemberEntity memberEntity = memberRepository.login(memberDto);
        return MemberDto.from(memberEntity);

    }
}
