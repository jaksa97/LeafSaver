package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer>, JpaSpecificationExecutor<ProducerEntity> {

    @Override
    List<ProducerEntity> findAll();

    Optional<ProducerEntity> findByName(String name);
}
