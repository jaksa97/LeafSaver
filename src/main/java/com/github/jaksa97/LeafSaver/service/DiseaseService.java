package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSaveDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import com.github.jaksa97.LeafSaver.model.mapper.DiseaseMapper;
import com.github.jaksa97.LeafSaver.repository.DiseaseRepository;
import com.github.jaksa97.LeafSaver.repository.specification.DiseaseSearchSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiseaseService {

    private final DiseaseRepository _diseaseRepository;
    private final DiseaseMapper _diseaseMapper;

    public DiseaseDto getOne(int id) throws ResourceNotFoundException {
        DiseaseEntity diseaseEntity = _diseaseRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE));

        return _diseaseMapper.toDto(diseaseEntity);
    }

    public Page<DiseaseDto> getAll(DiseaseSearchOptions diseaseSearchOptions) {
        int page = 0;
        if (diseaseSearchOptions.getPage() != null && diseaseSearchOptions.getPage() >= 0) {
            page = diseaseSearchOptions.getPage() - 1;
        }

        int pageSize = 10;
        if (diseaseSearchOptions.getPageSize() != null && diseaseSearchOptions.getPageSize() >= 0) {
            pageSize = diseaseSearchOptions.getPageSize();
        }
        return _diseaseRepository
                .findAll(new DiseaseSearchSpecification(diseaseSearchOptions), PageRequest.of(page, pageSize))
                .map(_diseaseMapper::toDto);
    }

    public DiseaseDto save(DiseaseSaveDto diseaseSaveDto) throws UniqueViolationException {
        if (_diseaseRepository.findByName(diseaseSaveDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'name' already exists");
        }

        return _diseaseMapper.toDto(_diseaseRepository.save(_diseaseMapper.toEntity(diseaseSaveDto)));
    }

    public DiseaseDto update(int id, DiseaseSaveDto updatedDisease) throws ResourceNotFoundException, UniqueViolationException {
        DiseaseEntity originalDiseaseEntity = _diseaseRepository.findById(id)
                        .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE) );

        if (!originalDiseaseEntity.getName().equals(updatedDisease.getName()) && _diseaseRepository.findByName(updatedDisease.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'name' already exists");
        }

        DiseaseEntity diseaseEntity = _diseaseMapper.toEntity(updatedDisease);
        diseaseEntity.setId(id);

        _diseaseRepository.save(diseaseEntity);

        return _diseaseMapper.toDto(diseaseEntity);
    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_diseaseRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE);
        }

        _diseaseRepository.deleteById(id);
    }
}
