package com.pawel.Schronisko_Spring;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.AnimalSex;
import com.pawel.Schronisko_Spring.domain.AnimalType;
import com.pawel.Schronisko_Spring.domain.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@PropertySource("classpath:application.properties")
public class Starter implements CommandLineRunner
{

    @Autowired
    AnimalRepository animalRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Animal animal1 = new Animal("Nazwa", "Opis", 2, AnimalSex.MAN, AnimalType.CAT, "cat-2343448_640.jpg");
        Animal animal2 = new Animal("Nazwa2", "Opis2", 21, AnimalSex.WOMAN, AnimalType.DOG, "cat-2641377_640.jpg");
        System.out.println(animal1);
        System.out.println(animal2);
        animalRepository.createAnimal(animal1);
        animalRepository.createAnimal(animal2);
//        System.out.println(animalRepository.getAnimalById(1));
//        System.out.println(animalRepository.getAllAnimals());

    }
}
