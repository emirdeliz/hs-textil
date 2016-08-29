package br.com.hs.model.entity;


public class Despesa extends EntityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;		
	
	private TipoDespesa tipoDespesa;
	
	private String observacao;
	
	public Despesa(){
		
	}

	public Despesa(TipoDespesa tipoDespesa, String observacao) {
		super();		
		this.tipoDespesa = tipoDespesa;
		this.observacao = observacao;
	}
				
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
	
}