package com.example.Pet_Service.application.usecase;

import org.springframework.stereotype.Service;

import com.example.Pet_Service.adapters.inbound.dto.PetCreateDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetResponseDTO;
import com.example.Pet_Service.adapters.inbound.mapper.PetMapper;
import com.example.Pet_Service.application.port.out.SavePetPort;
import com.example.Pet_Service.domain.model.Pet;

@Service
public class CreatePetUseCase {

	private final SavePetPort savePetPort;
	private final PetMapper mapper;

	public CreatePetUseCase(SavePetPort savePetPort, PetMapper mapper) {

		this.savePetPort = savePetPort;
		this.mapper = mapper;
	}

	public PetResponseDTO execute(PetCreateDTO dto) {

		Pet pet = mapper.createDtoToDomain(dto);

		Pet salvo = savePetPort.save(pet);

		return mapper.domainToResponseDto(salvo);
	}
}