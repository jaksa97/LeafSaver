package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.cure.CureDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSaveDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSearchOptions;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/cure", produces = MediaType.APPLICATION_JSON_VALUE)
public interface CureRestControllor {

    @GetMapping()
    @Operation(description = "Get all cures", summary = "Get all cures")
    Page<CureDto> getCures(@ParameterObject CureSearchOptions cureSearchOptions);

    @GetMapping("/{id}")
    @Operation(description = "Get cure by ID", summary = "Get cure by ID")
    CureDto getCure(@PathVariable int id) throws ResourceNotFoundException;

    @PostMapping()
    @Operation(description = "Save cure", summary = "Save cure")
    CureDto saveCure(@RequestBody CureSaveDto cureSaveDto) throws UniqueViolationException, ResourceNotFoundException;

    @PutMapping("/{id}")
    @Operation(description = "Update cure with ID", summary = "Update cure with ID")
    CureDto updateCure(@PathVariable int id, @RequestBody CureSaveDto cureSaveDto) throws UniqueViolationException, ResourceNotFoundException;

    @DeleteMapping("/{id}")
    @Operation(description = "Delete cure with ID", summary = "Delete cure with ID")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void removeCure(@PathVariable int id) throws ResourceNotFoundException;
}
