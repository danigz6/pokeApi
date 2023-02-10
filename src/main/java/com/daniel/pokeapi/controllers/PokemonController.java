package com.daniel.pokeapi.controllers;

import com.daniel.pokeapi.models.Pokemon;
import com.daniel.pokeapi.repositories.PokemonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/")
    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pokemon getById(@PathVariable Integer id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @PutMapping("/")
    public Pokemon update(@RequestBody Pokemon pokemon) {
        if (pokemon.getId() == null) return  null;
        return pokemonRepository.save(pokemon);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pokemonRepository.deleteById(id);
    }

    @GetMapping("/by_name/{name}")
    public List<Pokemon> getByName(
            @PathVariable String name
    ) {
        pokemonRepository.findByTuPadre("Rodrigo");
        return pokemonRepository.findByName(name);
    }
}
