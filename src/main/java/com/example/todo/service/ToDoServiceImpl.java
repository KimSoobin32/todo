package com.example.todo.service;

import com.example.todo.entity.ToDo;
import com.example.todo.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;

    //유효성 검사를 위한 메서드 (아이디 검사)
    private void validate(final ToDo toDo){
        if(toDo == null){
            throw new RuntimeException("ToDo cannot be null");
        }
        if(toDo.getUserId() == null){
            throw new RuntimeException("UserId cannot be null");
        }
    }

    @Override
    public List<ToDo> create(ToDo toDo) {
        validate(toDo);
        toDoRepository.save(toDo);  //데이터 추가
        return toDoRepository.findByUserId(toDo.getUserId());   //삽입 후 데이터 자신의 데이터 목록을 리턴
    }

    @Override
    public List<ToDo> retrieve(String userId) {
        return toDoRepository.findByUserId(userId);
    }

    @Override
    public List<ToDo> update(ToDo toDo) {
        validate(toDo);
        toDoRepository.save(toDo);  //데이터 수정
        return toDoRepository.findByUserId(toDo.getUserId());   //수정 후 데이터 자신의 데이터 목록을 리턴
    }

    @Override
    public List<ToDo> delete(ToDo toDo) {
        validate(toDo);
        toDoRepository.delete(toDo);  //데이터 삭제
        return toDoRepository.findByUserId(toDo.getUserId());   //삭제 후 데이터 자신의 데이터 목록을 리턴
    }
}
