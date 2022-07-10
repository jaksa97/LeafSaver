package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.DiseaseRestController;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSaveDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSearchOptions;
import com.github.jaksa97.LeafSaver.service.DiseaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Diseases")
public class DiseaseRestControllerImpl implements DiseaseRestController {

    private final DiseaseService _diseaseService;

    @Override
    public Page<DiseaseDto> getDiseases(DiseaseSearchOptions diseaseSearchOptions) {
        return _diseaseService.getAll(diseaseSearchOptions);
    }

    @Override
    public DiseaseDto getDisease(int id) throws ResourceNotFoundException {
        return _diseaseService.getOne(id);
    }

    @Override
    public DiseaseDto saveDisease(DiseaseSaveDto diseaseDto) throws UniqueViolationException {
        return _diseaseService.save(diseaseDto);
    }

    @Override
    public DiseaseDto updateDisease(int id, DiseaseSaveDto diseaseDto) throws ResourceNotFoundException, UniqueViolationException {
        return _diseaseService.update(id, diseaseDto);
    }

    @Override
    public void removeDisease(int id) throws ResourceNotFoundException {
        _diseaseService.remove(id);
    }
}
