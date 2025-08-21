package com.kh.app05.board.service;

import com.kh.app05.board.dto.BoardDto;
import com.kh.app05.board.entity.BoardEntity;
import com.kh.app05.board.repository.BoardRepository;
import com.kh.app05.member.entity.MemberEntity;
import com.kh.app05.member.repository.MemberRepository;
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

    public void insert(BoardDto bDto) {
        Long writerNo = bDto.getWriterNo();
        MemberEntity memberEntity = memberRepository.findById(writerNo);
        //bDto.setWriter(memberEntity);
        //dto -> entity 로 변환해주는 생성자함수 호출함
        BoardEntity entity = BoardEntity.from(bDto,memberEntity);

        //연관관계컬럼 값 채우기
        repository.insert(entity);
    }

    public List<BoardDto> findBoardAll() {
        //엔티티 -> 엔티티리스트로 변환
        List<BoardEntity> entityList =  repository.findBoardAll();
        return entityList.stream().map(BoardDto::from).toList();
    }

    public BoardDto findBoardByNo(Long no) {
        BoardEntity entity = repository.findBoardByNo(no);
        return BoardDto.from(entity);
    }

    public void deleteBoardByNo(Long no) {
        //조회넘버 엔티티로 받기
        BoardEntity entity = repository.findBoardByNo(no);
        entity.delete();
    }
}
