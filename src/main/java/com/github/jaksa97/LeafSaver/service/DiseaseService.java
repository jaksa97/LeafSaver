package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiseaseService {

    private List<DiseaseDto> diseases;

    public DiseaseService() {
        diseases = new ArrayList<>();

        diseases.add(new DiseaseDto(1, "Disease1", "Disease 1"));
        diseases.add(new DiseaseDto(2, "Disease2", "Disease 2"));
        diseases.add(new DiseaseDto(3, "Disease3", "Disease 3"));
        diseases.add(new DiseaseDto(4, "Disease4", "Disease 4"));
        diseases.add(new DiseaseDto(5, "Disease5", "Disease 5"));
    }

    public DiseaseDto getOne(int id) {
        return diseases.get(id -1);
    }

    public List<DiseaseDto> getAll() {
        return diseases;
    }

    public DiseaseDto save(DiseaseDto diseaseDto) {
        diseases.add(diseaseDto);
        return diseaseDto;
    }

    public DiseaseDto update(int id, DiseaseDto updatedDisease) {
        DiseaseDto disease = diseases.get(id - 1);
        disease.setId(updatedDisease.getId());
        disease.setName(updatedDisease.getName());
        disease.setNiceName(updatedDisease.getNiceName());

        return disease;
    }

    public DiseaseDto remove(int id) {
        DiseaseDto disease = diseases.get(id - 1);
        diseases.remove(id - 1);

        return disease;
    }
}
