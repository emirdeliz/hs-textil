package br.com.hs.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Promocao")]
	public class Promocao extends EntityObject
	{
		public var data:Date;
		public var tipo:int;
		public var descricao:String;
		public var funcionario:Funcionario;
	}
}