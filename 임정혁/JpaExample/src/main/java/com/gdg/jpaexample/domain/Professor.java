package com.gdg.jpaexample.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;

    @Builder
    public Professor(String name, String email, Major major) {
        this.name = name;
        this.email = email;
        this.major = major;
    }

    public void update(String name, String email, Major major) {
        this.name = name;
        this.email = email;
        this.major = major;
    }
}

