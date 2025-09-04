package com.kh.app10.board.service;

import com.kh.app10.board.dto.BoardReqDto;
import com.kh.app10.board.dto.BoardRespDto;
import com.kh.app10.board.entity.BoardEntity;
import com.kh.app10.board.repository.BoardRepository;
import com.kh.app10.member.entity.MemberEntity;
import com.kh.app10.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void save(BoardReqDto reqDto, String userId) {
        MemberEntity memberEntity = memberRepository.findByUserIdAndDelYn(userId, "N");
        BoardEntity boardEntity = BoardEntity.from(reqDto, memberEntity);
        boardRepository.save(boardEntity);
    }

    public BoardRespDto findBoardByNo(Long no) {
        //Optional : null값을 방지하는 매퍼역할 optional 타입은 get해서 꺼내와야 함
        BoardEntity boardEntity = boardRepository.findById(no).get();
        return BoardRespDto.from(boardEntity);
    }

    public List<BoardRespDto> findBoardAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAllWithLikeEntityAndMemberEntity();
        return boardEntityList.stream().map(BoardRespDto::from).toList();
    }

    public void updateBoard(BoardReqDto reqDto, Long no) {
        BoardEntity boardEntity = boardRepository.findById(no).get();
        boardEntity.update(reqDto);
    }

    public void deleteBoard(Long no) {
        BoardEntity boardEntity = boardRepository.findById(no).get();
        boardEntity.delete();
    }
}
