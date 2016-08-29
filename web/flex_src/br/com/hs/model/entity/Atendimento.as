package br.com.hs.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Atendimento")]	
	public class Atendimento extends EntityObject{
	
		public var data:Date;	
		public var descricao:String;	
	}
}