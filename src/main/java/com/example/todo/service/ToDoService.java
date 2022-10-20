package com.example.todo.service;

import com.example.todo.entity.ToDo;

import java.util.List;

public interface ToDoService {

    //ToDo entity 대신에 DTO로 설정해도 됨
    //주의할 점은 ToDo엔티티를 받을 거라면 수정할 수 없도록 final로 설정해야 함 
    public List<ToDo> create(final ToDo toDo); //데이터 삽입
    
    public List<ToDo> retrieve(final String userId);    //UserId를 이용한 조회
    public List<ToDo> update(final ToDo toDo);    //데이터 수정
    public List<ToDo> delete(final ToDo toDo);    //데이터 삭제
    
    
    
}
