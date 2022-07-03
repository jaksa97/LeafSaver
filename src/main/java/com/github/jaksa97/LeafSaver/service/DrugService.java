package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.model.mapper.DrugMapper;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import com.github.jaksa97.LeafSaver.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrugService {

    private final DrugRepository _drugRepository;
    private final ProducerRepository _producerRepository;
    private final DrugMapper _drugMapper;

    public DrugDto getOne(int id) throws ResourceNotFoundException {
        DrugEntity drugEntity = _drugRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG));

        return _drugMapper.toDto(drugEntity);
    }

    public List<DrugDto> getAll() {
        return _drugRepository.findAll().stream().map(_drugMapper::toDto).collect(Collectors.toList());
    }

    public DrugDto save(DrugSaveDto drugSaveDto) throws UniqueViolationException, ResourceNotFoundException {
        if (_drugRepository.findByName(drugSaveDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }
        if (!_producerRepository.existsById(drugSaveDto.getProducerId())) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER, "Producer with id '" + drugSaveDto.getProducerId() + "' don't exists");
        }

        return _drugMapper.toDto(_drugRepository.save(_drugMapper.toEntity(drugSaveDto)));
    }

    public DrugDto update(int id, DrugSaveDto updatedDrug) throws ResourceNotFoundException, UniqueViolationException {
        DrugEntity originalDrugEntity = _drugRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG) );

        if (!originalDrugEntity.getName().equals(updatedDrug.getName()) && _drugRepository.findByName(updatedDrug.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }

        DrugEntity drugEntity = _drugMapper.toEntity(updatedDrug);
        drugEntity.setId(id);

        _drugRepository.save(drugEntity);

        return _drugMapper.toDto(drugEntity);
    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_drugRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG);
        }

        _drugRepository.deleteById(id);
    }
}
