package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import com.github.jaksa97.LeafSaver.model.mapper.DrugMapper;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import com.github.jaksa97.LeafSaver.repository.ProducerRepository;
import com.github.jaksa97.LeafSaver.repository.specification.DrugSearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    public Page<DrugDto> getAll(DrugSearchOptions drugSearchOptions) {
        int page = 0;
        if (drugSearchOptions.getPage() != null && drugSearchOptions.getPage() >= 0) {
            page = drugSearchOptions.getPage() - 1;
        }

        int pageSize = 10;
        if (drugSearchOptions.getPageSize() != null && drugSearchOptions.getPageSize() >= 0) {
            pageSize = drugSearchOptions.getPageSize();
        }

        return _drugRepository
                .findAll(new DrugSearchSpecification(drugSearchOptions), PageRequest.of(page, pageSize))
                .map(_drugMapper::toDto);
    }

    public DrugDto save(DrugSaveDto drugSaveDto) throws UniqueViolationException, ResourceNotFoundException {
        if (_drugRepository.findByName(drugSaveDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }
        if (!_producerRepository.existsById(drugSaveDto.getProducerId())) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER, "Producer with id '" + drugSaveDto.getProducerId() + "' don't exists");
        }

        DrugEntity drugEntity = _drugMapper.toEntity(drugSaveDto);
        ProducerEntity producerEntity = _producerRepository.findById(drugSaveDto.getProducerId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER));

        drugEntity.setProducer(producerEntity);

        return _drugMapper.toDto(_drugRepository.save(drugEntity));
    }

    public DrugDto update(int id, DrugSaveDto updatedDrug) throws ResourceNotFoundException, UniqueViolationException {
        DrugEntity originalDrugEntity = _drugRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG) );

        if (!originalDrugEntity.getName().equals(updatedDrug.getName()) && _drugRepository.findByName(updatedDrug.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }

        DrugEntity drugEntity = _drugMapper.toEntity(updatedDrug);
        ProducerEntity producerEntity = _producerRepository.findById(updatedDrug.getProducerId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.PRODUCER));

        drugEntity.setProducer(producerEntity);

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
