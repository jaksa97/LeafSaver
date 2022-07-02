package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSaveDto;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/diseases", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DiseaseRestController {

    @GetMapping()
    @Operation(description = "Get all diseases", summary = "Get all diseases")
    List<DiseaseDto> getDiseases();

    @GetMapping("/{id}")
    @Operation(description = "Get disease by ID", summary = "Get disease by ID")
    DiseaseDto getDisease(@PathVariable int id) throws ResourceNotFoundException;

    @PostMapping()
    @Operation(description = "Save disease", summary = "Save disease")
    DiseaseDto saveDisease(@RequestBody DiseaseSaveDto diseaseDto) throws UniqueViolationException;

    @PutMapping("/{id}")
    @Operation(description = "Update disease with ID", summary = "Update disease with ID")
    DiseaseDto updateDisease(@PathVariable int id, @RequestBody DiseaseSaveDto diseaseDto) throws ResourceNotFoundException, UniqueViolationException;

    @DeleteMapping("/{id}")
    @Operation(description = "Delete disease with ID", summary = "Delete disease with ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeDisease(@PathVariable int id) throws ResourceNotFoundException;
}
