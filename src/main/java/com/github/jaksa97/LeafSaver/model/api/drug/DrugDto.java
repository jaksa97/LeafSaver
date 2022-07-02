package com.github.jaksa97.LeafSaver.model.api.drug;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "drug")
public class DrugDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "name", unique = true)
    private String name;

    @Column(nullable = false, name = "producerId")
    private int producerId;

    @Column(length = 255, nullable = false, name = "description")
    private String description;
}
