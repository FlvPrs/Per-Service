package com.example.Pet_Service.application.usecase;

import org.springframework.stereotype.Service;

import com.example.Pet_Service.adapters.inbound.dto.PetCreateDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetResponseDTO;
import com.example.Pet_Service.adapters.inbound.mapper.PetMapper;
import com.example.Pet_Service.application.port.in.CreatePetUseCase;
import com.example.Pet_Service.application.port.out.PetEventPublisherPort;
import com.example.Pet_Service.application.port.out.SavePetPort;
import com.example.Pet_Service.domain.model.Pet;

@Service
public class CreatePetService implements CreatePetUseCase {

    private final SavePetPort savePetPort;
    private final PetMapper mapper;
    private final PetEventPublisherPort eventPublisherPort;

    public CreatePetService(SavePetPort savePetPort, PetMapper mapper, PetEventPublisherPort eventPublisherPort) {
        this.savePetPort = savePetPort;
        this.mapper = mapper;
        this.eventPublisherPort = eventPublisherPort;
    }

    @Override
    public PetResponseDTO execute(PetCreateDTO dto) {
        Pet pet = mapper.createDtoToDomain(dto);
        Pet salvo = savePetPort.save(pet);
        eventPublisherPort.publishPetCreated(salvo);
        return mapper.domainToResponseDto(salvo);
    }
}