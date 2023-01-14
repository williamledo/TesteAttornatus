package com.api.java.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.api.java.DTO.pessoa.DadosAtualizacaoPessoa;
import com.api.java.DTO.pessoa.DadosCadastroPessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataDeNascimento;
	private Boolean ativo = true;
	
	private Long enderecoPrincipal;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa(String nome, LocalDate dataDeNascimento, Long enderecoPrincipal) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.enderecoPrincipal = enderecoPrincipal;
	}
	
	public void delete () {
		this.ativo = false;
	}

	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.dataDeNascimento = dados.dataDeNascimento();
		this.enderecos = dados.enderecos();
		this.enderecoPrincipal = dados.enderecos().get(0).getId();
	}
	
	public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
		
			this.nome = dados.nome();
			
			this.dataDeNascimento = dados.dataDeNascimento();
		
			this.enderecos = dados.enderecos();
			
			this.enderecoPrincipal = dados.enderecoPrincipal();
	
	}
	
}
