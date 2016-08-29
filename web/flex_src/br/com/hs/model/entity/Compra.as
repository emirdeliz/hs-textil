package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;
	

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Compra")]	
	public class Compra extends EntityObject{
	
		public var fornecedor:Fornecedor;		
		public var funcionario:Funcionario;	
		public var materiais:ArrayCollection;				
	}
}