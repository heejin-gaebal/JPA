package com.kh.homework0902.book.api;

import com.kh.homework0902.book.dto.BookDto;
import com.kh.homework0902.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    //insert
    @PostMapping
    public Long insert(@RequestBody BookDto dto){
        return bookService.insert(dto);
    }

    //selectOne
    @GetMapping("{no}")
    public BookDto selectOne(@PathVariable Long no){
        return bookService.selectOne(no);
    }

    //selectList
    @GetMapping
    public List<BookDto> selectList(){
        return bookService.selectList();
    }

    //update
    @PutMapping("{no}")
    public BookDto update(@PathVariable Long no, @RequestBody BookDto dto){
        return bookService.update(no, dto);
    }

    //delete->soft delete
    @DeleteMapping("{no}")
    public Long delete(@PathVariable Long no){
        return bookService.delete(no);
    }

}
