package com.kh.prac05.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Long join(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.from(memberDto);
        repository.join(memberEntity);
        return memberEntity.getNo();
    }

    public MemberDto login(MemberDto memberDto) {
        MemberEntity memberEntity = repository.login(memberDto);

        MemberDto loginMember = MemberDto.from(memberEntity);
        return loginMember;
    }
}
