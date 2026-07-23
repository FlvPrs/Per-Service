package com.example.Pet_Service.application.port.in;

import com.example.Pet_Service.adapters.inbound.dto.PetCreateDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetResponseDTO;

public interface CreatePetUseCase {
    PetResponseDTO execute(PetCreateDTO dto);
}