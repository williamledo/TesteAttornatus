package com.api.java.DTO.endereco;

import com.api.java.entities.Endereco;
import com.api.java.entities.Pessoa;

public record DadosDetalhamentoEndereco(Long id, String logradouro, String cep, String numero, String cidade) {

	public DadosDetalhamentoEndereco(Endereco endereco) {
		this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade());
	}
	
}