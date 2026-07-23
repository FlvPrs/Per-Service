package com.example.Pet_Service.adapters.outbound.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.Pet_Service.adapters.outbound.persistence.entity.PetJpaEntity;
import com.example.Pet_Service.adapters.outbound.persistence.mapper.PetPersistenceMapper;
import com.example.Pet_Service.adapters.outbound.persistence.repository.PetRepository;
import com.example.Pet_Service.application.port.out.FindPetPort;
import com.example.Pet_Service.application.port.out.SavePetPort;
import com.example.Pet_Service.domain.model.Pet;

@Component
public class PetPersistenceAdapter implements SavePetPort, FindPetPort {

	private final PetRepository repository;
	private final PetPersistenceMapper mapper;

	public PetPersistenceAdapter(PetRepository repository, PetPersistenceMapper mapper) {

		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Optional<Pet> findById(UUID id) {
		return repository.findById(id).map(mapper::toDomain);
	}

	@Override
	public Pet save(Pet pet) {

		PetJpaEntity entity = mapper.toJpaEntity(pet);

		PetJpaEntity saved = repository.save(entity);

		return mapper.toDomain(saved);
	}

}