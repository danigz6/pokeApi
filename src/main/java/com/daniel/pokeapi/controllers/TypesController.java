package com.daniel.pokeapi.controllers;

import com.daniel.pokeapi.models.Type;
import com.daniel.pokeapi.services.TypesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypesController {
    private final TypesService typesService;

    public TypesController(
        TypesService typesService
    ) {
        this.typesService = typesService;
    }

    @GetMapping("/")
    public List<Type> getAll() {
        return typesService.findAll();
    }

    @GetMapping("/{id}")
    public Type get(@PathVariable Integer id) {
        return typesService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Type create(@RequestBody Type type) {
        return typesService.save(type);
    }

    @PutMapping("/")
    public Type update(@RequestBody Type type) {
        if (type.getId() == null) return null;
        return typesService.save(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        typesService.deleteById(id);
    }
}
