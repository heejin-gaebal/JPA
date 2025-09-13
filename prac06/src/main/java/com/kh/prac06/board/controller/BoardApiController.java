package com.kh.prac06.board.controller;

import com.kh.prac06.board.dto.BoardReqDto;
import com.kh.prac06.board.dto.BoardRespDto;
import com.kh.prac06.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    //register 등록
    @PostMapping
    public ResponseEntity<String> register(@RequestBody BoardReqDto reqDto){
        service.register(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body("게시글 등록 성공!");
    }

    //retrieve 단건 조회
    @GetMapping("{no}")
    public ResponseEntity<BoardRespDto> retrieve (@PathVariable Long no){
        BoardRespDto respDto = service.retrieve(no);
        return ResponseEntity.status(HttpStatus.OK).body(respDto);
    }

    //retrieveList 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardRespDto>> retrieveList(){
        List<BoardRespDto> respDtoList = service.retrieveList();
        return ResponseEntity.status(HttpStatus.OK).body(respDtoList);
    }

    //modify 수정
    @PutMapping
    public ResponseEntity<BoardRespDto> modify(@RequestBody BoardReqDto reqDto){
        BoardRespDto respDto = service.modify(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body(respDto);
    }

    //remove 삭제(soft)
    @DeleteMapping
    public ResponseEntity<BoardRespDto> remove(@RequestBody BoardReqDto reqDto){
        BoardRespDto respDto = service.remove(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body(respDto);
    }
}
