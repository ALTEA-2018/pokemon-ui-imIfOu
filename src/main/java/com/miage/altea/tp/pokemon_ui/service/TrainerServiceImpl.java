package com.miage.altea.tp.pokemon_ui.service;

import com.miage.altea.tp.pokemon_ui.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private PokemonTypeService pokemonTypeService;

    private RestTemplate restTemplate;
    private String trainerServiceUrl;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }

    @Override
    public List<Trainer> listTrainers() {
        return Arrays.asList(restTemplate.getForObject(trainerServiceUrl+"/trainers/", Trainer[].class));
    }

    @Override
    public Trainer getTeamForTrainer(String name) {
        Trainer trainer = restTemplate.getForObject(trainerServiceUrl+"/trainers/"+name, Trainer.class);
        List<PokemonType> pokemonTypes = new ArrayList<>();
        for(Pokemon pokemon: trainer.getTeam()){
            PokemonType pokemonType = pokemonTypeService.findPokemonTypesById(pokemon.getPokemonType());
            pokemonType.setLevel(pokemon.getLevel());
            pokemonTypes.add(pokemonType);
        }
        trainer.setTeamPokemon(pokemonTypes);
        return trainer;
    }


}
