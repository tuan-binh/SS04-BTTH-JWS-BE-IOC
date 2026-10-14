package org.example.ss04btth.controllers;

import lombok.RequiredArgsConstructor;
import org.example.ss04btth.models.entities.Animal;
import org.example.ss04btth.models.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    // API lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllAnimals(){
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    // API lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long id){
        return ResponseEntity.ok(animalService.getAnimalById(id));
    }

    // API thêm mới
    @PostMapping
    public ResponseEntity<?> addNewAnimal(@RequestBody Animal animal) {
        return ResponseEntity
                .status(201)
                .body(animalService.addNewAnimal(animal));
    }

    // API cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnimal(@RequestBody Animal animal, @PathVariable Long id){
        return ResponseEntity.ok(animalService.updateAnimal(animal, id));
    }

    // API xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

}
