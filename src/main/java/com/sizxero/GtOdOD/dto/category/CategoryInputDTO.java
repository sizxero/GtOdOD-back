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
public class CategoryInputDTO {
    private Long no;
    private String id;
    private String title;
    private String color;
}
