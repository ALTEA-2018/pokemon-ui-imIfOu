package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public ModelAndView getProfile(Principal principal){
        ModelAndView modelAndView = new ModelAndView("team");
        modelAndView.addObject("trainer",trainerService.getTeamForTrainer(principal.getName()));
        return modelAndView;
    }
}
