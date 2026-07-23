package com.example.Pet_Service.application.port.out;

import com.example.Pet_Service.domain.model.Pet;

public interface SavePetPort {

	Pet save(Pet pet);

}