package com.github.jaksa97.LeafSaver.model.api.disease;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DiseaseSaveDto {
    String name;

    String niceName;
}
