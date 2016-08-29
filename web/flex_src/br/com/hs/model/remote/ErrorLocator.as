package br.com.hs.model.remote
{
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.utils.ObjectUtil;
		
	public class ErrorLocator {	
		
		public static const COD_ERRO_UNITARIEDADE_MYSQL:String = "1062";
		public static const COD_ERRO_INTEGRIDADE_MYSQL:String = "1451";
		public static const MSG_ERRO_DESCONHECIDO:String = "Ocorreu um erro desconhecido, favor verifique o log";		
		public static const MSG_ERRO_DEFAULT:String = "Ocorreu um erro: ";		
		public static const MSG_ERRO_UNITARIEDADE_MYSQL:String = "O id informado para o item já existe na base de dados para esse tipo de item." 
							   									  + "\n" + "Para mais detalhes consulte o arquivo de log.";
							   									  
		public static const MSG_ERRO_INTEGRIDADE_MYSQL:String = "O item não pode ser excluído, pois já estava vinculado a outros objetos na base de dados." 
							   									  + "\n" + "Para mais detalhes consulte o arquivo de log";	
		
	}
}