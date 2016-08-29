package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Produto")]	
	public class Produto extends EntityObject{
	
		public var id:String;	
		public var nome:String;	
		public var descricao:String;	
		public var valor:Number;
		public var unidade:UnidadeMedida;
		public var qtdEstoque:Number;
		public var materiais:ArrayCollection;
		public var ultimaVenda:Date;	
		public var inativo:Boolean;		
	}
}