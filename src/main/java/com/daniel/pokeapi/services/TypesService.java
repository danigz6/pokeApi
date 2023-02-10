package com.daniel.pokeapi.services;

import com.daniel.pokeapi.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesService extends JpaRepository<Type, Integer> {}
