package com.kh.app07.board;

import com.kh.app07.member.MemberEntity;
import com.kh.app07.member.MemberRepository;
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

    public Long insert(BoardDto dto) {
        //biz
        validateData(dto);
        //dto가 갖고있는 작성자 번호찾기
        MemberEntity memberEntity = memberRepository.findMemberByNo(dto.getWriterNo());
        BoardEntity boardEntity = BoardEntity.from(dto, memberEntity);
        repository.insert(boardEntity);
        return boardEntity.getNo();
    }

    //biz 메서드
    private void validateData(BoardDto dto) {
        if(dto.getTitle() == null || dto.getTitle().length() < 1){
            throw new IllegalArgumentException("check title!!");
        }
        if(dto.getContent() == null || dto.getTitle().length() < 1){
            throw new IllegalArgumentException("check content!!");
        }
    }

    public BoardDto findBoardByNo(Long no) {
        BoardEntity entity = repository.findBoardByNo(no);
        return BoardDto.from(entity);
    }

    public List<BoardDto> findBoardAll() {
        List<BoardEntity> boardEntityList = repository.findBoardAll();
        //리스트 -> 스트림변환 -> BoardDto의 요소로 변환 -> 다시 리스트로 변환
        return boardEntityList.stream().map(BoardDto::from).toList();
    }

    public void delete(Long no) {
        BoardEntity entity = repository.findBoardByNo(no);
        entity.delete();
    }

    public void update(BoardDto dto) {
        BoardEntity entity = repository.findBoardByNo(dto.getNo());
        entity.update(dto);
    }
}
