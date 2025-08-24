package com.kh.prac02.member.service;

import com.kh.prac02.member.dto.MemberDto;
import com.kh.prac02.member.entity.MemberEntity;
import com.kh.prac02.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    
    public void join(MemberDto memberDto) {
        //dto->entity
        MemberEntity memberEntity = MemberEntity.from(memberDto);
        memberRepository.join(memberEntity);
    }

    public MemberDto login(MemberDto memberDto) {
        //entity -> dto
        MemberEntity entity = memberRepository.login(memberDto);
        return MemberDto.from(entity);
    }
}
