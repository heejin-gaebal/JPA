package com.hj.prac01.member.service;

import com.hj.prac01.member.dto.ReqMemberDto;
import com.hj.prac01.member.dto.RespMemberDto;
import com.hj.prac01.member.entity.MemberEntity;
import com.hj.prac01.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(ReqMemberDto reqDto) {
        MemberEntity entity = new MemberEntity();
        entity.setUserId(reqDto.getUserId());
        entity.setUserPwd(reqDto.getUserPwd());
        entity.setUserNick(reqDto.getUserNick());
        repository.join(entity);
    }

    public RespMemberDto login(ReqMemberDto reqDto) {
        MemberEntity entity = repository.login(reqDto);
        RespMemberDto respDto =  new RespMemberDto();
        respDto.setUserNick(entity.getUserNick());
        return  respDto;
    }
}
