package org.example.ss04btth.models.services;

import org.example.ss04btth.models.entities.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> getAllAnimals();

    Animal getAnimalById(Long id);

    Animal addNewAnimal(Animal animal);

    Animal updateAnimal(Animal animal,Long id);

    void deleteAnimal(Long id);

}
