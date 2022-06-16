package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {
    private List<DrugDto> drugs;

    public DrugService() {
        drugs = new ArrayList<>();

        drugs.add(new DrugDto(1, "Drug 1", 1, "Description 1"));
        drugs.add(new DrugDto(2, "Drug 2", 2, "Description 2"));
        drugs.add(new DrugDto(3, "Drug 3", 1, "Description 3"));
        drugs.add(new DrugDto(4, "Drug 4", 2, "Description 4"));
        drugs.add(new DrugDto(5, "Drug 5", 3, "Description 5"));
    }

    public DrugDto getOne(int id) {
        return drugs.get(id - 1);
    }

    public List<DrugDto> getAll() {
        return drugs;
    }

    public DrugDto save(DrugDto drugDto) {
        drugs.add(drugDto);
        return drugDto;
    }

    public DrugDto update(int id, DrugDto updatedDrug) {
        DrugDto drug = drugs.get(id - 1);
        drug.setId(updatedDrug.getId());
        drug.setName(updatedDrug.getName());
        drug.setProducerId(updatedDrug.getProducerId());
        drug.setDescription(updatedDrug.getDescription());

        return drug;
    }

    public DrugDto remove(int id) {
        DrugDto drug = drugs.get(id - 1);
        drugs.remove(id - 1);

        return drug;
    }
}
