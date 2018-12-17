package com.pawel.Schronisko_Spring.services;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public void saveAnimal(Animal animal) {animalRepository.createAnimal(animal);}
    public void deleteAnimal(Integer id){ animalRepository.deleteAniaml(id);}
    public void updateAnimal(Animal animal) {animalRepository.updateAnimal((int) animal.getAnimalId(), animal);}
    public Animal getAnimal(Integer id) {return animalRepository.getAnimalById(id);};
    public List<Animal> getAllAnimals(){return new ArrayList<>(animalRepository.getAllAnimals());};
}
