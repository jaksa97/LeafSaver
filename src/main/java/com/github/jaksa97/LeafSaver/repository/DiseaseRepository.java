package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiseaseRepository extends CrudRepository<DiseaseDto, Integer> {

    @Override
    List<DiseaseDto> findAll();
}
