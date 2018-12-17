package com.pawel.Schronisko_Spring.controllers;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.repository.AnimalRepository;
import com.pawel.Schronisko_Spring.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @RequestMapping("/review")
    public String reviewAnimal(Model model)
    {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "review";

    }
}
