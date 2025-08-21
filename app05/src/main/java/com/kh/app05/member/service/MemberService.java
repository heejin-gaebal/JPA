package com.kh.app05.member.service;

import com.kh.app05.member.dto.MemberDto;
import com.kh.app05.member.entity.MemberEntity;
import com.kh.app05.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(MemberDto mDto) {
        //dto -> entity 로 변환해주는 생성자함수 호출함
        MemberEntity entity = MemberEntity.from(mDto);
        repository.join(entity);
    }

    public MemberDto login(MemberDto mDto) {
        MemberEntity entity = repository.login(mDto);
        //entity -> dto
        MemberDto respDto = MemberDto.from(entity);
        return respDto;
    }

    //entity를 받는 리스트
    public List<MemberDto> findAllMember() {
        List<MemberEntity> memberEntityList = repository.findAllMember();
//        memberEntityList.stream().map((memberEntity)->{
//            return MemberDto.from(memberEntity);
//        })
        List<MemberDto> memberDtoList =  memberEntityList.stream().map(MemberDto::from).toList();
        //엔티티리스트 -> dto리스트
        return memberDtoList;
    }
}
