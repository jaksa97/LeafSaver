package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRepository extends CrudRepository<DrugDto, Integer> {

    @Override
    List<DrugDto> findAll();
}
