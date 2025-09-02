package com.kh.homework0902.book.dto;

import com.kh.homework0902.book.entity.BookEntity;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class BookDto {
    private Long no;
    private String title;
    private String author;
    private Long price;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BookDto from(BookEntity bookEntity){
        BookDto bookDto = new BookDto();
        bookDto.no = bookEntity.getNo();
        bookDto.title = bookEntity.getTitle();
        bookDto.author = bookEntity.getAuthor();
        bookDto.price = bookEntity.getPrice();
        bookDto.delYn = bookEntity.getDelYn();
        bookDto.createdAt = bookEntity.getCreatedAt();
        bookDto.updatedAt = bookEntity.getUpdatedAt();
        return bookDto;
    }
}
