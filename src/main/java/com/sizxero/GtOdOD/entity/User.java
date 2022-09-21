package com.sizxero.GtOdOD.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="User")
public class User {
    @Id
    @GeneratedValue
    private Long no;
    String id;
    String pw;
    String name;
    String nick;
}
