package com.github.jaksa97.LeafSaver.model.api.disease;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(name = "Disease")
public class DiseaseDto {
    int id;

    String name;

    String niceName;
}
