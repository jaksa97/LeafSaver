package com.github.jaksa97.LeafSaver.model.mapper;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiseaseMapper {

    DiseaseDto toDto(DiseaseEntity diseaseEntity);

    DiseaseEntity toEntity(DiseaseDto diseaseDto);

    DiseaseEntity toEntity(DiseaseSaveDto diseaseSaveDto);
}
