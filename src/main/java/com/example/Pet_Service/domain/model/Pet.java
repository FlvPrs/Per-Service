package com.example.Pet_Service.domain.model;

import java.util.UUID;

public class Pet {

    private UUID id;
    private String nome;
    private String especie;
    private Integer idade;
    private UUID ownerId;
    
    public Pet() {
	}
    
	public Pet(UUID id, String nome, String especie, Integer idade, UUID ownerId) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.idade = idade;
		this.ownerId = ownerId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public UUID getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
	}

}