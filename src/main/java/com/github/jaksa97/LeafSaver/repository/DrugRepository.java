package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Optional;

public interface DrugRepository extends JpaRepository<DrugEntity, Integer>, JpaSpecificationExecutor<DrugEntity> {
    @Override
    List<DrugEntity> findAll();

    Optional<DrugEntity> findByName(String name);
}
