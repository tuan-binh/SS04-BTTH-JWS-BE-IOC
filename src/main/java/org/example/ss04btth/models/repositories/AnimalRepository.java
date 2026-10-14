package org.example.ss04btth.models.repositories;

import org.example.ss04btth.models.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
