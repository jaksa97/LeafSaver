package com.github.jaksa97.LeafSaver.model.api.cure;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CureSaveDto {
    int drugId;

    int diseaseId;

    String instruction;
}
