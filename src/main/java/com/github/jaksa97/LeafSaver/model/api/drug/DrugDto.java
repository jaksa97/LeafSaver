package com.github.jaksa97.LeafSaver.model.api.drug;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrugDto {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int producerId;

    private String description;
}
