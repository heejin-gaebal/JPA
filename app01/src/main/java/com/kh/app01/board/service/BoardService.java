package com.kh.app01.board.service;

import com.kh.app01.board.entity.BoardEntity;
import com.kh.app01.board.repository.BoardRepository;
import com.kh.app01.notice.entity.NoticeEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    public void insert(BoardEntity entity) {
        repository.insert(entity);
    }

    public BoardEntity getBoardByNo(Long no) {
        return repository.getBoardByNo(no);
    }

    public List<BoardEntity> getBoardAll() {
        return repository.getBoardAll();
    }

    public void deleteBoardByNo(Long no) {
        BoardEntity entity = repository.getBoardByNo(no);
        entity.setDelYn("Y");
    }
}
