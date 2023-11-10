package com.example.semi_2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity { // 추상 클래스

    /**
     * 생성 시각
     */
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * 수정 시각
     */
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
