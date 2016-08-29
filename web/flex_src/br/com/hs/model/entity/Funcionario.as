package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Funcionario")]	
	public class Funcionario extends Pessoa {
	
		public var cargo:Cargo;	
		public var dataAdmissao:Date;	
		public var usuario:String;	
		public var senha:String;	
		public var acessoSistema:AcessoSistema;			
	}
}