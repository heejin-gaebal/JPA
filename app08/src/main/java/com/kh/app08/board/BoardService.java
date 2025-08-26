package com.kh.app08.board;

import com.kh.app08.member.MemberEntity;
import com.kh.app08.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long insert(BoardDto dto) {
        MemberEntity memberEntity = memberRepository.findByNo(dto.getWriterNo());
        BoardEntity boardEntity = BoardEntity.from(dto, memberEntity);
        boardRepository.insert(boardEntity);
        return boardEntity.getNo();
    }

    public List<BoardDto> listAll() {
        List<BoardEntity> boardEntityList = boardRepository.listAll();
        return boardEntityList.stream().map(BoardDto::from).toList();
    }

    public BoardDto listOneByNo(Long no) {
        BoardEntity boardEntity = boardRepository.listOneByNo(no);
        return BoardDto.from(boardEntity);
    }

    public void deleteBoardByNo(Long no, Long loginMemberNo) {
        BoardEntity boardEntity = boardRepository.listOneByNo(no);
        //작성자 검증 로직
        if(boardEntity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[BOARD-001]");
        }
        boardEntity.delete();
    }

    public void update(BoardDto dto, Long loginMemberNo) {
        BoardEntity boardEntity = boardRepository.listOneByNo(dto.getNo());
        if(boardEntity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[BOARD-002]");
        }
        boardEntity.update(dto);
    }
}
