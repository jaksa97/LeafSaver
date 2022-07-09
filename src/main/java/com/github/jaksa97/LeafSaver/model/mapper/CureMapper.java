package com.github.jaksa97.LeafSaver.model.mapper;

import com.github.jaksa97.LeafSaver.model.api.cure.CureDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.CureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CureMapper {

    @Mapping(source = "drug.id", target = "drugId")
    @Mapping(source = "disease.id", target = "diseaseId")
    CureDto toDto(CureEntity cureEntity);

    CureEntity toEntity(CureDto cureDto);

    CureEntity toEntity(CureSaveDto cureSaveDto);
}
