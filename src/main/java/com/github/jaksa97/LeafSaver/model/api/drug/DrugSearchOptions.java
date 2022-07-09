package com.github.jaksa97.LeafSaver.model.api.drug;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugSearchOptions {

    Integer page;

    Integer pageSize;
}
