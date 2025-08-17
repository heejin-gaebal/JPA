package com.hj.prac01.gallery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "GALLERY")
@SequenceGenerator(name = "gallery_seq_gen", sequenceName = "SEQ_GALLERY", allocationSize = 1)
public class GalleryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gallery_seq_gen")
    private Long no;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String delYn;

    public GalleryEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
}
