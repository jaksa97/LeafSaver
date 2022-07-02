package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends CrudRepository<ProducerEntity, Integer> {

    @Override
    List<ProducerEntity> findAll();

    Optional<ProducerEntity> findByName(String name);
}
