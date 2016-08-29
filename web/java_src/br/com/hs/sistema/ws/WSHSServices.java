package br.com.hs.sistema.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.Visita;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.service.ClienteService;
import br.com.hs.sistema.service.FormaPagamentoService;
import br.com.hs.sistema.service.ProdutoService;
import br.com.hs.sistema.service.UsuarioService;
import br.com.hs.sistema.service.VendaService;
import br.com.hs.sistema.service.VisitaService;
import br.com.hs.sistema.utils.XStreamCustom;
import br.com.hs.sistema.ws.exception.UsuarioInvalidoException;

@WebService
public class WSHSServices extends SpringBeanAutowiringSupport{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private VisitaService visitaService;
		
	@WebMethod
	public String autenticaUsuario(@WebParam(name="usur")String usuario, 
								   @WebParam(name="pwrd")String senha) throws Exception{	
		
		logger.info("Received new authenticating request with user: "+usuario+" and password:"+senha);			
		return new XStreamCustom().toXML(this.usuarioService.autenticarRepresentante(usuario, senha));
	}
	
	@WebMethod
	public String buscaFormasPagamento(@WebParam(name="usur") String usuario,
			   						   @WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for forma pagamento");	
		this.validaPermissaoUsuarioWS(usuario, senha);
		return new XStreamCustom().toXML(this.formaPagamentoService.buscarTodosAtivos());
	}
	
	@WebMethod
	public String buscaClientes(@WebParam(name="usur") String usuario,
			   					@WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for clientes");	
		this.validaPermissaoUsuarioWS(usuario, senha);
		return new XStreamCustom().toXML(this.clienteService.buscarTodosAtivos());
	}
	
	@WebMethod
	public String buscaProdutos(@WebParam(name="usur") String usuario,
			   					@WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for produtos");
		this.validaPermissaoUsuarioWS(usuario, senha);
		return new XStreamCustom().toXML(this.produtoService.buscarTodosAtivos());
	}
	
	@WebMethod
	public String buscaVisitas(@WebParam(name="dataAgenda")String dt, 
							   @WebParam(name="representante") String strR, 
							   @WebParam(name="inativo") Boolean inativo,
							   @WebParam(name="usur") String usuario,
							   @WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for search visitas with date: " + dt);
		this.validaPermissaoUsuarioWS(usuario, senha);
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");		
		Representante representante = (Representante) new XStreamCustom().fromXML(strR);
		return new XStreamCustom().toXML(this.visitaService.buscarTodosPorRepresentante(formatter.parse(dt), representante, inativo));
	}
		
	@WebMethod
	public String atualizarAgenda(@WebParam(name="visita")String cS, 
								  @WebParam(name="usur") String usuario,
								  @WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for update visita");
		this.validaPermissaoUsuarioWS(usuario, senha);		
		Visita v = (Visita) new XStreamCustom().fromXML(cS);	
		this.visitaService.salvar(v);
		return new XStreamCustom().toXML("Agenda atualizada com sucesso!"); 
	}
	
	@WebMethod
	public String removerAgenda(@WebParam(name="visita")String cS, 
								@WebParam(name="usur") String usuario,
								@WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for remove visita");
		this.validaPermissaoUsuarioWS(usuario, senha);
		Visita v = (Visita) new XStreamCustom().fromXML(cS);	
		this.visitaService.deletar(v);
		return new XStreamCustom().toXML("Agenda atualizada com sucesso!"); 
	}
	
	@WebMethod
	public String efetuaVenda(@WebParam(name="venda")String cS, 
							  @WebParam(name="usur") String usuario,
							  @WebParam(name="pwrd") String senha) throws Exception{
		
		logger.info("Received new request for venda");
		this.validaPermissaoUsuarioWS(usuario, senha);
		Caixa c = (Caixa) new XStreamCustom().fromXML(cS);
		this.vendaService.salvar(c);
		return new XStreamCustom().toXML("Venda efetuada com sucesso!"); 
	}
	
	public void validaPermissaoUsuarioWS(String usuario, String senha) throws Exception{		
		logger.info("Validating permission user for request WS...");			
		Boolean usuarioValidado = this.usuarioService.validaPermissaoUsuarioWS(usuario, senha);
			
		if(!usuarioValidado)
	        throw new UsuarioInvalidoException("Não foi possível autenticar o usuário no WS! Verifique as suas permissões de acesso.");		
	}
}
