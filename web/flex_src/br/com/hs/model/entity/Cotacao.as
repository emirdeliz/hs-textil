package br.com.hs.model.entity{

import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Cotacao")]
	public class Cotacao extends EntityObject{
	
		public var fornecedor:Fornecedor;		
		public var cotacoes:ArrayCollection;	
	}
}