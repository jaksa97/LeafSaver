package com.github.jaksa97.LeafSaver.model.api.disease;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class DiseaseDto {
    private int id;
    private String name;
    private String niceName;
}
