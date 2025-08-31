package com.kh.prac05.board;

import com.kh.prac05.category.CategoryEntity;
import com.kh.prac05.category.CategoryRepository;
import com.kh.prac05.member.MemberEntity;
import com.kh.prac05.member.MemberRepository;
import com.kh.prac05.util.AttachFileDto;
import com.kh.prac05.util.AttachFileEntity;
import com.kh.prac05.util.AttachFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    public Long insert(BoardDto boardDto) {
        MemberEntity memberEntity =  memberRepository.findByNo(boardDto.getWriterNo());
        CategoryEntity categoryEntity = categoryRepository.findByCateNo(boardDto.getCategoryNo());
        BoardEntity boardEntity = BoardEntity.from(boardDto, memberEntity, categoryEntity);

        repository.insert(boardEntity);
        return boardDto.getNo();
    }

    public List<BoardDto> list() {
        List<BoardEntity> boardEntityList = repository.list();
        return boardEntityList.stream().map(BoardDto::from).toList();

    }

    public BoardDto listOne(Long no) {
        BoardEntity boardEntity = repository.listOne(no);
        return BoardDto.from(boardEntity);
    }

    public void update(BoardDto boardDto, Long loginMemberNo) {
        BoardEntity boardEntity = repository.listOne(boardDto.getNo());
        if(boardEntity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[Board-001]:update 실패");
        }
        boardEntity.update(boardDto);
    }

    public void deleteNo(Long no, Long loginMemberNo) {
        BoardEntity boardEntity = repository.listOne(no);
        if(boardEntity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[Board-002]:delete 실패");
        }
        boardEntity.delete();
    }
}
