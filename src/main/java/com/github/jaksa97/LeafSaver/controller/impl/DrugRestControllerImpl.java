package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.DrugRestController;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrugRestControllerImpl implements DrugRestController {

    private final DrugService _drugService;

    @Override
    public List<DrugDto> getDrugs() {
        return _drugService.getAll();
    }

    @Override
    public DrugDto getDrug(int id) {
        return _drugService.getOne(id);
    }

    @Override
    public DrugDto saveDrug(DrugDto drugDto) {
        return _drugService.save(drugDto);
    }

    @Override
    public DrugDto updateDrug(int id, DrugDto drugDto) {
        return _drugService.update(id, drugDto);
    }

    @Override
    public DrugDto removeDrug(int id) {
        return _drugService.remove(id);
    }
}
