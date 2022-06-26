package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/diseases", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DiseaseRestController {

    @GetMapping()
    List<DiseaseDto> getDiseases();

    @GetMapping("/{id}")
    DiseaseDto getDisease(@PathVariable int id);

    @PostMapping()
    DiseaseDto saveDisease(@RequestBody DiseaseDto diseaseDto);

    @PutMapping("/{id}")
    DiseaseDto updateDisease(@PathVariable int id, @RequestBody DiseaseDto diseaseDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeDisease(@PathVariable int id);
}
