package br.com.hs.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.MaterialCompra")]
	public class MaterialCompra extends EntityObject
	{
		public var material:Material;	
		public var quantidade:Number;
		public var valorTotal:Number;
		public var valorUnitario:Number;
	}
}