package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.CureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface CureRepository extends JpaRepository<CureEntity, Integer>, JpaSpecificationExecutor<CureEntity> {

    @Override
    List<CureEntity> findAll();

    List<CureEntity> findAllByDrugId(int drugId);

    List<CureEntity> findAllByDiseaseId(int diseaseId);
}
