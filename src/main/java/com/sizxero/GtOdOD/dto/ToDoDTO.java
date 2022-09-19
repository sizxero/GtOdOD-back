package com.sizxero.GtOdOD.dto;

import com.sizxero.GtOdOD.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {
    private String id;
    private String userId;
    private String title;
    private boolean done;
    public ToDoDTO(final ToDo entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }
    public static ToDo toEntity(final ToDoDTO dto){
        return ToDo.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}