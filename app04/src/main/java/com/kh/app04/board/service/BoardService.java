package com.kh.app04.board.service;

import com.kh.app04.board.dto.BoardDto.BoardDto;
import com.kh.app04.board.entity.BoardEntity;
import com.kh.app04.board.repository.BoardRepository;
import com.kh.app04.member.entity.MemberEntity;
import com.kh.app04.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;
    private final MemberRepository memberRepository;

    public void insert(BoardDto dto, String loginMemberID) {
        MemberEntity loginMemberEntity = memberRepository.getMemberUserId(loginMemberID);
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setWriter(loginMemberEntity);
        //다른 테이블의 컬럼을 가져와서 데이터 넣기
        
        repository.insert(entity);
    }

    public List<BoardEntity> list() {
        return repository.list();
    }
}
