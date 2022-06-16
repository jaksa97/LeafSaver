package com.github.jaksa97.LeafSaver.model.api.drug;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
public class DrugDto {
    private int id;
    private String name;
    private int producerId;
    private String description;
}
