package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;	

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.AcessoSistema")]	
	public class AcessoSistema extends EntityObject{

		public var id:String;
		public var nome:String;
		public var descricao:String;
		public var permissoes:ArrayCollection;		
	}
}