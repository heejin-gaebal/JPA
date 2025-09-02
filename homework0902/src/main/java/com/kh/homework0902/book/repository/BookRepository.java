package com.kh.homework0902.book.repository;

import com.kh.homework0902.book.entity.BookEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    //insert
    public void insert(BookEntity bookEntity) {
        em.persist(bookEntity);
    }

    //listOne
    public BookEntity selectOne(Long no) {
        return em.find(BookEntity.class, no);
    }

    public List<BookEntity> selectList() {
        String jpql = "SELECT b FROM BookEntity b WHERE b.delYn = 'N' ORDER BY b.no DESC";
        return em
                .createQuery(jpql, BookEntity.class)
                .getResultList();
    }
}
