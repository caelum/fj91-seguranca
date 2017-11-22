package br.com.caelum.fj91.seguranca.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Processo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String autor;
	private String descricao;
	private LocalDate dataDeCadastro = LocalDate.now();
	private StatusProcesso status = StatusProcesso.EM_ANALISE;
	
	public void rejeitar() {
		this.status = StatusProcesso.REJEITADO;
	}
	
	public void aceitar() {
		this.status = StatusProcesso.EM_ANDAMENTO;
	}
	
	public void encerrar() {
		this.status = StatusProcesso.ENCERRADO;
	}
	
	public String dataDeCadastroFormatada() {
		return this.dataDeCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public boolean estaEmAnalise() {
		return this.status == StatusProcesso.EM_ANALISE;
	}
	
	public boolean estaEmAndamento() {
		return this.status == StatusProcesso.EM_ANDAMENTO;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public StatusProcesso getStatus() {
		return status;
	}
	public void setStatus(StatusProcesso status) {
		this.status = status;
	}

}
