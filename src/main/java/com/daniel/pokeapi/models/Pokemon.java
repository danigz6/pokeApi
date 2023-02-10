package com.daniel.pokeapi.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToMany
    @JoinTable(name = "pokemons_types", joinColumns = @JoinColumn(name = "id_pokemon"), inverseJoinColumns = @JoinColumn(name = "id_type"))
    List<Type> types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
