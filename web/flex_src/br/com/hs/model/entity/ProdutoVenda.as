package br.com.hs.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.ProdutoVenda")]
	public class ProdutoVenda extends EntityObject
	{
		public var produto:Produto;	
		public var quantidade:Number;
		public var valorTotal:Number;
		public var valorUnitario:Number;		
	}
}