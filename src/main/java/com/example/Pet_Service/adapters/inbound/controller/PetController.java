package com.example.Pet_Service.adapters.inbound.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pet_Service.adapters.inbound.dto.PetCreateDTO;
import com.example.Pet_Service.adapters.inbound.dto.PetResponseDTO;
import com.example.Pet_Service.application.usecase.CreatePetUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

	private final CreatePetUseCase createPetUseCase;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PetResponseDTO criar(@Valid @RequestBody PetCreateDTO dto) {

		return createPetUseCase.execute(dto);
	}
}