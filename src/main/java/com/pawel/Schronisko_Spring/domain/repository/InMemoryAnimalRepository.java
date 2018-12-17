package com.pawel.Schronisko_Spring.domain.repository;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.AnimalSex;
import com.pawel.Schronisko_Spring.domain.AnimalType;
import com.pawel.Schronisko_Spring.utils.Ids;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("dev")
public class InMemoryAnimalRepository implements AnimalRepository {

    private Map<Integer, Animal> animals;

    public InMemoryAnimalRepository() {}

    @PostConstruct
    public void build()
    {
        animals = new HashMap<>();
        createAnimal(new Animal("Nazwa", "Opis", 2, AnimalSex.MAN, AnimalType.CAT, "Photo"));
        createAnimal(new Animal("Nazwa2", "Opis2", 21, AnimalSex.WOMAN, AnimalType.DOG, "Photo2"));
    }

    @Override
    public void createAnimal(String name, String description, int age, AnimalSex animalSex, AnimalType animalType, String animalPhoto) {
        Animal newAnimal = new Animal(name, description,age,animalSex,animalType,animalPhoto);
        newAnimal.setAnimalId(Ids.getNewId(animals.keySet()));
        animals.put((int) newAnimal.getAnimalId(), newAnimal);
    }

    @Override
    public void createAnimal(Animal animal) {
        animal.setAnimalId(Ids.getNewId(animals.keySet()));
        animals.put((int) animal.getAnimalId(), animal);
    }

    @Override
    public void deleteAniaml(Integer id) {
        animals.remove(id);
    }
}
