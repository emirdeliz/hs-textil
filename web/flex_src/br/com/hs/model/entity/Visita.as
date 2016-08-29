package br.com.hs.model.entity{

	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Visita")]	
	public class Visita extends EntityObject{		
			
		public var atendimento:Atendimento;		
		public var representante:Representante;		
		public var dataContato:Date;		
		public var dataAgenda:Date;		
		public var cliente:Cliente;		
		public var observacao:String;
		public var dataVisita:Date;		
		public var inativo:Boolean;
	}
}