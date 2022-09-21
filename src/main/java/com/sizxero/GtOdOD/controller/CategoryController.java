package com.sizxero.GtOdOD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizxero.GtOdOD.dto.category.CategoryInputDTO;
import com.sizxero.GtOdOD.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.sizxero.GtOdOD.dto.ResponseDTO;
import com.sizxero.GtOdOD.dto.category.CategoryDTO;
import com.sizxero.GtOdOD.service.CategoryService;
import com.sizxero.GtOdOD.service.UserService;
import com.sizxero.GtOdOD.entity.Category;

@Slf4j
@RestController
@RequestMapping("ctg")
public class CategoryController {
    @Autowired
    private CategoryService ctgService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> retrieveCtg(@AuthenticationPrincipal String id) {
        List<Category> entities = ctgService.retrieve(id);
        List<CategoryDTO> dtos =
                entities.stream().map(CategoryDTO::new).collect(Collectors.toList());
        ResponseDTO<CategoryDTO> response =
                ResponseDTO.<CategoryDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?>createCtg(@RequestBody CategoryDTO requestDto, @AuthenticationPrincipal String id) {
        try {
            Category entity = CategoryDTO.toEntity(requestDto);
            User user = userService.findByUserId(id);
            entity.setUser(user);
            Optional<Category> result = ctgService.create(entity);
            List<CategoryDTO> dtos =
                    result.stream().map(CategoryDTO::new).collect(Collectors.toList());
            ResponseDTO<CategoryDTO> response = ResponseDTO.<CategoryDTO>builder().data(dtos).build();
            log.info("response dto ok");
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String err = e.getMessage();
            ResponseDTO<CategoryDTO> response =
                    ResponseDTO.<CategoryDTO>builder().error(err).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
