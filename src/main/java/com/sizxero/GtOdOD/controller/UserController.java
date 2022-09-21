package com.sizxero.GtOdOD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizxero.GtOdOD.dto.category.CategoryDTO;
import com.sizxero.GtOdOD.entity.Category;
import com.sizxero.GtOdOD.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sizxero.GtOdOD.dto.ResponseDTO;
import com.sizxero.GtOdOD.dto.user.UserDTO;
import com.sizxero.GtOdOD.service.UserService;
import com.sizxero.GtOdOD.security.TokenProvider;
import com.sizxero.GtOdOD.entity.User;


@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping
    public ResponseEntity<?>signup(@RequestBody UserDTO requestDto){
        try {
            User entity = UserDTO.toEntity(requestDto);
            Optional<User> result = service.signup(entity);
            List<UserDTO> dtos =
                    result.stream().map(UserDTO::new).collect(Collectors.toList());
            ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(dtos).build();
            log.info("response dto ok");
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            String err = e.getMessage();
            ResponseDTO<UserDTO> response =
                    ResponseDTO.<UserDTO>builder().error(err).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserDTO requestDTO) {
        User user = service.getByCredentials(requestDTO.getId(), requestDTO.getPw());
        if (user != null) {
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login Failed")
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> checkDuplId(@RequestParam(required = false) String str) {
        boolean result = service.duplId(str);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/nick")
    public ResponseEntity<?> checkDuplNick(@RequestParam(required = false) String str) {
        boolean result = service.duplNick(str);
        return ResponseEntity.ok().body(result);
    }
}
