package com.api.java.entities;

import java.io.Serializable;

import com.api.java.DTO.endereco.DadosCadastroEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	
	@JsonIgnore
	@ManyToOne
	private Pessoa pessoa;
	
	public Endereco (DadosCadastroEndereco endereco) {
		this.id = endereco.id();
		this.logradouro = endereco.logradouro();
		this.cep = endereco.cep();
		this.numero = endereco.numero();
		this.cidade = endereco.cidade();
		this.pessoa = endereco.pessoa();
	}

	public Endereco(String logradouro, String cep, String numero, String cidade, Pessoa pessoa) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa = pessoa;
	}
	
	public void atualizarEndereco(Endereco endereco) {
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
	}
	
	
}
