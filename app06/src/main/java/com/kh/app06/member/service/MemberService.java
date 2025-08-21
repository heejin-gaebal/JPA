package com.kh.app06.member.service;

import com.kh.app06.member.dto.MemberDto;
import com.kh.app06.member.entity.MemberEntity;
import com.kh.app06.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        repository.join(entity);
    }

    //repo에서 객체 가져와서 리턴
    public MemberDto login(MemberDto dto) {
        MemberEntity entity = repository.login(dto);
        //entity -> loginMemberDto
        return MemberDto.from(entity);
    }

    public List<MemberDto> findAllMember() {
        List<MemberEntity> memberEntityList = repository.findAllMember();
        return memberEntityList.stream().map(MemberDto::from).toList();

    }
}
