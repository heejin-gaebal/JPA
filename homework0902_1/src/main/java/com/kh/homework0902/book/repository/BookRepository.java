package com.kh.homework0902.book.repository;

import com.kh.homework0902.book.entity.BookEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    public void insert(BookEntity bookEntity) {
        this.em.persist(bookEntity);
    }

    public BookEntity selectOne(Long no) {
        return (BookEntity)this.em.find(BookEntity.class, no);
    }

    public List<BookEntity> selectList() {
        String jpql = "SELECT b FROM BookEntity b WHERE b.delYn = 'N' ORDER BY b.no DESC";
        return this.em.createQuery(jpql, BookEntity.class).getResultList();
    }
}
