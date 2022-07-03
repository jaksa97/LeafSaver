package com.github.jaksa97.LeafSaver.model.api.producer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(name = "Producer")
public class ProducerDto {
    int id;

    String name;
}
