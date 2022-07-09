package com.github.jaksa97.LeafSaver.model.api.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProducerSearchOptions {

    Integer page;

    Integer pageSize;
}
