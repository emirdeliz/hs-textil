package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Cliente")]	
	public class Cliente extends Pessoa {

		public var informacoesAdicionais:String;		
		public var potencial:String;
		public var representante:Representante;		
	}
}