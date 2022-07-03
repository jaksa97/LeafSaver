package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugSaveDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/drugs", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DrugRestController {
    @GetMapping()
    @Operation(description = "Get all drugs", summary = "Get all drugs")
    List<DrugDto> getDrugs();

    @GetMapping("/{id}")
    @Operation(description = "Get drug by ID", summary = "Get drug by ID")
    DrugDto getDrug(@PathVariable int id) throws ResourceNotFoundException;

    @PostMapping()
    @Operation(description = "Save drug", summary = "Save drug")
    DrugDto saveDrug(@RequestBody DrugSaveDto drugDto) throws UniqueViolationException, ResourceNotFoundException;

    @PutMapping("/{id}")
    @Operation(description = "Update drug with ID", summary = "Update drug with ID")
    DrugDto updateDrug(@PathVariable int id, @RequestBody DrugSaveDto drugDto) throws ResourceNotFoundException, UniqueViolationException;

    @DeleteMapping("/{id}")
    @Operation(description = "Delete drug with ID", summary = "Delete drug with ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeDrug(@PathVariable int id) throws ResourceNotFoundException;
}
