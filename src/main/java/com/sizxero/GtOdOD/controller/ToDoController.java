package com.sizxero.GtOdOD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sizxero.GtOdOD.dto.ResponseDTO;
import com.sizxero.GtOdOD.dto.ToDoDTO;
import com.sizxero.GtOdOD.service.ToDoService;
import com.sizxero.GtOdOD.entity.ToDo;

@Slf4j
@RestController
@RequestMapping("todo")
public class ToDoController {
    @Autowired
    private ToDoService service;

    @GetMapping
    public ResponseEntity<?> retrieveToDo(@RequestParam(required = false) String id) {
        List<ToDo> entities = service.retrieve(id);
        List<ToDoDTO> dtos =
                entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
        ResponseDTO<ToDoDTO> response =
                ResponseDTO.<ToDoDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?>createTodo(@RequestBody ToDoDTO requestDto){
        try {
            ToDo entity = ToDoDTO.toEntity(requestDto);
            Optional<ToDo> result = service.create(entity);
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
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO requestDto, @RequestParam(required = false) String id) {
        try {
            ToDo entity = ToDoDTO.toEntity(requestDto);
            entity.setUserId(id);
            Optional<ToDo> result = service.update(entity);
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
            String msg = service.delete(dto.getId());
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
