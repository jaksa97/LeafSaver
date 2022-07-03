package com.github.jaksa97.LeafSaver.model.api.cure;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(name = "Cure")
public class CureDto {
    int id;

    int drugId;

    int diseaseId;

    String instruction;
}
