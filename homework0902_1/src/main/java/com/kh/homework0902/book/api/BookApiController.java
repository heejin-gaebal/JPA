package com.kh.homework0902.book.api;

import com.kh.homework0902.book.dto.BookDto;
import com.kh.homework0902.book.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/book"})
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @PostMapping
    public Long insert(@RequestBody BookDto dto) {
        return this.bookService.insert(dto);
    }

    @GetMapping({"{no}"})
    public BookDto selectOne(@PathVariable Long no) {
        return this.bookService.selectOne(no);
    }

    @GetMapping
    public List<BookDto> selectList() {
        return this.bookService.selectList();
    }

    @PutMapping({"{no}"})
    public BookDto update(@PathVariable Long no, @RequestBody BookDto dto) {
        return this.bookService.update(no, dto);
    }

    @DeleteMapping({"{no}"})
    public Long delete(@PathVariable Long no) {
        return this.bookService.delete(no);
    }
}