package com.miage.altea.tp.pokemon_ui.service;

import com.miage.altea.tp.pokemon_ui.bo.Trainer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TrainerService extends UserDetailsService {

    List<Trainer> getAllTrainers();

    Trainer getTeamForTrainer(String name);

}
