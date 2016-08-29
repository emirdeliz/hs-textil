package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.FornecedorCotacao_")]	
	public class FornecedorCotacao extends EntityObject{

		public var fornecedor:Fornecedor;
		public var valor:Number;
		public var observacao:String;
		public var data:Date;		
	}
}