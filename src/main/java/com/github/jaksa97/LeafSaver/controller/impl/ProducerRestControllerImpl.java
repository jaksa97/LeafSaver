package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.ProducerRestController;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerSaveDto;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerSearchOptions;
import com.github.jaksa97.LeafSaver.service.ProducerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Producers")
public class ProducerRestControllerImpl implements ProducerRestController {

    private final ProducerService _producerService;

    @Override
    public Page<ProducerDto> getProducers(ProducerSearchOptions producerSearchOptions) {
        return _producerService.getAll(producerSearchOptions);
    }

    @Override
    public ProducerDto getProducer(int id) throws ResourceNotFoundException {
        return _producerService.getOne(id);
    }

    @Override
    public ProducerDto saveProducer(ProducerSaveDto producerDto) throws UniqueViolationException {
        return _producerService.save(producerDto);
    }

    @Override
    public ProducerDto updateProducer(int id, ProducerSaveDto producerDto) throws ResourceNotFoundException, UniqueViolationException {
        return _producerService.update(id, producerDto);
    }

    @Override
    public void removeProducer(int id) throws ResourceNotFoundException {
        _producerService.remove(id);
    }
}
