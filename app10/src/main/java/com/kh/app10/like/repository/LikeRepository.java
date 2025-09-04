package com.kh.app10.like.repository;

import com.kh.app10.like.entity.LikeEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

}
