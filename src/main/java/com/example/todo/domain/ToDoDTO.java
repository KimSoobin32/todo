package com.example.todo.domain;

import com.example.todo.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {
    private String id;
    private String title;
    private boolean done;
    //userId는 로그인 시 사용할거라 빼놓음..

    //entity를 받아서 dto 인스턴스를 생성해주는 생성자
    public ToDoDTO(ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }

    //dto 인스턴스를 entity 인스턴스로 변화해주는 메서드
    public static ToDo toEntity(ToDoDTO dto){
        return ToDo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }

}
