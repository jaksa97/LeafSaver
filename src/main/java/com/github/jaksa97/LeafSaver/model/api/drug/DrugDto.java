package com.github.jaksa97.LeafSaver.model.api.drug;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(name = "Drug")
public class DrugDto {
    int id;

    String name;

    int producerId;

    String description;
}
