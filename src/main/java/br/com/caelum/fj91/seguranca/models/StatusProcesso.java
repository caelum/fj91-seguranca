package br.com.caelum.fj91.seguranca.models;

public enum StatusProcesso {
	
	EM_ANALISE("Em analise"),
	REJEITADO("Rejeitado"),
	EM_ANDAMENTO("Em andamento"),
	ENCERRADO("Encerrado");
	
	private final String descricao;

	private StatusProcesso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
