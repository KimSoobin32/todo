package com.example.todo;

import com.example.todo.entity.ToDo;
import com.example.todo.persistence.ToDoRepository;
import com.example.todo.service.ToDoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ToDoTest {

    @Autowired
    private ToDoRepository toDoRepository;

    //데이터 삽입 테스트
    @Test
    @Disabled
    public void testInsert(){
        ToDo todo1 = ToDo.builder()
                .userId("adam")
                .title("서점 가기")
                .build();
        toDoRepository.save(todo1);

        ToDo todo2 = ToDo.builder()
                .userId("adam")
                .title("삼척 여행")
                .build();
        toDoRepository.save(todo2);
    }

    //유저 아이디를 이용한 조회
    //@Test
    public void testFindUserId(){
        List<ToDo> list = toDoRepository.findByUserId("adam");

        //2가지 방법
//        for(ToDo toDo : list){
//            System.out.println(toDo);
//        }

        list.stream().forEach(toDo -> {
            System.out.println(toDo);
        });
    }

    //id에 해당하는 하나의 데이터 조회
    //데이터베이스에서 id를 조회해서 테스트
    //@Test
    public void testDetail(){
        Optional<ToDo> result = toDoRepository.findById("402881c783f3897d0183f38986720000");
        if(result.isPresent()){
            System.out.println(result.get());
        }else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }

    //데이터 수정
    //@Test
    public void testUpdate(){   //이미 있는 id 넣으면 자동으로 수정됨..
        ToDo todo = ToDo.builder()
                .id("402881c783f3897d0183f38986720000")
                .userId("아담")
                .title("오목교 교보 가기")
                .done(true)
                .build();
        toDoRepository.save(todo);
    }

    //데이터 삭제
    //@Test
    public void testDelete(){   //이미 있는 id 넣으면 자동으로 수정됨..

        toDoRepository.deleteById("402881c783f3897d0183f38986720000");
    }

    @Autowired
    private ToDoService toDoService;

    //삽입 테스트
    @Test
    @Disabled
    public void testServiceInsert(){
        ToDo toDo = ToDo.builder()
                .userId("soo")
                .title("서비스 테스트")
                .done(false)
                .build();
        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);
    }

    //조회 테스트
    //@Test
    public void testServiceRetrive(){

        List<ToDo> list = toDoService.retrieve("adam");
        System.out.println(list);
    }

    //수정 테스트
    @Test
    @Disabled
    public void testServiceUpdate(){
        ToDo toDo = ToDo.builder()
                .id("402881c783f40aa10183f40aa9db0000")
                .userId("soo")
                .title("수정")
                .done(true)
                .build();
        List<ToDo> list = toDoService.update(toDo);
        System.out.println(list);
    }

    //삭제 테스트
    @Test
    @Disabled
    public void testServiceDelete(){
        ToDo toDo = ToDo.builder()
                .id("402881c783f40aa10183f40aa9db0000")
                .userId("soo")
                .build();
        List<ToDo> list = toDoService.delete(toDo);
        System.out.println(list);
    }


}
