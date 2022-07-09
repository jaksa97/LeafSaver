package com.github.jaksa97.LeafSaver.model.api.disease;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseSearchOptions {

    Integer page;

    Integer pageSize;
}
