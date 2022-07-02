package com.github.jaksa97.LeafSaver.model.mapper;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    ProducerDto toDto(ProducerEntity producerEntity);

    ProducerEntity toEntity(ProducerDto producerDto);

    ProducerEntity toEntity(ProducerSaveDto producerSaveDto);
}
