package br.com.hs.model.entity{
	
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Caixa")]	
	public class Caixa extends EntityObject{
	
		public var tipo:int;
		public var valor:Number;
		public var compra:Compra;
		public var venda:Venda;
		public var despesa:Despesa;
		public var formaPagamento:FormaPagamento;		
		public var dataVencimento:Date;	
		public var dataCaixa:Date;		
		public var pagamentoEfetuado:Boolean;
		public var observacao:String;		
	}
}