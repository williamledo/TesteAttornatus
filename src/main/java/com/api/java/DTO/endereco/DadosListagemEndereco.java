package com.api.java.DTO.endereco;

import com.api.java.entities.Endereco;

public record DadosListagemEndereco(Long id, String logradouro, String cep, String numero, String cidade) {

	public DadosListagemEndereco(Endereco endereco) {
		this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade());
	}
	
}
