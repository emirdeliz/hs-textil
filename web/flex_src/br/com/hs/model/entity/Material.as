package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Material")]	
	public class Material extends EntityObject{
	
		public var id:String;	
		public var nome:String;	
		public var descricao:String;	
		public var unidade:UnidadeMedida;
		public var qtdEstoque:Number;
		public var qtdMinimaEstoque:Number;
		public var inativo:Boolean;	
	}
}