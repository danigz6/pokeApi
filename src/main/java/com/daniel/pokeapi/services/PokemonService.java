package com.daniel.pokeapi.services;

import com.daniel.pokeapi.models.Pokemon;
import com.daniel.pokeapi.repositories.PokemonRepository;
import com.daniel.pokeapi.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TypeRepository typeRepository;

    public PokemonService(
            PokemonRepository pokemonRepository, TypeRepository typeRepository
    ) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
    }

    public List<Pokemon> getTypePokemons(
            Integer idType
    ) {
        return pokemonRepository.findAll().stream().filter(
                pokemon -> pokemon.getTypes().stream().anyMatch(
                        type -> Objects.equals(type.getId(), idType)
                )
        ).collect(Collectors.toList());
    }
}
