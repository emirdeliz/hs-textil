package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;
	

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Orcamento")]	
	public class Orcamento extends EntityObject{
	
		public var cliente:Cliente;	
		public var data:Date;	
		public var produtos:ArrayCollection;	
	}
}