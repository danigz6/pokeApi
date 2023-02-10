package com.daniel.pokeapi.controllers;

import com.daniel.pokeapi.models.Pokemon;
import com.daniel.pokeapi.models.Type;
import com.daniel.pokeapi.repositories.TypeRepository;
import com.daniel.pokeapi.services.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypesController {
    private final TypeRepository typeRepository;
    private final PokemonService pokemonService;

    public TypesController(
        TypeRepository typeRepository,
        PokemonService pokemonService
    ) {
        this.typeRepository = typeRepository;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Type get(@PathVariable Integer id) {
        return typeRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Type create(@RequestBody Type type) {
        return typeRepository.save(type);
    }

    @PutMapping("/")
    public Type update(@RequestBody Type type) {
        if (type.getId() == null) return null;
        return typeRepository.save(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        typeRepository.deleteById(id);
    }

    @GetMapping("/type_pokemons/{id}")
    public List<Pokemon> getPokemonOfType(
        @PathVariable Integer id
    ) {
        return pokemonService.getTypePokemons(id);
    }
}
