package br.com.hs.model.entity
{	
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.MaterialProduto")]
	public class MaterialProduto extends EntityObject
	{
		public var material:Material;
		public var quantidade:Number;
	}
}