package com.miage.altea.tp.pokemon_ui.service;

import com.miage.altea.tp.pokemon_ui.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();

    PokemonType findPokemonTypesById(int id);

}
