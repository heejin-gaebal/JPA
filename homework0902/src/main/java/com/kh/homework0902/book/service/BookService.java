package com.kh.homework0902.book.service;

import com.kh.homework0902.book.dto.BookDto;
import com.kh.homework0902.book.entity.BookEntity;
import com.kh.homework0902.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    //insert
    public Long insert(BookDto dto) {
        BookEntity bookEntity = BookEntity.from(dto);
        bookRepository.insert(bookEntity);
        return bookEntity.getNo();
    }

    public BookDto selectOne(Long no) {
        BookEntity bookEntity = bookRepository.selectOne(no);
        return BookDto.from(bookEntity);
    }

    public List<BookDto> selectList() {
        List<BookEntity> bookEntityList = bookRepository.selectList();
        return bookEntityList.stream().map(BookDto::from).toList();
        //리스트를 여러함수를 쓰기위해 stream() 사용
        //stream 메서드를 쓰면 collection 형변환 -> map(요소하나씩 매칭/연관시킴) | filter등 함수 사용가능
    }

    public BookDto update(Long no, BookDto dto) {
        BookEntity bookEntity = bookRepository.selectOne(no);
        bookEntity.update(dto);
        return BookDto.from(bookEntity);
    }

    public Long delete(Long no) {
        BookEntity bookEntity = bookRepository.selectOne(no);
        bookEntity.delete();
        return bookEntity.getNo();
    }
}
