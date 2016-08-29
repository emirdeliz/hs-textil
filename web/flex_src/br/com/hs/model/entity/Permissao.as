package br.com.hs.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.hs.model.entity.Permissao")]	
	public class Permissao extends EntityObject	{
		
		public var permitido:Boolean;
		public var menu:String;
	}
}