package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.DrugRestController;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSearchOptions;
import com.github.jaksa97.LeafSaver.service.DrugService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Drugs")
public class DrugRestControllerImpl implements DrugRestController {

    private final DrugService _drugService;

    @Override
    public Page<DrugDto> getDrugs(DrugSearchOptions drugSearchOptions) {
        return _drugService.getAll(drugSearchOptions);
    }

    @Override
    public DrugDto getDrug(int id) throws ResourceNotFoundException {
        return _drugService.getOne(id);
    }

    @Override
    public DrugDto saveDrug(DrugSaveDto drugDto) throws UniqueViolationException, ResourceNotFoundException {
        return _drugService.save(drugDto);
    }

    @Override
    public DrugDto updateDrug(int id, DrugSaveDto drugDto) throws ResourceNotFoundException, UniqueViolationException {
        return _drugService.update(id, drugDto);
    }

    @Override
    public void removeDrug(int id) throws ResourceNotFoundException {
        _drugService.remove(id);
    }
}
