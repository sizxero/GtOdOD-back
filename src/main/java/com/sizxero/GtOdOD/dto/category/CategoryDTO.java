package com.sizxero.GtOdOD.dto.category;

import com.sizxero.GtOdOD.entity.Category;
import com.sizxero.GtOdOD.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {
    private Long no;
    private String title;
    private String color;

    public CategoryDTO(final Category entity){
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.color = entity.getColor();
    }

    public static Category toEntity(final CategoryDTO dto){
        return Category.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .color(dto.getColor())
                .build();
    }
}
