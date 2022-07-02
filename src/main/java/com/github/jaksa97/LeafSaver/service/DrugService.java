package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugService {

    private final DrugRepository _drugRepository;

    public DrugDto getOne(int id) throws ResourceNotFoundException {
        return _drugRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG));
    }

    public List<DrugDto> getAll() {
        return _drugRepository.findAll();
    }

    public DrugDto save(DrugDto drugDto) throws UniqueViolationException {
        if (_drugRepository.findByName(drugDto.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }
        return _drugRepository.save(drugDto);
    }

    public DrugDto update(int id, DrugDto updatedDrug) throws ResourceNotFoundException, UniqueViolationException {
        DrugDto drug = _drugRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG) );

        if (!drug.getName().equals(updatedDrug.getName()) && _drugRepository.findByName(updatedDrug.getName()).isPresent()) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.DRUG, "'name' already exists");
        }

        drug.setId(updatedDrug.getId());
        drug.setName(updatedDrug.getName());
        drug.setProducerId(updatedDrug.getProducerId());
        drug.setDescription(updatedDrug.getDescription());

        return _drugRepository.save(drug);
    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_drugRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG);
        }

        _drugRepository.deleteById(id);
    }
}
