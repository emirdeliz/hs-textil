package br.com.hs.model.entity
{	
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Despesa")]
	public class Despesa extends EntityObject
	{				
		public var tipoDespesa:TipoDespesa;	
		public var observacao:String;
	}
}