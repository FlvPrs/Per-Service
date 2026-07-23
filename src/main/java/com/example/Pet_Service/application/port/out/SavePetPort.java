package com.example.Pet_Service.application.port.out;

import com.example.Pet_Service.domain.model.Pet;

import jakarta.validation.Valid;

public interface SavePetPort {

	Pet save(@Valid Pet pet);

}