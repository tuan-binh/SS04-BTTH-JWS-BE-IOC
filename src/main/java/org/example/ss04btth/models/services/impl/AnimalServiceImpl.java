package org.example.ss04btth.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.ss04btth.models.entities.Animal;
import org.example.ss04btth.models.repositories.AnimalRepository;
import org.example.ss04btth.models.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
    }

    @Override
    public Animal addNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal, Long id) {

        // tìm có tồn tại hay không
        Animal oldAnimal = getAnimalById(id);
        oldAnimal.setName(animal.getName());
        oldAnimal.setBreed(animal.getBreed());
        oldAnimal.setAge(animal.getAge());
        oldAnimal.setWeight(animal.getWeight());

        return animalRepository.save(oldAnimal);
    }

    @Override
    public void deleteAnimal(Long id) {
        // kiểm tra sự tồn tại
        // exists là sự tồn tại
        if(animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Animal not found with id: " + id);
        }
    }
}
