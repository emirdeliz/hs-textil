package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;	

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Fornecedor")]	
	public class Fornecedor extends Pessoa {
	
		public var nomeFantasia:String;	
		public var materiais:ArrayCollection;	
		public var usuario:String;	
		public var senha:String;		
	}
}