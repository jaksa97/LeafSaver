package com.github.jaksa97.LeafSaver.model.api.producer;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "producer")
public class ProducerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "name", unique = true)
    private String name;
}
