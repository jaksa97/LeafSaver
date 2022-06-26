package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.DiseaseRestController;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiseaseRestControllerImpl implements DiseaseRestController {

    private final DiseaseService _diseaseService;

    @Override
    public List<DiseaseDto> getDiseases() {
        return _diseaseService.getAll();
    }

    @Override
    public DiseaseDto getDisease(int id) {
        return _diseaseService.getOne(id);
    }

    @Override
    public DiseaseDto saveDisease(DiseaseDto diseaseDto) {
        return _diseaseService.save(diseaseDto);
    }

    @Override
    public DiseaseDto updateDisease(int id, DiseaseDto diseaseDto) {
        return _diseaseService.update(id, diseaseDto);
    }

    @Override
    public DiseaseDto removeDisease(int id) {
        return _diseaseService.remove(id);
    }
}
