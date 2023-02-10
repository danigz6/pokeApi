package com.daniel.pokeapi.repositories;

import com.daniel.pokeapi.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, CustomPokemonRepository {
    List<Pokemon> findByName(String name);
}

interface CustomPokemonRepository {
    String findByTuPadre(String tuPadre);

}
class CustomPokemonRepositoryImpl implements CustomPokemonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String findByTuPadre(String tuPadre) {
        return "No se que hacer";
    }
}
