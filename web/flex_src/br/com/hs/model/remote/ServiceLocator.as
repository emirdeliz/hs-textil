package br.com.hs.model.remote
{
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
		
	public class ServiceLocator {	
		
		private static const ATENDIMENTO_SERVICE:String = "atendimentoService";
		private static const CARGO_SERVICE:String = "cargoService";
		private static const TIPO_DESPESA_SERVICE:String = "tipoDespesaService";
		private static const ACESSO_SISTEMA_SERVICE:String = "acessoSistemaService";
		private static const FORMA_PAGAMENTO_SERVICE:String = "formaPagamentoService";
		private static const MATERIAL_SERVICE:String = "materialService";
		private static const PRODUTO_SERVICE:String = "produtoService";
		private static const CLIENTE_SERVICE:String = "clienteService";
		private static const FORNECEDOR_SERVICE:String = "fornecedorService";
		private static const FUNCIONARIO_SERVICE:String = "funcionarioService";
		private static const FLUXO_CAIXA_SERVICE:String = "fluxoCaixaService";
		private static const CAIXA_SERVICE:String = "caixaService";
		private static const DESPESA_SERVICE:String = "despesaService";
		private static const COMPRA_SERVICE:String = "compraService";
		private static const VENDA_SERVICE:String = "vendaService";
		private static const UNIDADE_MEDIDA_SERVICE:String = "unidadeMedidaService";
		private static const REPRESENTANTE_SERVICE:String = "representanteService";
		private static const VISITA_SERVICE:String = "visitaService";
		private static const ORCAMENTO_SERVICE:String = "orcamentoService";
		private static const COTACAO_SERVICE:String = "cotacaoService";
		private static const USUARIO_SERVICE:String = "usuarioService";
		private static const EMAIL_SERVICE:String = "emailService";
		private static const PROMOCAO_SERVICE:String = "promocaoService";
				
		public static function getAtendimentoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(ATENDIMENTO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getCargoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(CARGO_SERVICE);
			remoteObject.showBusyCursor = true;
					
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getAcessoSistemaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(ACESSO_SISTEMA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getFormaPagamentoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(FORMA_PAGAMENTO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getMaterialService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(MATERIAL_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getProdutoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(PRODUTO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getClienteService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(CLIENTE_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getFornecedorService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(FORNECEDOR_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getFuncionarioService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(FUNCIONARIO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getFluxoCaixaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(FLUXO_CAIXA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getCaixaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(CAIXA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getTipoDespesaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(TIPO_DESPESA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getDespesaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(DESPESA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getCompraService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(COMPRA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getVendaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(VENDA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getUnidadeMedidaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(UNIDADE_MEDIDA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getRepresentanteService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(REPRESENTANTE_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getVisitaService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(VISITA_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getOrcamentoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(ORCAMENTO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);		
			return remoteObject;
		}
		
		public static function getCotacaoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(COTACAO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);				
			return remoteObject;
		}
		
		public static function getUsuarioService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(USUARIO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);			
			return remoteObject;
		}
		
		public static function getEmailService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(EMAIL_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);			
			return remoteObject;
		}
		
		public static function getPromocaoService():RemoteObject{
			var remoteObject:RemoteObject = new RemoteObject(PROMOCAO_SERVICE);
			remoteObject.showBusyCursor = true;
			remoteObject.addEventListener(FaultEvent.FAULT, erro);			
			return remoteObject;
		}
		
		private static function erro(event:FaultEvent):void{			
			try{			
			    var e:ErrorMessage = event.message as ErrorMessage;				
				var error:String = e.rootCause.cause.cause.errorCode;								
							
				if(error == ErrorLocator.COD_ERRO_INTEGRIDADE_MYSQL){ 
					Alert.show(ErrorLocator.MSG_ERRO_INTEGRIDADE_MYSQL);						
				}else if(error == ErrorLocator.COD_ERRO_UNITARIEDADE_MYSQL){
					Alert.show(ErrorLocator.MSG_ERRO_UNITARIEDADE_MYSQL);
				}else{
					Alert.show(ErrorLocator.MSG_ERRO_DEFAULT);
				}
			}catch(e:Error){
				Alert.show(ErrorLocator.MSG_ERRO_DESCONHECIDO);
			}			
		}		
	}
}