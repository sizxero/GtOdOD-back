package com.sizxero.GtOdOD.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="ToDo")
public class ToDo {
    @Id
    @GeneratedValue
    private Long no;
    private String userId;
    private String title;
    private boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctg_id")
    private Category category;
}