package com.example.Pet_Service.adapters.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pet_Service.adapters.outbound.persistence.entity.PetJpaEntity;

public interface PetRepository extends JpaRepository<PetJpaEntity, UUID> {
}