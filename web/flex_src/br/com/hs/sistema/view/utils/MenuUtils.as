package br.com.hs.sistema.view.utils
{
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.utils.ObjectUtil;
	
	public class MenuUtils
	{
				
		private static var xml:XMLList = 
			<>			
				<menuitem label="Inicio">
			        <menuitem label="Atendimento" data="br.com.hs.sistema.view.form.AtendimentoFormView"/>	
			        <menuitem label="Estoque" data="br.com.hs.sistema.view.form.EstoqueFormView"/>		
			        <menuitem label="Visita" data="br.com.hs.sistema.view.form.VisitaFormView"/>	
			        <menuitem label="Orçamento" data="br.com.hs.sistema.view.form.OrcamentoFormView"/> 
			        <menuitem label="Cotação" data="br.com.hs.sistema.view.form.CotacaoFormView"/>   
			        <menuitem label="Promoção" data="br.com.hs.sistema.view.form.PromocaoFormView"/> 		    	   			   		                	               
			    </menuitem>
			    <menuitem label="Manutenção">
			        <menuitem label="Pessoas">
			            <menuitem label="Cliente" data="br.com.hs.sistema.view.form.ClienteFormView"/>
			            <menuitem label="Funcionário" data="br.com.hs.sistema.view.form.FuncionarioFormView"/>
			            <menuitem label="Fornecedor" data="br.com.hs.sistema.view.form.FornecedorFormView"/>	
			            <menuitem label="Representante" data="br.com.hs.sistema.view.form.RepresentanteFormView"/>			           
			        </menuitem>	
			        <menuitem label="Cargo" data="br.com.hs.sistema.view.form.CargoFormView"/>		 
			        <menuitem label="Acesso" data="br.com.hs.sistema.view.form.AcessoSistemaFormView"/>       
			        <menuitem label="Forma Pagamento" data="br.com.hs.sistema.view.form.FormaPagamentoFormView"/>	
			        <menuitem label="Material" data="br.com.hs.sistema.view.form.MaterialFormView"/>
			        <menuitem label="Produto" data="br.com.hs.sistema.view.form.ProdutoFormView"/>	
			        <menuitem label="Tipo Despesa" data="br.com.hs.sistema.view.form.TipoDespesaFormView"/>	
			        <menuitem label="Unidade Medida" data="br.com.hs.sistema.view.form.UnidadeMedidaFormView"/>			        
			    </menuitem>
			    <menuitem label="Financeiro">
			    	<menuitem label="Caixa" data="br.com.hs.sistema.view.form.CaixaFormView"/>	
			    	<menuitem label="Despesa" data="br.com.hs.sistema.view.form.DespesaFormView"/>	  
			    	<menuitem label="Compra" data="br.com.hs.sistema.view.form.CompraFormView"/>  
			    	<menuitem label="Venda" data="br.com.hs.sistema.view.form.VendaFormView"/> 	
			    </menuitem>			 
			    <menuitem label="Relatório"> 		 
			    	<menuitem label="Venda" data="br.com.hs.sistema.view.form.RelatorioVendaForm"/> 	
			    	<menuitem label="Compra" data="br.com.hs.sistema.view.form.RelatorioCompraForm"/>   
			    	<menuitem label="Produto" data="br.com.hs.sistema.view.form.RelatorioProdutoForm"/>	
			    	<menuitem label="Despesa" data="br.com.hs.sistema.view.form.RelatorioDespesaForm"/>	
			    </menuitem>
		   </>;
		    
		
		public static function menu(pInicio:Boolean, pManutencao:Boolean, pFinanceiro:Boolean, pRelatorio:Boolean):XMLList{
			var xmlMenu:XMLListCollection = new XMLListCollection(xml);
			var xmlResult:String = "";
			
			if(pInicio){
				xmlResult += xmlMenu.getItemAt(0);				
			}
			if(pManutencao){
				xmlResult += xmlMenu.getItemAt(1);				
			}
			if(pFinanceiro){
				xmlResult += xmlMenu.getItemAt(2);			
			}
			if(pRelatorio){
				xmlResult += xmlMenu.getItemAt(3);			
			}
			
			return new XMLList(xmlResult);
		}	
	}
}