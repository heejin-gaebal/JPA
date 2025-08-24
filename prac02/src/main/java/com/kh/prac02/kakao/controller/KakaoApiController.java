package com.kh.prac02.kakao.controller;

import com.kh.prac02.kakao.entity.KakaoEntity;
import com.kh.prac02.kakao.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kakao")
@RequiredArgsConstructor
public class KakaoApiController {
    private final KakaoService service;

    @GetMapping("/search")
    public ResponseEntity<List<KakaoEntity>> searchPlaces(@RequestParam String keyword) {
        try {
            List<KakaoEntity> places = service.searchAndSavePlaces(keyword);
            return ResponseEntity.ok(places);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/places")
    public ResponseEntity<List<KakaoEntity>> getAllPlaces() {
        List<KakaoEntity> places = service.getAllPlaces();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<KakaoEntity>> getNearbyPlaces(
            @RequestParam Double lat,
            @RequestParam Double lon,
            @RequestParam(defaultValue = "1.0") Double distance) {
        List<KakaoEntity> places = service.findNearbyPlaces(lat, lon, distance);
        return ResponseEntity.ok(places);
    }
}
