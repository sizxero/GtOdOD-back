package com.sizxero.GtOdOD.controller;

import com.sizxero.GtOdOD.dto.ResponseDTO;
import com.sizxero.GtOdOD.dto.TestRequestBodyDTO;
import com.sizxero.GtOdOD.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String testController() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) String id) {
        return "Hello " + id + "!";
    }

    @GetMapping("/param")
    public String testControllerRequestParam(@RequestParam(required = false) String id) {
        return "Hello " + id + "!";
    }

    @GetMapping("/reqbody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO dto) {
        return "Hello " + dto.getId() + "! msg: " + dto.getMsg();
    }

    @GetMapping("/resbody")
    public ResponseDTO testControllerResponseBody() {
        List<String> list = new ArrayList();
        list.add("Hello World! I'm ResponseDTO");
        list.add("See you!");

        ResponseDTO<String> response =
                ResponseDTO.<String>builder()
                        .data(list)
                        .build();

        return response;
    }

    @GetMapping("/res/ok")
    public ResponseEntity<?> testControllerResponseBodyOK() {
        List<String> list = new ArrayList();
        list.add("Hello World! I'm ResponseDTO. And you get 200!");
        list.add("See you!");

        ResponseDTO<String> response =
                ResponseDTO.<String>builder()
                        .data(list)
                        .build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/res/err")
    public ResponseEntity<?> testControllerResponseBodyErr() {
        List<String> list = new ArrayList();
        list.add("Hello World! I'm ResponseDTO. And you get 400!");
        list.add("See you!");

        ResponseDTO<String> response =
                ResponseDTO.<String>builder()
                        .error("400 - Bad Request")
                        .data(list)
                        .build();

        return ResponseEntity.badRequest().body(response);
    }

    @Autowired
    private TestService service;

    @GetMapping("/service")
    public ResponseEntity<?> testControllerService() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response =
                ResponseDTO.<String>builder()
                        .data(list)
                        .build();

        return ResponseEntity.ok().body(response);
    }
}
