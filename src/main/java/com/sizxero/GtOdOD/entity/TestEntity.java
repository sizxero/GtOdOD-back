package com.sizxero.GtOdOD.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name="Test")
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(generator="system-uuid") // 자동으로 id 성성
    @GenericGenerator(name="system-uuid",strategy="uuid")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
