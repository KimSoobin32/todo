package com.example.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass   //entity를 별도로 생성하지 않는 클래스
@EntityListeners(value = {AuditingEntityListener.class})    //jpa를 감시하고 있다가 동작하도록 설정
@Getter
public abstract class BaseEntity {  //abstract : 인스턴스 만들지 않음
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedBy
    @Column(name = "moddate")
    private LocalDateTime modDate;

}
