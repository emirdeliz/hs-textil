package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.UnidadeMedida")]	
	public class UnidadeMedida extends EntityObject{

		public var id:String;
		public var nome:String;
		public var descricao:String;
		public var inativo:Boolean;			
	}
}