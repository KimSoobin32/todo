package com.example.todo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")   //테이블 이름 바꾸고 싶을 때
public class ToDo extends BaseEntity{   //마지막 수정 날짜, 삽입날짜도 같이 들어옴
    
    //랜덤한 UUID를 가지고 아이디값을 생성
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;  //기본키로 사용할 아이디

    @Column(length = 100, nullable = false)
    private String userId;  //사용자 식별을 위한 아이디

    @Column(length = 500, nullable = false)
    private String title;   //제목

    @Column(nullable = false)
    private boolean done;    //수행 여부
}
