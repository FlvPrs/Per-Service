package com.example.Pet_Service.adapters.inbound.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.Pet_Service.adapters.inbound.dto.PetCreateDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetResponseDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetUpdateDTO;
import com.example.Pet_Service.domain.model.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(target = "id", ignore = true)
    Pet createDtoToDomain(PetCreateDTO dto);

    PetResponseDTO domainToResponseDto(Pet pet);

    PetUpdateDTO domainToUpdateDto(Pet pet);

    void updateDomainFromDto(
            PetUpdateDTO dto,
            @MappingTarget Pet pet);
}