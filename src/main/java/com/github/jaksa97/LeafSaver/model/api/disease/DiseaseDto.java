package com.github.jaksa97.LeafSaver.model.api.disease;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiseaseDto {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String niceName;
}
