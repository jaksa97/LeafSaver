package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Integer>, JpaSpecificationExecutor<DiseaseEntity> {

    @Override
    List<DiseaseEntity> findAll();

    Optional<DiseaseEntity> findByName(String name);

    Optional<DiseaseEntity> findByNiceName(String niceName);
}
