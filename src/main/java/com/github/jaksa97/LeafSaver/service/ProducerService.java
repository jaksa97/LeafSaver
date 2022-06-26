package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProducerService {

    private final ProducerRepository _producerRepository;

    public ProducerDto getOne(int id) {
        return _producerRepository.findById(id).orElse(null);
    }

    public List<ProducerDto> getAll() {
        return _producerRepository.findAll();
    }

    public ProducerDto save(ProducerDto producerDto) {
        return _producerRepository.save(producerDto);
    }

    public ProducerDto update(int id, ProducerDto updatedProducer) {
        ProducerDto producer = _producerRepository.findById(id).orElse(null);
        producer.setId(updatedProducer.getId());
        producer.setName(updatedProducer.getName());

        return _producerRepository.save(producer);
    }

    public void remove(int id) {
        if (!_producerRepository.existsById(id)) {
            return;
        }

        _producerRepository.deleteById(id);
    }
}
