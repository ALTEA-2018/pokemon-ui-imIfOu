package com.miage.altea.tp.pokemon_ui.service;

import com.miage.altea.tp.pokemon_ui.bo.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> listTrainers();

    Trainer getTeamForTrainer(String name);

}
