package com.example.Pet_Service.adapters.inbound.dto;

import java.util.UUID;

public record PetResponseDTO(

        UUID id,

        String nome,

        String especie,

        Integer idade,

        UUID ownerId
        //,OwnerResumoDTO owner
        ) {
}