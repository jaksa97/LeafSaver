package com.github.jaksa97.LeafSaver.repository;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends CrudRepository<ProducerDto, Integer> {

    @Override
    List<ProducerDto> findAll();

    Optional<ProducerDto> findByName(String name);
}
