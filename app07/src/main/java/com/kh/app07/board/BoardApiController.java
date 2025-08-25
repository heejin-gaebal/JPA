package com.kh.app07.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    //insert
    @PostMapping
    public Long insert(@RequestBody BoardDto dto){
        Long loginMemberNo = 1L;
        dto.setWriterNo(loginMemberNo);
        return service.insert(dto);
    }

    //listOne
    @GetMapping("{no}")
    public BoardDto findBoardByNo(@PathVariable Long no){
        return service.findBoardByNo(no);
    }

    //list
    @GetMapping
    public List<BoardDto> findBoardAll(){
        return service.findBoardAll();
    }

    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        service.delete(no);
    }

    @PutMapping
    public void updateBoard(@RequestBody BoardDto dto){
        service.update(dto);
    }
}
