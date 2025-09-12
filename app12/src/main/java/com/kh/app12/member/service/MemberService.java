package com.kh.app12.member.service;

import com.kh.app12.member.dto.MemberDto;
import com.kh.app12.member.entity.MemberEntity;
import com.kh.app12.member.enums.DelYn;
import com.kh.app12.member.exception.MemberException;
import com.kh.app12.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void join(MemberDto.MemberReqDto dto) {
        checkValidation(dto);
        checkDuplication(dto.getUserId()); //아이디 중복체크

        MemberEntity memberEntity = MemberEntity.from(dto);
        memberRepository.save(memberEntity);
    }

    private void checkValidation(MemberDto.MemberReqDto reqDto){
        if(reqDto.getUserId() == null || reqDto.getUserId().isEmpty()){
            throw new MemberException("Member Id Error");
        }
        if(reqDto.getUserPwd() == null || reqDto.getUserPwd().isEmpty()){
            throw new MemberException("Member Pwd Error");
        }
        if(reqDto.getUserNick() == null || reqDto.getUserNick().isEmpty()){
            throw new MemberException("Member Nick Error");
        }
    }

    //아이디 중복체크
    private void checkDuplication(String userId) {
        Boolean isExist = memberRepository.existsByUserId(userId);
        if (isExist){
            new MemberException("이미 존재하는 ID 입니다");
        }
    }

    public MemberDto.MemberRespDto login(MemberDto.MemberReqDto dto) {
        MemberEntity memberEntity = memberRepository.findByUserIdAndDelYn(dto.getUserId(), DelYn.N);

        if(memberEntity==null){
            throw new MemberException("해당 계정 없음");
        }
        if(!memberEntity.getUserPwd().equals(dto.getUserPwd())){
            throw new MemberException("비밀번호 불일치");
        }
        return MemberDto.MemberRespDto.from(memberEntity);
    }
}
