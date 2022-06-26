package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.ProducerRestController;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProducerRestControllerImpl implements ProducerRestController {

    private final ProducerService _producerService;

    @Override
    public List<ProducerDto> getProducers() {
        return _producerService.getAll();
    }

    @Override
    public ProducerDto getProducer(int id) {
        return _producerService.getOne(id);
    }

    @Override
    public ProducerDto saveProducer(ProducerDto producerDto) {
        return _producerService.save(producerDto);
    }

    @Override
    public ProducerDto updateProducer(int id, ProducerDto producerDto) {
        return _producerService.update(id, producerDto);
    }

    @Override
    public ProducerDto removeProducer(int id) {
        return _producerService.remove(id);
    }
}
