package com.kh.prac02.kakao.repository;

import com.kh.prac02.kakao.entity.KakaoEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class KakaoRepository {
    private final EntityManager em;

    // 저장
    public KakaoEntity save(KakaoEntity entity) {
        if (entity.getNo() == null) {
            em.persist(entity);  // 새로 저장
        } else {
            entity = em.merge(entity);  // 업데이트
        }
        return entity;
    }

    // 여러 개 저장
    public List<KakaoEntity> saveAll(List<KakaoEntity> entities) {
        for (KakaoEntity entity : entities) {
            save(entity);
        }
        return entities;
    }

    // ID로 조회
    public Optional<KakaoEntity> findById(Long no) {
        KakaoEntity entity = em.find(KakaoEntity.class, no);
        return Optional.ofNullable(entity);
    }

    // 모든 장소 조회
    public List<KakaoEntity> findAll() {
        String jpql = "SELECT k FROM KakaoEntity k ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class).getResultList();
    }

    // 장소명으로 검색 (부분 일치)
    public List<KakaoEntity> findByPlaceNameContaining(String keyword) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE k.placeName LIKE :keyword ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    // 카테고리명으로 검색 (부분 일치)
    public List<KakaoEntity> findByCategoryNameContaining(String category) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE k.categoryName LIKE :category ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("category", "%" + category + "%")
                .getResultList();
    }

    // 거리 기반 검색 (Haversine 공식)
    public List<KakaoEntity> findPlacesWithinDistance(Double latitude, Double longitude, Double distance) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE " +
                "6371 * acos(cos(radians(:lat)) * cos(radians(k.y)) * " +
                "cos(radians(k.x) - radians(:lon)) + sin(radians(:lat)) * " +
                "sin(radians(k.y))) <= :distance " +
                "ORDER BY 6371 * acos(cos(radians(:lat)) * cos(radians(k.y)) * " +
                "cos(radians(k.x) - radians(:lon)) + sin(radians(:lat)) * " +
                "sin(radians(k.y)))";

        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("lat", latitude)
                .setParameter("lon", longitude)
                .setParameter("distance", distance)
                .getResultList();
    }

    // 주소로 검색
    public List<KakaoEntity> findByAddressContaining(String address) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE " +
                "k.addressName LIKE :address OR k.roadAddressName LIKE :address " +
                "ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("address", "%" + address + "%")
                .getResultList();
    }

    // 전화번호로 검색
    public List<KakaoEntity> findByPhoneContaining(String phone) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE k.phone LIKE :phone ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("phone", "%" + phone + "%")
                .getResultList();
    }

    // 특정 지역 범위 내 장소 검색 (사각형 영역)
    public List<KakaoEntity> findByLocationRange(Double minX, Double maxX, Double minY, Double maxY) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE " +
                "k.x BETWEEN :minX AND :maxX AND k.y BETWEEN :minY AND :maxY " +
                "ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("minX", minX)
                .setParameter("maxX", maxX)
                .setParameter("minY", minY)
                .setParameter("maxY", maxY)
                .getResultList();
    }

    // 삭제
    public void deleteById(Long no) {
        KakaoEntity entity = em.find(KakaoEntity.class, no);
        if (entity != null) {
            em.remove(entity);
        }
    }

    // 전체 개수 조회
    public long count() {
        String jpql = "SELECT COUNT(k) FROM KakaoEntity k";
        return em.createQuery(jpql, Long.class).getSingleResult();
    }

    // 페이징 처리된 조회
    public List<KakaoEntity> findAllWithPaging(int page, int size) {
        String jpql = "SELECT k FROM KakaoEntity k ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    // 키워드로 통합 검색 (장소명, 주소, 카테고리)
    public List<KakaoEntity> searchByKeyword(String keyword) {
        String jpql = "SELECT k FROM KakaoEntity k WHERE " +
                "k.placeName LIKE :keyword OR " +
                "k.addressName LIKE :keyword OR " +
                "k.roadAddressName LIKE :keyword OR " +
                "k.categoryName LIKE :keyword " +
                "ORDER BY k.createAt DESC";
        return em.createQuery(jpql, KakaoEntity.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
}
