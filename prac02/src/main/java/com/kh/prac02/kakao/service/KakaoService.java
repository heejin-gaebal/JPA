package com.kh.prac02.kakao.service;

import com.kh.prac02.kakao.dto.KakaoPlace;
import com.kh.prac02.kakao.dto.KakaoSearchResponse;
import com.kh.prac02.kakao.entity.KakaoEntity;
import com.kh.prac02.kakao.repository.KakaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoRepository repository;
    private final WebClient webClient;

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public List<KakaoEntity> searchAndSavePlaces(String keyword) {
        try {
            // 카카오 API 호출
            KakaoSearchResponse response = webClient.get()
                    .uri("/v2/local/search/keyword.json?query={keyword}", keyword)
                    .retrieve()
                    .bodyToMono(KakaoSearchResponse.class)
                    .block();

            if (response == null || response.getDocuments() == null) {
                return List.of();
            }

            // Entity로 변환하여 저장
            List<KakaoEntity> entities = response.getDocuments().stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList());

            return repository.saveAll(entities);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("카카오 API 호출 실패: " + e.getMessage());
        }
    }

    private KakaoEntity convertToEntity(KakaoPlace place) {
        KakaoEntity entity = new KakaoEntity();
        entity.setPlaceName(place.getPlaceName());
        entity.setCategoryName(place.getCategoryName());
        entity.setAddressName(place.getAddressName());
        entity.setRoadAddressName(place.getRoadAddressName());
        entity.setPhone(place.getPhone());
        entity.setPlaceUrl(place.getPlaceUrl());

        // String을 Double로 변환
        if (place.getX() != null && !place.getX().isEmpty()) {
            entity.setX(Double.parseDouble(place.getX()));
        }
        if (place.getY() != null && !place.getY().isEmpty()) {
            entity.setY(Double.parseDouble(place.getY()));
        }

        return entity;
    }

    public List<KakaoEntity> getAllPlaces() {
        return repository.findAll();
    }

    public List<KakaoEntity> findNearbyPlaces(Double lat, Double lon, Double distance) {
        return repository.findPlacesWithinDistance(lat, lon, distance);
    }

    public List<KakaoEntity> searchByKeyword(String keyword) {
        return repository.searchByKeyword(keyword);
    }

    public List<KakaoEntity> findByCategory(String category) {
        return repository.findByCategoryNameContaining(category);
    }
}