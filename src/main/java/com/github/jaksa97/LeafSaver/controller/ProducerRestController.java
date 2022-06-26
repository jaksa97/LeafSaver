package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/producers", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProducerRestController {

    @GetMapping()
    List<ProducerDto> getProducers();

    @GetMapping("/{id}")
    ProducerDto getProducer(@PathVariable int id);

    @PostMapping()
    ProducerDto saveProducer(@RequestBody ProducerDto producerDto);

    @PutMapping("/{id}")
    ProducerDto updateProducer(@PathVariable int id, @RequestBody ProducerDto producerDto);

    @DeleteMapping("/{id}")
    ProducerDto removeProducer(@PathVariable int id);
}
