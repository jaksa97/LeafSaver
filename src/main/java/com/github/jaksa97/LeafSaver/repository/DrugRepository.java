package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DrugRepository extends JpaRepository<DrugEntity, Integer> {
    @Override
    List<DrugEntity> findAll();

    Optional<DrugEntity> findByName(String name);
}
