package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface DrugRepository extends CrudRepository<DrugEntity, Integer> {
    @Override
    List<DrugEntity> findAll();

    Optional<DrugEntity> findByName(String name);
}
