package com.example.todo.controller;

import com.example.todo.domain.ResponseDTO;
import com.example.todo.domain.ToDoDTO;
import com.example.todo.entity.ToDo;
import com.example.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;

    //데이터 삽입    //http://localhost:8080/todo에 post방식으로 title만 설정 후 send
    @PostMapping
    public ResponseEntity<?> createToDo(@RequestBody ToDoDTO dto){
        try {
            //가상의 유저 아이디 생성 (아직 로그인 없으므로)
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.create(toDo);

            //ToDo를 ToDoDTO로 변환
            //ToDoDTO의 생성자를 이용해서 변환 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            String error = e.getMessage();
            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();

            return ResponseEntity.badRequest().body(response);
        }
    }

    //ID로 조회
    @GetMapping
    public ResponseEntity<?> retriveToDoList(){
        
        //임시 ID
        String temporaryUserId = "temporary-user";
        
        //임시 아이디로 데이터 찾아오기
        List<ToDo> entities = toDoService.retrieve(temporaryUserId);
        
        //찾아온 데이터를 이용해서 DTO의 List만들기
        List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
        
        //응답 객체 생성
        ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);  //클라이언트에게 전송
    }

    //데이터 수정    //http://localhost:8080/todo에 put 후 id, title, done
    @PutMapping
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO dto){

        try {
            //가상의 유저 아이디 생성 (아직 로그인 없으므로)
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.update(toDo);

            //ToDo를 ToDoDTO로 변환
            //ToDoDTO의 생성자를 이용해서 변환 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            String error = e.getMessage();
            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();

            return ResponseEntity.badRequest().body(response);
        }
    }

    //데이터 삭제    //http://localhost:8080/todo에 delete 방식으로 id
    @DeleteMapping
    public ResponseEntity<?> deleteToDo(@RequestBody ToDoDTO dto){

        try {
            //가상의 유저 아이디 생성 (아직 로그인 없으므로)
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.delete(toDo);

            //ToDo를 ToDoDTO로 변환
            //ToDoDTO의 생성자를 이용해서 변환 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            String error = e.getMessage();
            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();

            return ResponseEntity.badRequest().body(response);
        }
    }

}
