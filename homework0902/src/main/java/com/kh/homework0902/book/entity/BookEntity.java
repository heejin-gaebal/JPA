package com.kh.homework0902.book.entity;

import com.kh.homework0902.book.dto.BookDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String author;

    @Column(nullable = false)
    private Long price;

    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BookEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public static BookEntity from(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.title = bookDto.getTitle();
        bookEntity.author = bookDto.getAuthor();
        bookEntity.price = bookDto.getPrice();
        return bookEntity;
    }

    public void update(BookDto dto) {
        title = dto.getTitle();
        author = dto.getAuthor();
        price = dto.getPrice();
        updatedAt = LocalDateTime.now();
    }

    public void delete() {
        delYn = "Y";
        updatedAt = LocalDateTime.now();
    }
}
