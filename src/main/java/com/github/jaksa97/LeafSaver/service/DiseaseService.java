package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.repository.DiseaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public DiseaseDto save(DiseaseDto diseaseDto) {
        return _diseaseRepository.save(diseaseDto);
    }

    public DiseaseDto update(int id, DiseaseDto updatedDisease) throws ResourceNotFoundException {
        DiseaseDto disease = _diseaseRepository.findById(id)
                        .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE) );
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
