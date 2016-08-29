package br.com.hs.model.entity{

import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.CotacaoMaterial")]
	public class CotacaoMaterial extends EntityObject{
				
		public var material:Material;	
		public var valor:Number;	
		public var observacao:String;	
		public var data:Date;	
	}
}