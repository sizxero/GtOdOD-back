package com.sizxero.GtOdOD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizxero.GtOdOD.entity.Category;
import com.sizxero.GtOdOD.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.sizxero.GtOdOD.dto.ResponseDTO;
import com.sizxero.GtOdOD.dto.todo.ToDoDTO;
import com.sizxero.GtOdOD.service.ToDoService;
import com.sizxero.GtOdOD.entity.ToDo;

@Slf4j
@RestController
@RequestMapping("todo")
// 이거 하면 WebConfig 안해도 됨(권장하지는 않음)
// @CrossOrigin(origins="*")
public class ToDoController {
    @Autowired
    private ToDoService todoService;

    @Autowired
    private CategoryService ctgService;

    @GetMapping
    public ResponseEntity<?> retrieveToDo(@AuthenticationPrincipal String id) {
        List<ToDo> entities = todoService.retrieve(id);
        List<ToDoDTO> dtos =
                entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
        ResponseDTO<ToDoDTO> response =
                ResponseDTO.<ToDoDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?>createTodo(@RequestBody ToDoDTO requestDto, @AuthenticationPrincipal String id){
        try {
            log.info(requestDto.toString());
            ToDo entity = ToDoDTO.toEntity(requestDto);
            Category ctg = ctgService.findById(String.valueOf(requestDto.getCtgId()));
            entity.setUserId(id);
            entity.setCategory(ctg);
            log.info(entity.toString());
            Optional<ToDo> result = todoService.create(entity);
            List<ToDoDTO> dtos =
                    result.stream().map(ToDoDTO::new).collect(Collectors.toList());
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();
            log.info("response dto ok");
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String err = e.getMessage();
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder().error(err).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO requestDto, @AuthenticationPrincipal String id) {
        try {
            ToDo entity = ToDoDTO.toEntity(requestDto);
            entity.setUserId(id);
            Optional<ToDo> result = todoService.update(entity);
            List<ToDoDTO> dtos =
                    result.stream().map(ToDoDTO::new).collect(Collectors.toList());
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();
            log.info("response dto ok");
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String err = e.getMessage();
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder().error(err).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteToDo(@RequestBody ToDoDTO dto) {
        try {
            List<String> message = new ArrayList<>();
            String msg = todoService.delete(dto.getNo());
            message.add(msg);
            ResponseDTO<String> response =
                    ResponseDTO.<String>builder().data(message).build();
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String err = e.getMessage();
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder().error(err).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
