package com.github.jaksa97.LeafSaver.model.api.drug;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DrugSaveDto {
    String name;

    int producerId;

    String description;
}
