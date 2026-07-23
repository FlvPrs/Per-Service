package com.example.Pet_Service.adapters.outbound.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.example.Pet_Service.adapters.outbound.messaging.event.PetCreatedEvent;
import com.example.Pet_Service.application.port.out.PetEventPublisherPort;
import com.example.Pet_Service.config.RabbitMQConfig;
import com.example.Pet_Service.domain.model.Pet;

@Component
public class RabbitMQPetEventAdapter implements PetEventPublisherPort {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPetEventAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishPetCreated(Pet pet) {
        PetCreatedEvent event = new PetCreatedEvent(pet.getId(), pet.getNome(), pet.getOwnerId());
        rabbitTemplate.convertAndSend(RabbitMQConfig.PET_EXCHANGE, RabbitMQConfig.PET_CREATED_ROUTING_KEY, event);
    }
}