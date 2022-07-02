package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import com.github.jaksa97.LeafSaver.model.mapper.ProducerMapper;
import com.github.jaksa97.LeafSaver.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProducerService {

    private final ProducerRepository _producerRepository;
    private final ProducerMapper _producerMapper;

    public ProducerDto getOne(int id) throws ResourceNotFoundException {
        ProducerEntity producerEntity = _producerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER));

        return _producerMapper.toDto(producerEntity);
    }

    public List<ProducerDto> getAll() {
        return _producerRepository.findAll().stream().map(_producerMapper::toDto).collect(Collectors.toList());
    }

    public ProducerDto save(ProducerSaveDto producerSaveDto) throws UniqueViolationException {
        if (_producerRepository.findByName(producerSaveDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.PRODUCER, "'name' already exists");
        }
        return _producerMapper.toDto(_producerRepository.save(_producerMapper.toEntity(producerSaveDto)));
    }

    public ProducerDto update(int id, ProducerSaveDto updatedProducer) throws ResourceNotFoundException, UniqueViolationException {
        ProducerEntity originalProducerEntity = _producerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER));

        if (!originalProducerEntity.getName().equals(updatedProducer.getName()) && _producerRepository.findByName(updatedProducer.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.PRODUCER, "'name' already exists");
        }

        ProducerEntity producerEntity = _producerMapper.toEntity(updatedProducer);
        producerEntity.setId(id);

        _producerRepository.save(producerEntity);

        return _producerMapper.toDto(producerEntity);
    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_producerRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER);
        }

        _producerRepository.deleteById(id);
    }
}
