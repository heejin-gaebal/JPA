package com.kh.homework0902.book.service;

import com.kh.homework0902.book.dto.BookDto;
import com.kh.homework0902.book.entity.BookEntity;
import com.kh.homework0902.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Long insert(BookDto dto) {
        BookEntity bookEntity = BookEntity.from(dto);
        this.bookRepository.insert(bookEntity);
        return bookEntity.getNo();
    }

    public BookDto selectOne(Long no) {
        BookEntity bookEntity = this.bookRepository.selectOne(no);
        return BookDto.from(bookEntity);
    }

    public List<BookDto> selectList() {
        List<BookEntity> bookEntityList = this.bookRepository.selectList();
        return bookEntityList.stream().map(BookDto::from).toList();
    }

    public BookDto update(Long no, BookDto dto) {
        BookEntity bookEntity = this.bookRepository.selectOne(no);
        bookEntity.update(dto);
        return BookDto.from(bookEntity);
    }

    public Long delete(Long no) {
        BookEntity bookEntity = this.bookRepository.selectOne(no);
        bookEntity.delete();
        return bookEntity.getNo();
    }
}
