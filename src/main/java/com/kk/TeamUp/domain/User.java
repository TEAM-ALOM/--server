package com.kk.TeamUp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="major", nullable = false)
    private String major;

    @Column(name="position")
    private String position;

    @Column(name="record")
    private String record;

    @Column(name="penalty")
    private Long penalty;

    @Column(name="schedule")
    private String schedule;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt; //계정 생성 시간

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt; //계정 마지막 로그인 시간

    @Builder
    public User(String name, String major, String position, String record, Long penalty, String schedule) {
        this.name=name;
        this.major=major;
        this.position=position;
        this.record=record;
        this.penalty=penalty;
        this.schedule=schedule;
    }

}
