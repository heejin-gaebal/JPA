package com.hj.prac01.board.service;

import com.hj.prac01.board.entity.BoardEntity;
import com.hj.prac01.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    //게시글 등록
    public void insert(BoardEntity entity) {
        repository.insert(entity);
    }

    //게시글 목록
    public List<BoardEntity> list() {
        return repository.list();
    }

    //게시글 단건조회
    public BoardEntity listOne(Long no) {
        return repository.listOne(no);
    }

    //게시글 수정
    public void update(BoardEntity vo) {
        Long no = vo.getNo();
        String title = vo.getTitle();
        String content = vo.getContent();

        BoardEntity entity = repository.listOne(no);
        entity.setTitle(title);
        entity.setContent(content);
    }

    public void delete(Long no) {
        BoardEntity entity = repository.listOne(no);
        repository.delete(entity);
    }
}
