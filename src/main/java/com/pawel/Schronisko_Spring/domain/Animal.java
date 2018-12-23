package com.pawel.Schronisko_Spring.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @NotNull
    @NotEmpty(message = "Wypełnij to pole")
    private String name;

    @NotNull
    @NotEmpty(message = "Uzupełnij to pole")
    private String description;

    @NotNull
    @Min(value = 1, message = "Zwierzę powinno być w wieku powyżej 0")
    private int age;

    @NotNull(message = "Płeć nie może być pusta")
    @Enumerated(EnumType.ORDINAL)
    private AnimalSex animalSex;

    @NotNull(message = "Typ nie może być pusty")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    private String animalPhoto;

    public Animal() {
    }

    public Animal(@NotNull String name, @NotNull String description, @NotNull int age, AnimalSex animalSex, AnimalType animalType, String animalPhoto) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.animalSex = animalSex;
        this.animalType = animalType;
        this.animalPhoto = animalPhoto;
    }

    public Animal(Animal animal)
    {
        this.setAnimalId((int) animal.getAnimalId());
        this.setName(animal.getName());
        this.setDescription(animal.getDescription());
        this.setAge(animal.getAge());
        this.setAnimalSex(animal.getAnimalSex());
        this.setAnimalType(animal.getAnimalType());
        this.setAnimalPhoto(animal.getAnimalPhoto());
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalSex getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(AnimalSex animalSex) {
        this.animalSex = animalSex;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(String animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", animalSex=" + animalSex +
                ", animalType=" + animalType +
                ", animalPhoto='" + animalPhoto + '\'' +
                '}';
    }
}