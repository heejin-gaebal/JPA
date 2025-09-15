package com.kh.app14.board.service;

import com.kh.app14.board.dto.request.BoardReqDto;
import com.kh.app14.board.dto.response.BoardRespDto;
import com.kh.app14.board.entity.BoardEntity;
import com.kh.app14.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardReqDto reqDto) {
        BoardEntity entity = reqDto.toEntity();
        boardRepository.save(entity);
    }

    public List<BoardRespDto> retrieveList() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        return boardEntityList.stream().map(BoardRespDto::from).toList();
        //list->dto변환
    }
}
