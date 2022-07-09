package com.github.jaksa97.LeafSaver.model.api.cure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CureSearchOptions {

    Integer page;

    Integer pageSize;
}
