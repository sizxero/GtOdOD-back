package com.sizxero.GtOdOD.dto.todo;

import com.sizxero.GtOdOD.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {
    private Long no;
    private String userId;
    private String title;
    private Long ctgId;
    private boolean done;
    private LocalDateTime date;

    public ToDoDTO(final ToDo entity){
        this.no = entity.getNo();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.ctgId = entity.getCategory().getNo();
        this.done = entity.isDone();
        this.date = entity.getDate();
    }
    public static ToDo toEntity(final ToDoDTO dto){
        return ToDo.builder()
                .no(dto.getNo())
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .date(dto.getDate())
                .build();
    }
}