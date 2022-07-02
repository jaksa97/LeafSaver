package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.repository.DiseaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class DiseaseService {

    private final DiseaseRepository _diseaseRepository;

    public DiseaseDto getOne(int id) throws ResourceNotFoundException {
        return _diseaseRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE));
    }

    public List<DiseaseDto> getAll() {
        return _diseaseRepository.findAll();
    }

    public DiseaseDto save(DiseaseDto diseaseDto) throws UniqueViolationException {
        if (_diseaseRepository.findByName(diseaseDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'name' already exists");
        }
        if (_diseaseRepository.findByNiceName(diseaseDto.getNiceName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'nice name' already exists");
        }
        return _diseaseRepository.save(diseaseDto);
    }

    public DiseaseDto update(int id, DiseaseDto updatedDisease) throws ResourceNotFoundException, UniqueViolationException {
        DiseaseDto disease = _diseaseRepository.findById(id)
                        .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE) );

        if (!disease.getName().equals(updatedDisease.getName()) && _diseaseRepository.findByName(updatedDisease.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'name' already exists");
        }
        if (!disease.getNiceName().equals(updatedDisease.getNiceName()) && _diseaseRepository.findByNiceName(updatedDisease.getNiceName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DISEASE, "'nice name' already exists");
        }
        disease.setId(updatedDisease.getId());
        disease.setName(updatedDisease.getName());
        disease.setNiceName(updatedDisease.getNiceName());

        return _diseaseRepository.save(disease);
    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_diseaseRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE);
        }

        _diseaseRepository.deleteById(id);
    }
}
