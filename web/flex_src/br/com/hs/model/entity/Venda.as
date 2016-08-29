package br.com.hs.model.entity{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Venda")]
	public class Venda extends EntityObject{
	
		public var cliente:Cliente;	
		public var representante:Representante;	
		public var produtos:ArrayCollection;			
		public var atendimento:Atendimento;		
	}
}