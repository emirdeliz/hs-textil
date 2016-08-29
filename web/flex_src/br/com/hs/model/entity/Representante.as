package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;	

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Representante")]	
	public class Representante extends Pessoa {	
		public var usuario:String;
		public var senha:String;		
		public var dataAdmissao:Date;	
		public var acessoSistema:AcessoSistema;
		public var clientes:ArrayCollection;	
	}
}