package com.github.jaksa97.LeafSaver.controller;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/drugs", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DrugRestController {
    @GetMapping()
    List<DrugDto> getDrugs();

    @GetMapping("/{id}")
    DrugDto getDrug(@PathVariable int id);

    @PostMapping()
    DrugDto saveDrug(@RequestBody DrugDto drugDto);

    @PutMapping("/{id}")
    DrugDto updateDrug(@PathVariable int id, @RequestBody DrugDto drugDto);

    @DeleteMapping("/{id}")
    DrugDto removeDrug(@PathVariable int id);
}
