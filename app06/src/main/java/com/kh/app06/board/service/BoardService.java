package com.kh.app06.board.service;

import com.kh.app06.board.dto.BoardDto;
import com.kh.app06.board.entity.BoardEntity;
import com.kh.app06.board.repository.BoardRepository;
import com.kh.app06.member.entity.MemberEntity;
import com.kh.app06.member.repository.MemberRepository;
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

    public void insert(BoardDto dto) {
        MemberEntity memberEntity = memberRepository.findMemberByNo(dto.getWriterNo());
        BoardEntity entity = BoardEntity.from(dto,memberEntity);
        //entity.setWriter(memberEntity); 엔티티만들때 파라미터로 같이 넘겨주기
        repository.insert(entity);
    }

    public BoardDto listOne(Long no) {
        BoardEntity entity = repository.listOne(no);
        return BoardDto.from(entity);
    }

    public List<BoardDto> boardAllList() {
        List<BoardEntity> boardEntityList = repository.boardAllList();
        return boardEntityList.stream().map(BoardDto::from).toList();
    }
}
