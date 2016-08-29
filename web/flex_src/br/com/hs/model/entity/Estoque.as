package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Estoque")]
	public class Estoque extends EntityObject{
	
		public var tipo:int;	
		public var qtd:int ;
		public var item:int;
	}
}