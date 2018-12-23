package com.pawel.Schronisko_Spring.domain.repository;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.AnimalSex;
import com.pawel.Schronisko_Spring.domain.AnimalType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Collection;

public interface AnimalRepository {

    void createAnimal( String name, String description, int age, AnimalSex animalSex, AnimalType animalType, String animalPhoto);
    void createAnimal(Animal animal);
    void deleteAniaml(Integer integer);
    default void updateAnimal(Integer id, Animal animal){throw  new NotImplementedException();};
    default Animal getAnimalById(Integer id){throw new NotImplementedException();};
    default Collection<Animal> getAllAnimals(){throw new NotImplementedException();};
}
