package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/producers", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProducerRestController {

    @GetMapping()
    @Operation(description = "Get all producers", summary = "Get all producers")
    List<ProducerDto> getProducers();

    @GetMapping("/{id}")
    @Operation(description = "Get producer by ID", summary = "Get producer by ID")
    ProducerDto getProducer(@PathVariable int id) throws ResourceNotFoundException;

    @PostMapping()
    @Operation(description = "Save producer", summary = "Save producer")
    ProducerDto saveProducer(@RequestBody ProducerDto producerDto);

    @PutMapping("/{id}")
    @Operation(description = "Update producer with ID", summary = "Update producer with ID")
    ProducerDto updateProducer(@PathVariable int id, @RequestBody ProducerDto producerDto) throws ResourceNotFoundException;

    @DeleteMapping("/{id}")
    @Operation(description = "Delete producer with ID", summary = "Delete producer with ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeProducer(@PathVariable int id) throws ResourceNotFoundException;
}
