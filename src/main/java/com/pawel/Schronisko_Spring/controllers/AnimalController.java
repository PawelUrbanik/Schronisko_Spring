package com.pawel.Schronisko_Spring.controllers;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.repository.AnimalRepository;
import com.pawel.Schronisko_Spring.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.File;
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

    @RequestMapping("/addAnimal")
    public String addAnimal(Model model)
    {
        model.addAttribute("animal", new Animal());
        return "addAnimal";
    }

    @RequestMapping(value = "/addAnimal", method = RequestMethod.POST)
    public String addAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
//            bindingResult.getAllErrors().forEach(objectError ->{
//                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
//            });
            return "addAnimal";
        }else {
            animalService.saveAnimal(animal);
            return "redirect:/mainPage";
        }

    }
    @RequestMapping("/manage")
    public String manage(Model model)
    {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "manage";
    }

    @RequestMapping("animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") int id)
    {
        animalService.deleteAnimal(id);
        return "redirect:/manage";
    }


}
