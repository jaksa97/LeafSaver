package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.DrugRestController;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.service.DrugService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Drugs")
public class DrugRestControllerImpl implements DrugRestController {

    private final DrugService _drugService;

    @Override
    public List<DrugDto> getDrugs() {
        return _drugService.getAll();
    }

    @Override
    public DrugDto getDrug(int id) throws ResourceNotFoundException {
        return _drugService.getOne(id);
    }

    @Override
    public DrugDto saveDrug(DrugSaveDto drugDto) throws UniqueViolationException {
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
