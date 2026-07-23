package com.example.Pet_Service.application.port.out;

import java.util.Optional;
import java.util.UUID;

import com.example.Pet_Service.domain.model.Pet;

public interface FindPetPort {

	Optional<Pet> findById(UUID id);

}