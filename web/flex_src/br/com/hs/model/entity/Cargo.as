package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Cargo")]	
	public class Cargo extends EntityObject{

		public var id:String;
		public var nome:String;
		public var descricao:String;
		public var inativo:Boolean;		
	}
}