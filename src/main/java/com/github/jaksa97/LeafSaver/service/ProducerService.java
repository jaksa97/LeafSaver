package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerService {

    private List<ProducerDto> producers;

    public ProducerService() {
        producers = new ArrayList<>();

        producers.add(new ProducerDto(1, "Producer 1"));
        producers.add(new ProducerDto(2, "Producer 2"));
        producers.add(new ProducerDto(3, "Producer 3"));
        producers.add(new ProducerDto(4, "Producer 4"));
        producers.add(new ProducerDto(5, "Producer 5"));
    }

    public ProducerDto getOne(int id) {
        return producers.get(id - 1);
    }

    public List<ProducerDto> getAll() {
        return producers;
    }

    public ProducerDto save(ProducerDto producerDto) {
        producers.add(producerDto);
        return producerDto;
    }

    public ProducerDto update(int id, ProducerDto updatedProducer) {
        ProducerDto producer = producers.get(id - 1);
        producer.setId(updatedProducer.getId());
        producer.setName(updatedProducer.getName());

        return producer;
    }

    public ProducerDto remove(int id) {
        ProducerDto producer = producers.get(id - 1);
        producers.remove(id - 1);

        return producer;
    }
}
