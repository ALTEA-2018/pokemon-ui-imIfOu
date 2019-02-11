package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers",trainerService.listTrainers());
        return modelAndView;
    }

    @GetMapping("/trainer")
    public ModelAndView trainers(String trainerName){
        ModelAndView modelAndView = new ModelAndView("team");
        modelAndView.addObject("trainer",trainerService.getTeamForTrainer(trainerName));
        return modelAndView;
    }

}


