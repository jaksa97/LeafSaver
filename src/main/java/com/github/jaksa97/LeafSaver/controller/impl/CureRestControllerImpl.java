package com.github.jaksa97.LeafSaver.controller.impl;

import com.github.jaksa97.LeafSaver.controller.CureRestControllor;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.cure.CureDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSaveDto;
import com.github.jaksa97.LeafSaver.service.CureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Cures")
public class CureRestControllerImpl implements CureRestControllor {

    private final CureService _cureService;

    @Override
    public List<CureDto> getCures() {
        return _cureService.getAll();
    }

    @Override
    public CureDto getCure(int id) throws ResourceNotFoundException {
        return _cureService.getOne(id);
    }

    @Override
    public CureDto saveCure(CureSaveDto cureSaveDto) throws UniqueViolationException, ResourceNotFoundException {
        return _cureService.save(cureSaveDto);
    }

    @Override
    public CureDto updateCure(int id, CureSaveDto cureSaveDto) throws UniqueViolationException, ResourceNotFoundException {
        return _cureService.update(id, cureSaveDto);
    }

    @Override
    public void removeCure(int id) throws ResourceNotFoundException {
        _cureService.remove(id);
    }
}
