package com.kh.homework0902.book.entity;

import com.kh.homework0902.book.dto.BookDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.Getter;

@Entity
@Getter
@Table(
        name = "BOOK"
)
public class BookEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long no;
    @Column(
            nullable = false
    )
    private String title;
    @Column(
            nullable = false,
            unique = true
    )
    private String author;
    @Column(
            nullable = false
    )
    private Long price;
    private String delYn = "N";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static BookEntity from(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.title = bookDto.getTitle();
        bookEntity.author = bookDto.getAuthor();
        bookEntity.price = bookDto.getPrice();
        return bookEntity;
    }

    public void update(BookDto dto) {
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.price = dto.getPrice();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}