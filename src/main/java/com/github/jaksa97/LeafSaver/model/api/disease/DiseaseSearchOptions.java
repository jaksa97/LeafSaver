package com.github.jaksa97.LeafSaver.model.api.disease;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseSearchOptions {

    Integer page;

    Integer pageSize;

    SortByField sortBy;

    Sort.Direction sortDirection;

    public enum SortByField {
        name,
        niceName,
    }
}
