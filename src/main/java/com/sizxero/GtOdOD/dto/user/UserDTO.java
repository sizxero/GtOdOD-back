package com.sizxero.GtOdOD.dto.user;

import com.sizxero.GtOdOD.dto.category.CategoryDTO;
import com.sizxero.GtOdOD.entity.Category;
import com.sizxero.GtOdOD.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long no;
    private String id;
    private String pw;
    private String name;
    private String nick;

    public UserDTO(final User entity){
        this.no = entity.getNo();
        this.id = entity.getId();
        this.pw = entity.getPw();
        this.name = entity.getName();
        this.nick = entity.getNick();
    }

    public static User toEntity(final UserDTO dto){
        return User.builder()
                .no(dto.getNo())
                .id(dto.getId())
                .pw(dto.getPw())
                .name(dto.getName())
                .nick(dto.getNick())
                .build();
    }
}
