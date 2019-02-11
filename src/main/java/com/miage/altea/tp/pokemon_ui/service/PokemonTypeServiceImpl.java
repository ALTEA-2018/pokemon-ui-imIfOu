package com.miage.altea.tp.pokemon_ui.service;

import com.miage.altea.tp.pokemon_ui.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        return Arrays.asList(restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class));
    }

    @Override
    public PokemonType findPokemonTypesById(int id) {
        return restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/"+id, PokemonType.class);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
