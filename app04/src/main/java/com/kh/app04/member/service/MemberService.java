package com.kh.app04.member.service;

import com.kh.app04.board.dto.BoardDto.BoardDto;
import com.kh.app04.member.dto.request.MemberJoinReqDto;
import com.kh.app04.member.dto.request.MemberLoginReqDto;
import com.kh.app04.member.dto.resp.MemberLoginRespDto;
import com.kh.app04.member.entity.MemberEntity;
import com.kh.app04.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(MemberJoinReqDto reqDto) {
        //엔티티매니저한테는 엔티티형태로 보내줘야함~
        MemberEntity entity = new MemberEntity();
        //entity에 값 세팅 필요
        entity.setUserId(reqDto.getUserId());
        entity.setUserPwd(reqDto.getUserPwd());
        entity.setUserNick(reqDto.getUserNick());
        repository.join(entity);
    }

    public MemberLoginRespDto login(MemberLoginReqDto reqDto) {
        MemberEntity entity = repository.findMemberEntityByUserInfo(reqDto);
        MemberLoginRespDto respDto = new MemberLoginRespDto();
        respDto.setUserId(entity.getUserId());
        respDto.setUserNick(entity.getUserNick());

        //엔티티를 dto로 변환 메서드 가져오기
        List<BoardDto> dtoList = entity.getBoardEntityList().stream().map(BoardDto::changeEntityToDto).toList();
        respDto.setBoardDtoList(dtoList);

        //엔티티에 들어있는 리스트 요소 하나씩 꺼내서 변환하기
        //다시 리스트화
        return respDto;
    }
}
