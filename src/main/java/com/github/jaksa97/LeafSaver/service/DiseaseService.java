package com.github.jaksa97.LeafSaver.service;

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

    public DiseaseDto getOne(int id) {
        return _diseaseRepository.findById(id).orElse(null);
    }

    public List<DiseaseDto> getAll() {
        return _diseaseRepository.findAll();
    }

    public DiseaseDto save(DiseaseDto diseaseDto) {
        return _diseaseRepository.save(diseaseDto);
    }

    public DiseaseDto update(int id, DiseaseDto updatedDisease) {
        DiseaseDto disease = _diseaseRepository.findById(id).orElse(null);
        disease.setId(updatedDisease.getId());
        disease.setName(updatedDisease.getName());
        disease.setNiceName(updatedDisease.getNiceName());

        return _diseaseRepository.save(disease);
    }

    public void remove(int id) {
        if (!_diseaseRepository.existsById(id)) {
            return;
        }

        _diseaseRepository.deleteById(id);
    }
}
