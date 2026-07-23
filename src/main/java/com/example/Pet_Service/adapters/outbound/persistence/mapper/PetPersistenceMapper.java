package com.example.Pet_Service.adapters.outbound.persistence.mapper;

import org.mapstruct.Mapper;

import com.example.Pet_Service.adapters.outbound.persistence.entity.PetJpaEntity;
import com.example.Pet_Service.domain.model.Pet;

@Mapper(componentModel = "spring")
public interface PetPersistenceMapper {

	PetJpaEntity toJpaEntity(Pet pet);

	Pet toDomain(PetJpaEntity entity);
}
