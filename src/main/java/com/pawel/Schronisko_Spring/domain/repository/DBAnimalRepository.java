package com.pawel.Schronisko_Spring.domain.repository;

import com.pawel.Schronisko_Spring.domain.Animal;
import com.pawel.Schronisko_Spring.domain.AnimalSex;
import com.pawel.Schronisko_Spring.domain.AnimalType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Profile("prod")
public class DBAnimalRepository implements AnimalRepository {

    @PersistenceContext
    EntityManager manager;

    public DBAnimalRepository() {
    }

    @Override
    @Transactional
    public void createAnimal(String name, String description, int age, AnimalSex animalSex, AnimalType animalType, String animalPhoto) {
        Animal newAnimal = new Animal(name, description,age,animalSex,animalType,animalPhoto);
        manager.persist(newAnimal);
    }

    @Override
    @Transactional
    public void createAnimal(Animal animal) {
        manager.persist(animal);
    }

    @Override
    @Transactional
    public void deleteAniaml(Integer id) {
        manager.remove(id);
    }

    @PostConstruct
    @Transactional
    public void build()
    {
//        System.out.println("Build");
//        createAnimal(new Animal("Nazwa", "Opis", 2, AnimalSex.MAN, AnimalType.CAT, "Photo"));
//        createAnimal(new Animal("Nazwa2", "Opis2", 21, AnimalSex.WOMAN, AnimalType.DOG, "Photo2"));
    }

    @Override
    @Transactional
    public void updateAnimal(Integer id, Animal animal) {
        manager.merge(animal);
    }

    @Override
    public Animal getAnimalById(Integer id) {
        Animal animal = manager.createQuery("from Animal a where a.animalId=:id", Animal.class).setParameter("id", id).getSingleResult();
        return animal;
    }

    @Override
    public Collection<Animal> getAllAnimals() {

        return manager.createQuery("from Animal").getResultList();
    }
}
