package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugService {

    private final DrugRepository _drugRepository;

    public DrugDto getOne(int id) {
        return _drugRepository.findById(id).orElse(null);
    }

    public List<DrugDto> getAll() {
        return _drugRepository.findAll();
    }

    public DrugDto save(DrugDto drugDto) {
        return _drugRepository.save(drugDto);
    }

    public DrugDto update(int id, DrugDto updatedDrug) {
        DrugDto drug = _drugRepository.findById(id).orElse(null);

        drug.setId(updatedDrug.getId());
        drug.setName(updatedDrug.getName());
        drug.setProducerId(updatedDrug.getProducerId());
        drug.setDescription(updatedDrug.getDescription());

        return _drugRepository.save(drug);
    }

    public void remove(int id) {
        if (!_drugRepository.existsById(id)) {
            return;
        }

        _drugRepository.deleteById(id);
    }
}
