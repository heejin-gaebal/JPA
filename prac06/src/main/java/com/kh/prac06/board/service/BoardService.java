package com.kh.prac06.board.service;

import com.kh.prac06.board.dto.BoardReqDto;
import com.kh.prac06.board.dto.BoardRespDto;
import com.kh.prac06.board.entity.BoardEntity;
import com.kh.prac06.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    //register
    public void register(BoardReqDto reqDto) {
        BoardEntity boardEntity = BoardEntity.from(reqDto);
        repository.save(boardEntity);
    }

    //retrieve
    public BoardRespDto retrieve(Long no) {
        BoardEntity boardEntity = repository.findById(no).get();
        return BoardRespDto.from(boardEntity);
    }

    //retrieveList
    public List<BoardRespDto> retrieveList() {
        List<BoardEntity> boardEntityList = repository.findAll();
        return boardEntityList.stream().map(BoardRespDto::from).toList();
    }

    //modify
    public BoardRespDto modify(BoardReqDto reqDto) {
        //일단 번노 찾기 req번호갖고와 옵셔너ㄹ이니까 get붙이기
        BoardEntity boardEntity = repository.findById(reqDto.getNo()).get();
        //엔티티에다가 업데이트
        boardEntity.modify(reqDto);
        return BoardRespDto.from(boardEntity);
    }

    //remove
    public BoardRespDto remove(BoardReqDto reqDto) {
        BoardEntity boardEntity = repository.findById(reqDto.getNo()).get();
        //엔티티에다가 리무브
        boardEntity.remove();
        return BoardRespDto.from(boardEntity);
    }
}
