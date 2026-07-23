package com.example.Pet_Service.adapters.inbound.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetCreateDTO(

        @NotBlank
        String nome,

        @NotBlank
        String especie,

        @NotNull
        Integer idade,

        @NotNull
        UUID ownerId) {
}