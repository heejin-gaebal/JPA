package com.kh.app10.member.service;

import com.kh.app10.member.dto.MemberReqDto;
import com.kh.app10.member.dto.MemberRespDto;
import com.kh.app10.member.entity.MemberEntity;
import com.kh.app10.member.exception.MemberException;
import com.kh.app10.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    
    //회원가입
    public void join(MemberReqDto reqDto) {
        MemberEntity memberEntity = MemberEntity.from(reqDto);
        memberRepository.save(memberEntity);
    }

    //로그인
    public MemberRespDto login(MemberReqDto reqDto) {
        //Id를 가져오고 그의 pwd와 DB의 pwd를 equals 비교
        MemberEntity memberEntity = memberRepository.findByUserIdAndDelYn(reqDto.getUserId(), "N");
        if(!memberEntity.getUserPwd().equals(reqDto.getUserPwd())){
            throw new MemberException("PASSWORD NOT MATCH!!");
        }
        return MemberRespDto.from(memberEntity); //dto로 변환해서 리턴
    }
}
