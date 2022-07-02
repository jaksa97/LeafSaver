package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface DiseaseRepository extends CrudRepository<DiseaseEntity, Integer> {

    @Override
    List<DiseaseEntity> findAll();

    Optional<DiseaseEntity> findByName(String name);

    Optional<DiseaseEntity> findByNiceName(String niceName);
}
