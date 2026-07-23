package com.example.Pet_Service.adapters.outbound.messaging.event;

import java.util.UUID;

public record PetCreatedEvent(
        UUID petId,
        String nome,
        UUID ownerId
) {
}