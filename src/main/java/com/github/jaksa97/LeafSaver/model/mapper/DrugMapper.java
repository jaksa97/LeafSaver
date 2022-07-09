package com.github.jaksa97.LeafSaver.model.mapper;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    @Mapping(source = "producer.id", target = "producerId")
    DrugDto toDto(DrugEntity drugEntity);

    DrugEntity toEntity(DrugDto drugDto);

    DrugEntity toEntity(DrugSaveDto drugSaveDto);
}
