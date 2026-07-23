package com.example.Pet_Service.adapters.inbound.dto;

import java.util.UUID;

public record OwnerResumoDTO(

        UUID id,

        String nome,

        String email) {
}