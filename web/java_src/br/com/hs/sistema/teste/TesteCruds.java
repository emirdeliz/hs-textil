package br.com.hs.sistema.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.hs.model.entity.AcessoSistema;
import br.com.hs.model.entity.Atendimento;
import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Cargo;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.Compra;
import br.com.hs.model.entity.Cotacao;
import br.com.hs.model.entity.CotacaoMaterial;
import br.com.hs.model.entity.Despesa;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Funcionario;
import br.com.hs.model.entity.Material;
import br.com.hs.model.entity.MaterialCompra;
import br.com.hs.model.entity.MaterialProduto;
import br.com.hs.model.entity.Orcamento;
import br.com.hs.model.entity.Permissao;
import br.com.hs.model.entity.Produto;
import br.com.hs.model.entity.ProdutoVenda;
import br.com.hs.model.entity.Promocao;
import br.com.hs.model.entity.Representante;
import br.com.hs.model.entity.TipoDespesa;
import br.com.hs.model.entity.UnidadeMedida;
import br.com.hs.model.entity.Venda;
import br.com.hs.model.entity.Visita;
import br.com.hs.sistema.constant.Menu;
import br.com.hs.sistema.constant.TipoCaixa;
import br.com.hs.sistema.constant.TipoPromocao;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.service.AcessoSistemaService;
import br.com.hs.sistema.service.AtendimentoService;
import br.com.hs.sistema.service.CaixaService;
import br.com.hs.sistema.service.CargoService;
import br.com.hs.sistema.service.ClienteService;
import br.com.hs.sistema.service.CompraService;
import br.com.hs.sistema.service.CotacaoService;
import br.com.hs.sistema.service.DespesaService;
import br.com.hs.sistema.service.FormaPagamentoService;
import br.com.hs.sistema.service.FornecedorService;
import br.com.hs.sistema.service.FuncionarioService;
import br.com.hs.sistema.service.MaterialService;
import br.com.hs.sistema.service.OrcamentoService;
import br.com.hs.sistema.service.ProdutoService;
import br.com.hs.sistema.service.PromocaoService;
import br.com.hs.sistema.service.RepresentanteService;
import br.com.hs.sistema.service.TipoDespesaService;
import br.com.hs.sistema.service.UnidadeMedidaService;
import br.com.hs.sistema.service.VendaService;
import br.com.hs.sistema.service.VisitaService;
import br.com.hs.sistema.utils.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="applicationContext.xml")
public class TesteCruds {
		
	@Autowired  
	private AtendimentoService atendimentoService;
		
	@Autowired 	  
    private CaixaService caixaService;    

	@Autowired 	  
    private UnidadeMedidaService unidadeMedidaService;
	
	@Autowired  
    private CargoService cargoService;

	@Autowired  
    private ClienteService clienteService;

	@Autowired  
    private CompraService compraService;

	@Autowired  
    private CotacaoService cotacaoService;

	@Autowired 
    private FormaPagamentoService formaPagamentoService;

	@Autowired 
    private FornecedorService fornecedorService;

	@Autowired 
    private FuncionarioService funcionarioService;

	@Autowired 
    private MaterialService materialService;

	@Autowired 
    private OrcamentoService orcamentoService;

	@Autowired 
    private ProdutoService produtoService;

	@Autowired 
    private VendaService vendaService;

	@Autowired 
    private VisitaService visitaService;
	
	@Autowired 
    private TipoDespesaService tipoDespesaService;
	
	@Autowired 
    private DespesaService despesaService;
	
	@Autowired 
    private AcessoSistemaService acessoSistemaService;
	
	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private PromocaoService promocaoService;
		
	private Atendimento atendimento1;
	private Atendimento atendimento2;
	private Atendimento atendimento3;
	private Atendimento atendimento4;
	
	private Cargo cargo1;
	private Cargo cargo2;
	private Cargo cargo3;
	private Cargo cargo4;
	
	private UnidadeMedida unidade1;
	private UnidadeMedida unidade2;
	private UnidadeMedida unidade3;
	private UnidadeMedida unidade4;
	
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;
	
	private FormaPagamento formaPagamento1;
	private FormaPagamento formaPagamento2;
	private FormaPagamento formaPagamento3;
	private FormaPagamento formaPagamento4;
	
	private Material material1;
	private Material material2;
	private Material material3;
	private Material material4;
	
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private Produto produto4;
	
	private Fornecedor fornecedor1;
	private Fornecedor fornecedor2;
	private Fornecedor fornecedor3;
	private Fornecedor fornecedor4;
	
	private Funcionario funcionario1;
	private Funcionario funcionario2;
	private Funcionario funcionario3;
	private Funcionario funcionario4;
	
	private Caixa caixa1;
	private Caixa caixa2;
	private Caixa caixa3;
	private Caixa caixa4;
	private Caixa caixa5;
	private Caixa caixa6;
	private Caixa caixa7;
	private Caixa caixa8;
	
	private Caixa compra1;
	private Caixa compra2;
	private Caixa compra3;
	private Caixa compra4;
	
	private Cotacao cotacao1;
	private Cotacao cotacao2;
	private Cotacao cotacao3;
	private Cotacao cotacao4;
	
	private Orcamento orcamento1;
	private Orcamento orcamento2;
	private Orcamento orcamento3;
	private Orcamento orcamento4;
	
	private Caixa venda1;
	private Caixa venda2;
	private Caixa venda3;
	private Caixa venda4;
	
	private Visita visita1;
	private Visita visita2;
	private Visita visita3;
	private Visita visita4;
	private Visita visita5;
	private Visita visita6;
	private Visita visita7;
	
	private TipoDespesa tipoDespesa1;
	private TipoDespesa tipoDespesa2;
	private TipoDespesa tipoDespesa3;
	private TipoDespesa tipoDespesa4;
	
	private Caixa despesa1;
	private Caixa despesa2;
	private Caixa despesa3;
	private Caixa despesa4;
	
	private AcessoSistema acessoSistema1;
	private AcessoSistema acessoSistema2;
	private AcessoSistema acessoSistema3;
	private AcessoSistema acessoSistema4;
	
	private Representante representante1;
	private Representante representante2;
	private Representante representante3;
	private Representante representante4;
	
	private Promocao promocao1;
	private Promocao promocao2;
	private Promocao promocao3;
	private Promocao promocao4;
		
	@Test
	public void testeAtendimento()throws Exception{
		logger.info("Initializing test entity Atendimento");	
		
		this.atendimento1 = new Atendimento(Utils.parseStringToDate("10/10/2011"), "Muito bom atendimento");
		this.atendimento2 = new Atendimento(Utils.parseStringToDate("11/12/2010"), "Razoável atendimento");
		this.atendimento3 = new Atendimento(Utils.parseStringToDate("12/12/2009"), "Excelente atendimento");
		this.atendimento4 = new Atendimento(Utils.parseStringToDate("01/05/2011"), "Bom atendimento");
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.atendimento1 = this.atendimentoService.salvar(this.atendimento1);
		this.atendimento2 = this.atendimentoService.salvar(this.atendimento2);
		this.atendimento3 = this.atendimentoService.salvar(this.atendimento3);
		this.atendimento4 = this.atendimentoService.salvar(this.atendimento4);
		
		Assert.assertNotNull(atendimento1);
		Assert.assertNotNull(atendimento2);
		Assert.assertNotNull(atendimento3);
		Assert.assertNotNull(atendimento4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Atendimento> list = this.atendimentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.atendimentoService.deletar(this.atendimento3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.atendimentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.atendimento3 = this.atendimentoService.buscarPorId(this.atendimento3.getOid());
		Assert.assertNull(this.atendimento3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.atendimento2 = this.atendimentoService.buscarPorId(this.atendimento2.getOid());
		Assert.assertNotNull(this.atendimento2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.atendimento1 = this.atendimentoService.salvar(this.atendimento1);
		this.atendimento2 = this.atendimentoService.salvar(this.atendimento2);
		this.atendimento4 = this.atendimentoService.salvar(this.atendimento4);
		
		Assert.assertNotNull(atendimento1);
		Assert.assertNotNull(atendimento2);		
		Assert.assertNotNull(atendimento4);
		
		logger.info("End test entity Atendimento");
	}
	
	@Test
	public void testeAcessoSistema()throws Exception{
		logger.info("Initializing test entity despesa");	
		
		List<Permissao> lPermissao1 = new ArrayList<Permissao>();		
		lPermissao1.add(new Permissao(true, Menu.INICIO));
		lPermissao1.add(new Permissao(true, Menu.MANUTENCAO));
		lPermissao1.add(new Permissao(true, Menu.FINANCEIRO));
		lPermissao1.add(new Permissao(true, Menu.RELATORIO));
		
		List<Permissao> lPermissao2 = new ArrayList<Permissao>();
		lPermissao2.add(new Permissao(true, Menu.INICIO));
		lPermissao2.add(new Permissao(false, Menu.MANUTENCAO));
		lPermissao2.add(new Permissao(true, Menu.FINANCEIRO));
		lPermissao2.add(new Permissao(false, Menu.RELATORIO));
		
		List<Permissao> lPermissao3 = new ArrayList<Permissao>();
		lPermissao3.add(new Permissao(false, Menu.INICIO));
		lPermissao3.add(new Permissao(true, Menu.MANUTENCAO));
		lPermissao3.add(new Permissao(true, Menu.FINANCEIRO));
		lPermissao3.add(new Permissao(true, Menu.RELATORIO));
		
		List<Permissao> lPermissao4 = new ArrayList<Permissao>();
		lPermissao4.add(new Permissao(false, Menu.INICIO));
		lPermissao4.add(new Permissao(true, Menu.MANUTENCAO));
		lPermissao4.add(new Permissao(false, Menu.FINANCEIRO));
		lPermissao4.add(new Permissao(false, Menu.RELATORIO));	
		
		this.acessoSistema1 = new AcessoSistema("adm", "Administrator", "Acesso ao financeiro", lPermissao1);
		this.acessoSistema2 = new AcessoSistema("ven", "Representante", "Acesso representante", lPermissao2);
		this.acessoSistema3 = new AcessoSistema("aux", "Aux. Administrador", "Auxiliar administrador", lPermissao3);
		this.acessoSistema4 = new AcessoSistema("man", "Manutenção", "Manutenção sistema", lPermissao4);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.acessoSistema1 = this.acessoSistemaService.salvar(this.acessoSistema1);
		this.acessoSistema2 = this.acessoSistemaService.salvar(this.acessoSistema2);
		this.acessoSistema3 = this.acessoSistemaService.salvar(this.acessoSistema3);
		this.acessoSistema4 = this.acessoSistemaService.salvar(this.acessoSistema4);
		
		Assert.assertNotNull(acessoSistema1);
		Assert.assertNotNull(acessoSistema2);
		Assert.assertNotNull(acessoSistema3);
		Assert.assertNotNull(acessoSistema4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<AcessoSistema> list = this.acessoSistemaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.acessoSistemaService.deletar(this.acessoSistema3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.acessoSistemaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.acessoSistema3 = this.acessoSistemaService.buscarPorId(this.acessoSistema3.getOid());
		Assert.assertNull(this.acessoSistema3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.acessoSistema2 = this.acessoSistemaService.buscarPorId(this.acessoSistema2.getOid());
		Assert.assertNotNull(this.acessoSistema2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.acessoSistema1 = this.acessoSistemaService.salvar(this.acessoSistema1);
		this.acessoSistema2 = this.acessoSistemaService.salvar(this.acessoSistema2);
		this.acessoSistema4 = this.acessoSistemaService.salvar(this.acessoSistema4);
		
		Assert.assertNotNull(acessoSistema1);
		Assert.assertNotNull(acessoSistema2);		
		Assert.assertNotNull(acessoSistema4);
		
		logger.info("End test entity acessoSistema");
	}
	
	@Test
	public void testeCargo()throws Exception{
		logger.info("Initializing test entity Cargo");	
		
		this.cargo1 = new Cargo("rep", "Representante", "Responsável por visitar clientes.", false);
		this.cargo2 = new Cargo("cos", "Costureira", "Responsável pela produção", true);
		this.cargo3 = new Cargo("aux. adm", "Auxiliar administrativo", "Responsável pelas rotinas de escritório da empresa", false);
		this.cargo4 = new Cargo("aux. est", "Auxiliar estoque", "Responsável pelas rotinas de estoque da empresa", false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.cargo1 = this.cargoService.salvar(this.cargo1);
		this.cargo2 = this.cargoService.salvar(this.cargo2);
		this.cargo3 = this.cargoService.salvar(this.cargo3);
		this.cargo4 = this.cargoService.salvar(this.cargo4);
		
		Assert.assertNotNull(cargo1);
		Assert.assertNotNull(cargo2);
		Assert.assertNotNull(cargo3);
		Assert.assertNotNull(cargo4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Cargo> list = this.cargoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.cargoService.deletar(this.cargo3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.cargoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cargo3 = this.cargoService.buscarPorId(this.cargo3.getOid());
		Assert.assertNull(this.cargo3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cargo2 = this.cargoService.buscarPorId(this.cargo2.getOid());
		Assert.assertNotNull(this.cargo2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.cargo1 = this.cargoService.salvar(this.cargo1);
		this.cargo2 = this.cargoService.salvar(this.cargo2);
		this.cargo4 = this.cargoService.salvar(this.cargo4);
		
		Assert.assertNotNull(cargo1);
		Assert.assertNotNull(cargo2);		
		Assert.assertNotNull(cargo4);
		
		logger.info("End test entity Cargo");
	}
	
	@Test
	public void testeUnidadeMedida()throws Exception{
		logger.info("Initializing test entity UnidadeMedida");	
		
		this.unidade1 = new UnidadeMedida("kg", "KG", "Por Kilo.", false);
		this.unidade2 = new UnidadeMedida("mt", "Metro", "Por Metro", true);
		this.unidade3 = new UnidadeMedida("cb", "Metro Cubico", "Por Metro Cubico", false);
		this.unidade4 = new UnidadeMedida("un", "UnidadeMedida", "Por UnidadeMedida", false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.unidade1 = this.unidadeMedidaService.salvar(this.unidade1);
		this.unidade2 = this.unidadeMedidaService.salvar(this.unidade2);
		this.unidade3 = this.unidadeMedidaService.salvar(this.unidade3);
		this.unidade4 = this.unidadeMedidaService.salvar(this.unidade4);
		
		Assert.assertNotNull(unidade1);
		Assert.assertNotNull(unidade2);
		Assert.assertNotNull(unidade3);
		Assert.assertNotNull(unidade4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<UnidadeMedida> list = this.unidadeMedidaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.unidadeMedidaService.deletar(this.unidade3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.unidadeMedidaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.unidade3 = this.unidadeMedidaService.buscarPorId(this.unidade3.getOid());
		Assert.assertNull(this.unidade3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.unidade2 = this.unidadeMedidaService.buscarPorId(this.unidade2.getOid());
		Assert.assertNotNull(this.unidade2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.unidade1 = this.unidadeMedidaService.salvar(this.unidade1);
		this.unidade2 = this.unidadeMedidaService.salvar(this.unidade2);
		this.unidade4 = this.unidadeMedidaService.salvar(this.unidade4);
		
		Assert.assertNotNull(unidade1);
		Assert.assertNotNull(unidade2);		
		Assert.assertNotNull(unidade4);
		
		logger.info("End test entity UnidadeMedida");
	}
	
	@Test
	public void testeRepresentante()throws Exception{
		logger.info("Initializing test entity Representante");				
		
		List<AcessoSistema> lAcessoSistema = this.acessoSistemaService.buscarTodos();		
		
		this.representante1 = new Representante("ppz", 
											"Pedro Paulo Zim", 
											"Rua Jaja, nº 10, Bairro Floresta, Joinville-SC", 
											"(47) 3465-1212", 
											"emirdeliz@gmail.com",											
											"pedro.paulo",
											Utils.MD5("123"),
											lAcessoSistema.get(1),										
											Utils.parseStringToDate("10/12/2005"),
											true);
		
		this.representante2 = new Representante("ccz", 
											"Carlos Cabral Zim", 
											"Rua dos Hiprocritas, nº43, Bairro Vila Nova, Joinville-SC", 
											"(47) 3465-1160", 											
											"emirdeliz@gmail.com",											
											"carlos.s",
											Utils.MD5("123"),
											lAcessoSistema.get(1), 										
											Utils.parseStringToDate("11/02/2007"),
											false);
		
		this.representante3 = new Representante("brr", 
											"Bruno Rangel", 
											"Rua Chavantes, nº 80, Bairro Aventureiro, Joinville-SC", 
											"(47) 3465-4545", 
											"bruno.rangel@pop.com.br",											
											"bruno.rangel",
											Utils.MD5("123"),
											lAcessoSistema.get(1),											
											Utils.parseStringToDate("03/03/2008"),
											false);
		
		this.representante4 = new Representante("rvs", 
											"Ricardo Vasconcelos", 
											"Rua Floringo, nº 27, Bairro Papa XXI, Joinville-SC", 
											"(47) 3465-4345", 
											"emirdeliz@ibest.com.br",											
											"ricardo.vas",
											Utils.MD5("123"),
											lAcessoSistema.get(1),											
											Utils.parseStringToDate("04/04/2010"),
											false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.representante1 = this.representanteService.salvar(this.representante1);
		this.representante2 = this.representanteService.salvar(this.representante2);
		this.representante3 = this.representanteService.salvar(this.representante3);
		this.representante4 = this.representanteService.salvar(this.representante4);
		
		Assert.assertNotNull(representante1);
		Assert.assertNotNull(representante2);
		Assert.assertNotNull(representante3);
		Assert.assertNotNull(representante4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Representante> list = this.representanteService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.representanteService.deletar(this.representante3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.representanteService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.representante3 = this.representanteService.buscarPorId(this.representante3.getOid());
		Assert.assertNull(this.representante3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.representante2 = this.representanteService.buscarPorId(this.representante2.getOid());
		Assert.assertNotNull(this.representante2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.representante1 = this.representanteService.salvar(this.representante1);
		this.representante2 = this.representanteService.salvar(this.representante2);
		this.representante4 = this.representanteService.salvar(this.representante4);
		
		Assert.assertNotNull(representante1);
		Assert.assertNotNull(representante2);		
		Assert.assertNotNull(representante4);
		
		logger.info("End test entity Representante");
	}
	
	
	@Test
	public void testeCliente()throws Exception{
		logger.info("Initializing test entity Cliente");	
		
		List<Representante> lRepresentante = this.representanteService.buscarTodos();
		
		this.cliente1 = new Cliente("hmc", 
									"Hipermercado Martins", 
									"Rua Tijucas, nº 10, Bairro Conceição, San Francisco do Sul-SC", 
									"(47) 5454-3535", 
									"emirdeliz@gmail.com",
									"Cliente possui grande demanda de produtos da linha de limpeza",
									"Alto",
									lRepresentante.get(0),
									false);
		
		this.cliente2 = new Cliente("mjp", 
									"Mercado Joares", 
									"Rua Salamandra, nº 13, Bairro Jarara, San Francisco do Sul-SC", 
									"(47) 5454-2345", 
									"emirdeliz@ibest.com.br",
									"Cliente possui grande demanda de produtos da linha de limpeza",
									"Baixo",
									lRepresentante.get(1),
									true);
		
		this.cliente3 = new Cliente("sst", 
									"Supermercado ST", 
									"Rua Sales Trabs, nº 9, Bairro Azul, Balneário Cambóriu-SC", 
									"(47) 7454-0080", 
									"emirdeliz@ibest.com.br",
									"Cliente possui grande demanda de produtos da linha de Banho",
									"Médio",
									lRepresentante.get(2),
									false);
		
		this.cliente4 = new Cliente("hms", 
									"Hipermercado Solange", 
									"Rua Timbó, nº 10, Bairro Centro, Joinville-SC", 
									"(47) 3465-5454", 
									"emirdeliz@gmail.com",
									"Cliente possui grande demanda de produtos da linha de limpeza e mesa",
									"Alto",
									lRepresentante.get(2),
									false);
		

		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.cliente1 = this.clienteService.salvar(this.cliente1);
		this.cliente2 = this.clienteService.salvar(this.cliente2);
		this.cliente3 = this.clienteService.salvar(this.cliente3);
		this.cliente4 = this.clienteService.salvar(this.cliente4);

		Assert.assertNotNull(cliente1);
		Assert.assertNotNull(cliente2);
		Assert.assertNotNull(cliente3);
		Assert.assertNotNull(cliente4);

		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Cliente> list = this.clienteService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);

		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.clienteService.deletar(this.cliente3);

		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.clienteService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);

		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cliente3 = this.clienteService.buscarPorId(this.cliente3.getOid());
		Assert.assertNull(this.cliente3);

		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cliente2 = this.clienteService.buscarPorId(this.cliente2.getOid());
		Assert.assertNotNull(this.cliente2);

		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.cliente1 = this.clienteService.salvar(this.cliente1);
		this.cliente2 = this.clienteService.salvar(this.cliente2);
		this.cliente4 = this.clienteService.salvar(this.cliente4);

		Assert.assertNotNull(cliente1);
		Assert.assertNotNull(cliente2);		
		Assert.assertNotNull(cliente4);

		logger.info("End test entity Cliente");		
	}
	
	@Test
	public void testeFormaPagamento()throws Exception{
		logger.info("Initializing test entity FormaPagamento");	
		
		this.formaPagamento1 = new FormaPagamento("din", "Dinheiro", "Dinheiro à vista ou parcelado", false);
		this.formaPagamento2 = new FormaPagamento("car", "Cartão de Crédito", "Cartão de Crédito à vista ou parcelado", true);
		this.formaPagamento3 = new FormaPagamento("che", "Cheque", "Cheque à vista ou pré-datado", false);
		this.formaPagamento4 = new FormaPagamento("bol", "Boleto", "Boleto pago ao banco", false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.formaPagamento1 = this.formaPagamentoService.salvar(this.formaPagamento1);
		this.formaPagamento2 = this.formaPagamentoService.salvar(this.formaPagamento2);
		this.formaPagamento3 = this.formaPagamentoService.salvar(this.formaPagamento3);
		this.formaPagamento4 = this.formaPagamentoService.salvar(this.formaPagamento4);
		
		Assert.assertNotNull(formaPagamento1);
		Assert.assertNotNull(formaPagamento2);
		Assert.assertNotNull(formaPagamento3);
		Assert.assertNotNull(formaPagamento4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<FormaPagamento> list = this.formaPagamentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.formaPagamentoService.deletar(this.formaPagamento3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.formaPagamentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.formaPagamento3 = this.formaPagamentoService.buscarPorId(this.formaPagamento3.getOid());
		Assert.assertNull(this.formaPagamento3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.formaPagamento2 = this.formaPagamentoService.buscarPorId(this.formaPagamento2.getOid());
		Assert.assertNotNull(this.formaPagamento2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.formaPagamento1 = this.formaPagamentoService.salvar(this.formaPagamento1);
		this.formaPagamento2 = this.formaPagamentoService.salvar(this.formaPagamento2);
		this.formaPagamento4 = this.formaPagamentoService.salvar(this.formaPagamento4);
		
		Assert.assertNotNull(formaPagamento1);
		Assert.assertNotNull(formaPagamento2);		
		Assert.assertNotNull(formaPagamento4);
		
		logger.info("End test entity FormaPagamento");
	}
	
	@Test
	public void testeMaterial()throws Exception{
		logger.info("Initializing test entity material");	
		
		List<UnidadeMedida> lUnidade = this.unidadeMedidaService.buscarTodos();
		
		this.material1 = new Material("fio", "Rolo fio", "Rolo de fio utilizado na produção", lUnidade.get(1), 13f, 10, false);
		this.material2 = new Material("agu", "Agulha", "Agulha utilizada nas máquinas de costura", lUnidade.get(2), 15f, 20, true);
		this.material3 = new Material("fel", "Felpa", "Felpa utilizada na produção", lUnidade.get(0), 14f, 2, false);
		this.material4 = new Material("pan", "Pano de prato", "Pano de prato utilizado na produção", lUnidade.get(2), 10f, 2, false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.material1 = this.materialService.salvar(this.material1);
		this.material2 = this.materialService.salvar(this.material2);
		this.material3 = this.materialService.salvar(this.material3);
		this.material4 = this.materialService.salvar(this.material4);
		
		Assert.assertNotNull(material1);
		Assert.assertNotNull(material2);
		Assert.assertNotNull(material3);
		Assert.assertNotNull(material4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Material> list = this.materialService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.materialService.deletar(this.material3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.materialService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.material3 = this.materialService.buscarPorId(this.material3.getOid());
		Assert.assertNull(this.material3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.material2 = this.materialService.buscarPorId(this.material2.getOid());
		Assert.assertNotNull(this.material2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.material1 = this.materialService.salvar(this.material1);
		this.material2 = this.materialService.salvar(this.material2);
		this.material4 = this.materialService.salvar(this.material4);
		
		Assert.assertNotNull(material1);
		Assert.assertNotNull(material2);		
		Assert.assertNotNull(material4);
		
		logger.info("End test entity material");
	}
	
	@Test
	public void testeProduto()throws Exception{
		logger.info("Initializing test entity Produto");	
				
		List<UnidadeMedida> lUnidade = this.unidadeMedidaService.buscarTodos();
		List<Material> lMaterial = this.materialService.buscarTodos();
		
		MaterialProduto mp1 = new MaterialProduto(lMaterial.get(0), 3f);
		MaterialProduto mp2 = new MaterialProduto(lMaterial.get(1), 4f);
		MaterialProduto mp3 = new MaterialProduto(lMaterial.get(2), 5f);
		MaterialProduto mp4 = new MaterialProduto(lMaterial.get(2), 1f);
		
		List<MaterialProduto> lMaterialProduto1 = new ArrayList<MaterialProduto>();
		lMaterialProduto1.add(mp1);
		List<MaterialProduto> lMaterialProduto2 = new ArrayList<MaterialProduto>();
		lMaterialProduto2.add(mp2);
		List<MaterialProduto> lMaterialProduto3 = new ArrayList<MaterialProduto>();
		lMaterialProduto3.add(mp3);
		List<MaterialProduto> lMaterialProduto4 = new ArrayList<MaterialProduto>();
		lMaterialProduto4.add(mp4);
		
		this.produto1 = new Produto("ppr", "Pano de Prato", "Pano de prato utilizado para secar louça", 7.20f, lUnidade.get(1), 15f, lMaterialProduto1, Utils.parseStringToDate("10/09/2011"), false);
		this.produto2 = new Produto("tba", "Toalha de Banho", "Toalha de Banho utiliza para secar o corpo", 15.30f, lUnidade.get(2), 11f, lMaterialProduto2, Utils.parseStringToDate("13/12/2007"), true);
		this.produto3 = new Produto("est", "Estopa", "Estopa utilizada para tirar pó de móveis e etc", 3.80f, lUnidade.get(0), 12f, lMaterialProduto3, Utils.parseStringToDate("11/02/2011"), false);
		this.produto4 = new Produto("pch", "Pano de chão", "Pano de chão utilizado durante a limpeza da casa", 5.20f, lUnidade.get(2), 14f, lMaterialProduto4, Utils.parseStringToDate("08/08/2011"), false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.produto1 = this.produtoService.salvar(this.produto1);
		this.produto2 = this.produtoService.salvar(this.produto2);
		this.produto3 = this.produtoService.salvar(this.produto3);
		this.produto4 = this.produtoService.salvar(this.produto4);
		
		Assert.assertNotNull(produto1);
		Assert.assertNotNull(produto2);
		Assert.assertNotNull(produto3);
		Assert.assertNotNull(produto4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Produto> list = this.produtoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.produtoService.deletar(this.produto3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.produtoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.produto3 = this.produtoService.buscarPorId(this.produto3.getOid());
		Assert.assertNull(this.produto3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.produto2 = this.produtoService.buscarPorId(this.produto2.getOid());
		Assert.assertNotNull(this.produto2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.produto1 = this.produtoService.salvar(this.produto1);
		this.produto2 = this.produtoService.salvar(this.produto2);
		this.produto4 = this.produtoService.salvar(this.produto4);
		
		Assert.assertNotNull(produto1);
		Assert.assertNotNull(produto2);		
		Assert.assertNotNull(produto4);
		
		logger.info("End test entity Produto");
	}
	
	@Test
	public void testeFornecedor()throws Exception{
		logger.info("Initializing test entity Fornecedor");	
		
		List<Material> materiais = this.materialService.buscarTodos();
		
		List<Material> materiais1 = new ArrayList<Material>();
		materiais1.add(materiais.get(0));
		materiais1.add(materiais.get(1));
		
		List<Material> materiais2 = new ArrayList<Material>();
		materiais2.add(materiais.get(2));
				
		List<Material> materiais3 = new ArrayList<Material>();
		materiais3.add(materiais.get(2));		
		
		List<Material> materiais4 = new ArrayList<Material>();
		materiais4.add(materiais.get(2));
		materiais4.add(materiais.get(0));	
				
		this.fornecedor1 = new Fornecedor("ags", 
										  "Agulhas Sul", 
										  "Rua Oliveira, nº 19, Bairro Concentração, Joinville-SC", 
										  "(47) 3465-1313", 
										  "emirdeliz@ibest.com.br",
										  "Agulhas Sul Brasil",
										  materiais2,
										  "agulhas.sul",
										  Utils.MD5("123"), 
										  false);
		
		this.fornecedor2 = new Fornecedor("fsa", 
										  "Fio Serro", 
										  "Rua Norte sul, nº 11, Bairro Boquerão, Curitiba-PR", 
										  "(49) 3435-2113", 
										  "emirdeliz@gmail.com",
										  "Fio Serro Forte",
										  materiais1,
										  "fio.serro",
										  Utils.MD5("123"), 
										  true);
		
		this.fornecedor3 = new Fornecedor("txb", 
										  "Textêis Inova", 
										  "Rua Das nações, nº 71, Bairro Três Amigos, Brusque-SC", 
										  "(45) 5435-8900", 
										  "emirdeliz@gmail.com",
										  "Textêis Inova-Geração",
										  materiais3,
										  "texteis.inova",
										  Utils.MD5("123"), 
										  false);
		
		this.fornecedor4 = new Fornecedor("hnt", 
										  "Hino tecidos", 
										  "Rua Arcanjo, nº 3, Bairro Petelis, Brusque-SC", 
										  "(45) 5435-8080", 
										  "emirdeliz@ibest.com.br",
										  "Hino tecidos",
										  materiais4,
										  "hino.tecidos",
										  Utils.MD5("123"), 
										  false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.fornecedor1 = this.fornecedorService.salvar(this.fornecedor1);
		this.fornecedor2 = this.fornecedorService.salvar(this.fornecedor2);
		this.fornecedor3 = this.fornecedorService.salvar(this.fornecedor3);
		this.fornecedor4 = this.fornecedorService.salvar(this.fornecedor4);
		
		Assert.assertNotNull(fornecedor1);
		Assert.assertNotNull(fornecedor2);
		Assert.assertNotNull(fornecedor3);
		Assert.assertNotNull(fornecedor4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Fornecedor> list = this.fornecedorService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.fornecedorService.deletar(this.fornecedor3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.fornecedorService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.fornecedor3 = this.fornecedorService.buscarPorId(this.fornecedor3.getOid());
		Assert.assertNull(this.fornecedor3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.fornecedor2 = this.fornecedorService.buscarPorId(this.fornecedor2.getOid());
		Assert.assertNotNull(this.fornecedor2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.fornecedor1 = this.fornecedorService.salvar(this.fornecedor1);
		this.fornecedor2 = this.fornecedorService.salvar(this.fornecedor2);
		this.fornecedor4 = this.fornecedorService.salvar(this.fornecedor4);
		
		Assert.assertNotNull(fornecedor1);
		Assert.assertNotNull(fornecedor2);		
		Assert.assertNotNull(fornecedor4);
		
		logger.info("End test entity Fornecedor");
	}

	@Test
	public void testeFuncionario()throws Exception{
		logger.info("Initializing test entity Funcionario");	
		List<Cargo> lCargos = this.cargoService.buscarTodos();		
		List<AcessoSistema> lAcessoSistema = this.acessoSistemaService.buscarTodos();
		
		this.funcionario1 = new Funcionario("jsl", 
											"João da Silva", 
											"Rua Verônica, nº 131, Bairro Floresta, Joinville-SC", 
											"(47) 3465-1212", 
											"joao.silva@yahoo.com.br",
											lCargos.get(0),
											new Date(1165153654L),
											"joao",
											Utils.MD5("123"),
											null, 
											true);
		
		this.funcionario2 = new Funcionario("asj", 
											"Aline S. Joares", 
											"Rua dos Desportistas, nº43, Bairro Vila Nova, Joinville-SC", 
											"(47) 3465-1160", 
											"aline.s@pop.com.br",
											lCargos.get(0),
											new Date(1165153650L),
											"aline",
											Utils.MD5("123"),
											lAcessoSistema.get(0), 
											false);
		
		this.funcionario3 = new Funcionario("chc", 
											"Charles Camilo", 
											"Rua Florinda, nº 89, Bairro Aventureiro, Joinville-SC", 
											"(47) 3465-4545", 
											"charles.camilo@pop.com.br",
											lCargos.get(2),
											new Date(11651536590L),
											"charles",
											Utils.MD5("123"),
											lAcessoSistema.get(1), 
											false);
		
		this.funcionario4 = new Funcionario("tvs", 
											"Tereza Vasconcelos", 
											"Rua Florentina, nº 22, Bairro Panagua, Joinville-SC", 
											"(47) 3465-4345", 
											"tereza.vas@uol.com.br",
											lCargos.get(1),
											new Date(116515365400L),
											"tereza",
											Utils.MD5("123"),
											lAcessoSistema.get(2), 
											true);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.funcionario1 = this.funcionarioService.salvar(this.funcionario1);
		this.funcionario2 = this.funcionarioService.salvar(this.funcionario2);
		this.funcionario3 = this.funcionarioService.salvar(this.funcionario3);
		this.funcionario4 = this.funcionarioService.salvar(this.funcionario4);
		
		Assert.assertNotNull(funcionario1);
		Assert.assertNotNull(funcionario2);
		Assert.assertNotNull(funcionario3);
		Assert.assertNotNull(funcionario4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Funcionario> list = this.funcionarioService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.funcionarioService.deletar(this.funcionario3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.funcionarioService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.funcionario3 = this.funcionarioService.buscarPorId(this.funcionario3.getOid());
		Assert.assertNull(this.funcionario3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.funcionario2 = this.funcionarioService.buscarPorId(this.funcionario2.getOid());
		Assert.assertNotNull(this.funcionario2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.funcionario1 = this.funcionarioService.salvar(this.funcionario1);
		this.funcionario2 = this.funcionarioService.salvar(this.funcionario2);
		this.funcionario4 = this.funcionarioService.salvar(this.funcionario4);
		
		Assert.assertNotNull(funcionario1);
		Assert.assertNotNull(funcionario2);		
		Assert.assertNotNull(funcionario4);
		
		logger.info("End test entity Funcionario");
	}
		
	@Test
	public void testeCompra()throws Exception{
		logger.info("Initializing test entity Compra");	
		
		List<FormaPagamento> fPagamentos = this.formaPagamentoService.buscarTodos();
		List<Material> lMaterial = this.materialService.buscarTodos();
		
		MaterialCompra mc1 = new MaterialCompra(lMaterial.get(0), 1, 10f, 20f);
		MaterialCompra mc2 = new MaterialCompra(lMaterial.get(1), 2, 12f, 24f);
		MaterialCompra mc3 = new MaterialCompra(lMaterial.get(2), 1, 13f, 13f);
		MaterialCompra mc4 = new MaterialCompra(lMaterial.get(1), 3, 10f, 30f);
		
		List<MaterialCompra> materiais1 = new ArrayList<MaterialCompra>();
		materiais1.add(mc1);		
		
		List<MaterialCompra> materiais2 = new ArrayList<MaterialCompra>();
		materiais2.add(mc2);
				
		List<MaterialCompra> materiais3 = new ArrayList<MaterialCompra>();
		materiais3.add(mc3);		
		
		List<MaterialCompra> materiais4 = new ArrayList<MaterialCompra>();		
		materiais4.add(mc4);			
		
		Compra c1 = new Compra(this.fornecedor1, this.funcionario2, materiais1);
		Compra c2 = new Compra(this.fornecedor2, this.funcionario2, materiais2);
		Compra c3 = new Compra(this.fornecedor3, this.funcionario2, materiais3);
		Compra c4 = new Compra(this.fornecedor4, this.funcionario2, materiais4);
		
		this.compra1 = new Caixa(TipoCaixa.DESPESA, 150.30f, Utils.parseStringToDate("09/07/2011"), Utils.parseStringToDate("15/11/2010"), false, c1, null, fPagamentos.get(2), null, "Feito..");
		this.compra2 = new Caixa(TipoCaixa.DESPESA, 134.30f, Utils.parseStringToDate("01/07/2009"), Utils.parseStringToDate("19/07/2011"), false, c2, null, fPagamentos.get(2), null, "Feito..");
		this.compra3 = new Caixa(TipoCaixa.DESPESA, 130.30f, Utils.parseStringToDate("03/10/2010"), Utils.parseStringToDate("16/12/2010"), false, c3, null, fPagamentos.get(2), null, "Feito..");
		this.compra4 = new Caixa(TipoCaixa.DESPESA, 165.30f, Utils.parseStringToDate("04/09/2011"), Utils.parseStringToDate("13/07/2011"), false, c4, null, fPagamentos.get(2), null, "Feito..");
		
				
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.compra1 = this.compraService.salvar(this.compra1);
		this.compra2 = this.compraService.salvar(this.compra2);
		this.compra3 = this.compraService.salvar(this.compra3);
		this.compra4 = this.compraService.salvar(this.compra4);
		
		Assert.assertNotNull(compra1);
		Assert.assertNotNull(compra2);
		Assert.assertNotNull(compra3);
		Assert.assertNotNull(compra4);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.compra3 = this.compraService.buscarPorId(this.compra3.getOid());
		Assert.assertNotNull(this.compra3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.compra2 = this.compraService.buscarPorId(this.compra2.getOid());
		Assert.assertNotNull(this.compra2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.compra1 = this.compraService.salvar(this.compra1);
		this.compra2 = this.compraService.salvar(this.compra2);
		this.compra4 = this.compraService.salvar(this.compra4);
		
		Assert.assertNotNull(compra1);
		Assert.assertNotNull(compra2);
		Assert.assertNotNull(compra3);
		Assert.assertNotNull(compra4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Caixa> list = this.compraService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.compraService.deletar(this.compra1);
		this.compraService.deletar(this.compra2);
		this.compraService.deletar(this.compra3);
		this.compraService.deletar(this.compra4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.compraService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertTrue(list.size() == 0);
		
		logger.info("End test entity Compra");
	}
	
	@Test
	public void testeCotacao()throws Exception{
		logger.info("Initializing test entity Cotacao");	
		
		List<Material> materiais = this.materialService.buscarTodos();
		List<Fornecedor> lFornecedor = this.fornecedorService.buscarTodos();
		
		CotacaoMaterial c1 = new CotacaoMaterial(materiais.get(0), 12f, "A vista", Utils.parseStringToDate("09/03/2010"));
		CotacaoMaterial c2 = new CotacaoMaterial(materiais.get(1), 13f, "Em 3 x", Utils.parseStringToDate("13/04/2009"));
		CotacaoMaterial c3 = new CotacaoMaterial(materiais.get(1), 17f, "Podemos parcelar", Utils.parseStringToDate("14/07/2009"));
		CotacaoMaterial c4 = new CotacaoMaterial(materiais.get(2), 10f, "Em até 12 x", Utils.parseStringToDate("13/12/2009"));
		
		List<CotacaoMaterial> f1 = new ArrayList<CotacaoMaterial>();
		f1.add(c1);
		
		List<CotacaoMaterial> f2 = new ArrayList<CotacaoMaterial>();
		f2.add(c2);
		
		List<CotacaoMaterial> f3 = new ArrayList<CotacaoMaterial>();
		f3.add(c3);
		
		List<CotacaoMaterial> f4 = new ArrayList<CotacaoMaterial>();
		f4.add(c4); 		
		this.cotacao1 = new Cotacao(lFornecedor.get(0), f1);
		this.cotacao2 = new Cotacao(lFornecedor.get(1), f2);
		this.cotacao3 = new Cotacao(lFornecedor.get(2), f3);
		this.cotacao4 = new Cotacao(lFornecedor.get(1), f4);
						
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.cotacao1 = this.cotacaoService.salvar(this.cotacao1);
		this.cotacao2 = this.cotacaoService.salvar(this.cotacao2);
		this.cotacao3 = this.cotacaoService.salvar(this.cotacao3);
		this.cotacao4 = this.cotacaoService.salvar(this.cotacao4);
		
		Assert.assertNotNull(cotacao1);
		Assert.assertNotNull(cotacao2);
		Assert.assertNotNull(cotacao3);
		Assert.assertNotNull(cotacao4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Cotacao> list = this.cotacaoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.cotacaoService.deletar(this.cotacao3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.cotacaoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cotacao3 = this.cotacaoService.buscarPorId(this.cotacao3.getOid());
		Assert.assertNull(this.cotacao3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.cotacao2 = this.cotacaoService.buscarPorId(this.cotacao2.getOid());
		Assert.assertNotNull(this.cotacao2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.cotacao1 = this.cotacaoService.salvar(this.cotacao1);
		this.cotacao2 = this.cotacaoService.salvar(this.cotacao2);
		this.cotacao4 = this.cotacaoService.salvar(this.cotacao4);
		
		Assert.assertNotNull(cotacao1);
		Assert.assertNotNull(cotacao2);		
		Assert.assertNotNull(cotacao4);
		
		logger.info("End test entity Cotacao");
	}

	@Test
	public void testeOrcamento()throws Exception{
		logger.info("Initializing test entity Orcamento");	
		
		List<Produto> produtos = this.produtoService.buscarTodos();
		List<Cliente> clientes = this.clienteService.buscarTodos();
		
		ProdutoVenda p1 = new ProdutoVenda(produtos.get(0), 2, 12f, 24f);
		ProdutoVenda p2 = new ProdutoVenda(produtos.get(1), 3, 15f, 45f);				
		ProdutoVenda p3 = new ProdutoVenda(produtos.get(2), 1, 12f, 12f);
		ProdutoVenda p4 = new ProdutoVenda(produtos.get(2), 4, 8f,  32f);		
		
		List<ProdutoVenda> lProdutoVenda1 = new ArrayList<ProdutoVenda>();
		lProdutoVenda1.add(p1);
		List<ProdutoVenda> lProdutoVenda2 = new ArrayList<ProdutoVenda>();
		lProdutoVenda2.add(p2);
		List<ProdutoVenda> lProdutoVenda3 = new ArrayList<ProdutoVenda>();
		lProdutoVenda3.add(p3);
		List<ProdutoVenda> lProdutoVenda4 = new ArrayList<ProdutoVenda>();
		lProdutoVenda4.add(p4);
		
		this.orcamento1 = new Orcamento(clientes.get(0), Utils.parseStringToDate("30/02/2009"), lProdutoVenda1);
		this.orcamento2 = new Orcamento(clientes.get(1), Utils.parseStringToDate("17/10/2010"), lProdutoVenda2);
		this.orcamento3 = new Orcamento(clientes.get(2), Utils.parseStringToDate("11/11/2011"), lProdutoVenda3);
		this.orcamento4 = new Orcamento(clientes.get(2), Utils.parseStringToDate("16/03/2011"), lProdutoVenda4);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.orcamento1 = this.orcamentoService.salvar(this.orcamento1);
		this.orcamento2 = this.orcamentoService.salvar(this.orcamento2);
		this.orcamento3 = this.orcamentoService.salvar(this.orcamento3);
		this.orcamento4 = this.orcamentoService.salvar(this.orcamento4);
		
		Assert.assertNotNull(orcamento1);
		Assert.assertNotNull(orcamento2);
		Assert.assertNotNull(orcamento3);
		Assert.assertNotNull(orcamento4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Orcamento> list = this.orcamentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.orcamentoService.deletar(this.orcamento3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.orcamentoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.orcamento3 = this.orcamentoService.buscarPorId(this.orcamento3.getOid());
		Assert.assertNull(this.orcamento3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.orcamento2 = this.orcamentoService.buscarPorId(this.orcamento2.getOid());
		Assert.assertNotNull(this.orcamento2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.orcamento1 = this.orcamentoService.salvar(this.orcamento1);
		this.orcamento2 = this.orcamentoService.salvar(this.orcamento2);
		this.orcamento4 = this.orcamentoService.salvar(this.orcamento4);
		
		Assert.assertNotNull(orcamento1);
		Assert.assertNotNull(orcamento2);		
		Assert.assertNotNull(orcamento4);
		
		logger.info("End test entity Orcamento");
	}
	
	@Test
	public void testeVenda()throws Exception{
		logger.info("Initializing test entity Venda");	
		
		List<FormaPagamento> fPagamentos = this.formaPagamentoService.buscarTodos();
		List<Representante> lRepresentante = this.representanteService.buscarTodos();
		List<Atendimento> lAtendimento = this.atendimentoService.buscarTodos();
		List<Cliente> lCliente = this.clienteService.buscarTodos();		
		List<Produto> lProduto = this.produtoService.buscarTodos();
		
		ProdutoVenda vp1 = new ProdutoVenda(lProduto.get(0), 4, 5f, 20f);
		ProdutoVenda vp2 = new ProdutoVenda(lProduto.get(1), 1, 15f, 15f);
		ProdutoVenda vp3 = new ProdutoVenda(lProduto.get(2), 2, 15f, 30f);
		ProdutoVenda vp4 = new ProdutoVenda(lProduto.get(2), 3, 3f, 9f);
		
		List<ProdutoVenda> lvp1 = new ArrayList<ProdutoVenda>();
		lvp1.add(vp1);
		List<ProdutoVenda> lvp2 = new ArrayList<ProdutoVenda>();
		lvp2.add(vp2);
		List<ProdutoVenda> lvp3 = new ArrayList<ProdutoVenda>();
		lvp3.add(vp3);
		List<ProdutoVenda> lvp4 = new ArrayList<ProdutoVenda>();
		lvp4.add(vp4);
						
		Venda v1 = new Venda(lCliente.get(0), lRepresentante.get(0), lvp1, lAtendimento.get(0));
		Venda v2 = new Venda(lCliente.get(2), lRepresentante.get(0), lvp2, lAtendimento.get(1));
		Venda v3 = new Venda(lCliente.get(1), lRepresentante.get(0), lvp3, lAtendimento.get(2));
		Venda v4 = new Venda(lCliente.get(1), lRepresentante.get(0), lvp4, null);
		
		this.venda1 = new Caixa(TipoCaixa.RECEITA, 150.30f, Utils.parseStringToDate("04/07/2010"), Utils.parseStringToDate("19/07/2010"), false, null, v1, fPagamentos.get(2), null, "Feito..");
		this.venda2 = new Caixa(TipoCaixa.RECEITA, 134.30f, Utils.parseStringToDate("12/07/2011"), Utils.parseStringToDate("12/09/2010"), false, null, v2, fPagamentos.get(2), null, "Feito..");
		this.venda3 = new Caixa(TipoCaixa.RECEITA, 130.30f, Utils.parseStringToDate("08/10/2010"), Utils.parseStringToDate("13/07/2009"), false, null, v3, fPagamentos.get(2), null, "Feito..");
		this.venda4 = new Caixa(TipoCaixa.RECEITA, 165.30f, Utils.parseStringToDate("04/11/2011"), Utils.parseStringToDate("12/07/2011"), false, null, v4, fPagamentos.get(2), null, "Feito..");
			
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.venda1 = this.vendaService.salvar(this.venda1);
		this.venda2 = this.vendaService.salvar(this.venda2);
		this.venda3 = this.vendaService.salvar(this.venda3);
		this.venda4 = this.vendaService.salvar(this.venda4);
		
		Assert.assertNotNull(venda1);
		Assert.assertNotNull(venda2);
		Assert.assertNotNull(venda3);
		Assert.assertNotNull(venda4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Caixa> list = this.vendaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertNotNull(list.size() > 4);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.venda3 = this.vendaService.buscarPorId(this.venda3.getOid());
		Assert.assertNotNull(this.venda3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.venda2 = this.vendaService.buscarPorId(this.venda2.getOid());
		Assert.assertNotNull(this.venda2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.venda1 = this.vendaService.salvar(this.venda1);
		this.venda2 = this.vendaService.salvar(this.venda2);
		this.venda4 = this.vendaService.salvar(this.venda4);
		
		Assert.assertNotNull(venda1);
		Assert.assertNotNull(venda2);	
		Assert.assertNotNull(venda3);		
		Assert.assertNotNull(venda4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.vendaService.deletar(this.venda1);
		this.vendaService.deletar(this.venda2);
		this.vendaService.deletar(this.venda3);
		this.vendaService.deletar(this.venda4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.vendaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertTrue(list.size() == 0);
		
		logger.info("End test entity Venda");
	}
	
	@Test
	public void testeVisita()throws Exception{
		logger.info("Initializing test entity Visita");	
		
		List<Representante> lRepresentante = this.representanteService.buscarTodos();
		List<Atendimento> lAtendimentos = this.atendimentoService.buscarTodos();
		List<Cliente> lCliente = this.clienteService.buscarTodos();
		
		Calendar c = Calendar.getInstance();
		int cyear = c.get(Calendar.YEAR);
		int cmonth = c.get(Calendar.MONTH)+ 1;
		int cday = c.get(Calendar.DAY_OF_MONTH);
		
		Date dt = Utils.parseStringToDate(cday+"/"+ cmonth+"/"+ cyear);
						
		this.visita1 = new Visita(lAtendimentos.get(0), 
								  lRepresentante.get(1), 
								  Utils.parseStringToDate("11/11/2009"), 
								  Utils.parseStringToDate("12/12/2010"), 
								  lCliente.get(0), 
								  "Cliente está confiante com os produtos já oferecidos na visita anterior",
								  null,
								  true);
		
		this.visita2 = new Visita(lAtendimentos.get(1), 
								  lRepresentante.get(2), 
								  Utils.parseStringToDate("13/13/2009"), 
								  Utils.parseStringToDate("07/07/2011"), 
								  lCliente.get(1), 
								  "A visita deverá deve acontecer entre as 10:00 até 12:00", 
								  Utils.parseStringToDate("10/07/2011"),
								  false);
		
		this.visita3 = new Visita(null, 
								  lRepresentante.get(0), 
								  Utils.parseStringToDate("15/07/2010"), 
								  Utils.parseStringToDate("16/07/2010"), 
								  lCliente.get(2), 
								  "Cliente está confiante com os produtos já oferecidos na visita anterior", 
								  null,
								  true);
		
		this.visita4 = new Visita(null, 
								  lRepresentante.get(2), 
								  Utils.parseStringToDate("06/06/2009"), 
								  dt, 
								  lCliente.get(1), 
								  "Levar produtos de amostra",
								  Utils.parseStringToDate("13/05/2011"),
								  false);
		
		this.visita5 = new Visita(null, 
								  lRepresentante.get(2), 
								  Utils.parseStringToDate("06/06/2009"), 
								  dt, 
								  lCliente.get(2), 
								  "Levar panos de prato e panos de chão para amostra",
								  null,
								  false);
		
		this.visita6 = new Visita(null, 
								  lRepresentante.get(1), 
								  Utils.parseStringToDate("06/06/2009"), 
								  dt, 
								  lCliente.get(0), 
								  "Verificar possibilidade de realzar a visita no periodo da tarde",
								  null,
								  false);
		
		this.visita7 = new Visita(null, 
								  lRepresentante.get(1),
								  Utils.parseStringToDate("06/06/2009"), 
								  dt, 
								  lCliente.get(1), 
								  "",
								  null,
								  false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...");
		this.visita1 = this.visitaService.salvar(this.visita1);
		this.visita2 = this.visitaService.salvar(this.visita2);
		this.visita3 = this.visitaService.salvar(this.visita3);
		this.visita4 = this.visitaService.salvar(this.visita4);
		this.visita5 = this.visitaService.salvar(this.visita5);
		this.visita6 = this.visitaService.salvar(this.visita6);
		this.visita7 = this.visitaService.salvar(this.visita7);
		
		Assert.assertNotNull(visita1);
		Assert.assertNotNull(visita2);
		Assert.assertNotNull(visita3);
		Assert.assertNotNull(visita4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Visita> list = this.visitaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.visitaService.deletar(this.visita3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.visitaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 6);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.visita3 = this.visitaService.buscarPorId(this.visita3.getOid());
		Assert.assertNull(this.visita3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.visita2 = this.visitaService.buscarPorId(this.visita2.getOid());
		Assert.assertNotNull(this.visita2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.visita1 = this.visitaService.salvar(this.visita1);
		this.visita2 = this.visitaService.salvar(this.visita2);
		this.visita4 = this.visitaService.salvar(this.visita4);
		
		Assert.assertNotNull(visita1);
		Assert.assertNotNull(visita2);		
		Assert.assertNotNull(visita4);
		
		logger.info("End test entity Visita");
	}
	
	@Test
	public void testeCaixa()throws Exception{
		logger.info("Initializing test entity Caixa");	
		
		List<Funcionario> funcionarios = this.funcionarioService.buscarTodos();
		List<FormaPagamento> fPagamentos = this.formaPagamentoService.buscarTodos();
		List<Fornecedor> fornecedores = this.fornecedorService.buscarTodos();			
		List<Material> lMaterial = this.materialService.buscarTodos();
		List<Representante> lRepresentante = this.representanteService.buscarTodos();
		List<Atendimento> lAtendimento = this.atendimentoService.buscarTodos();
		List<Cliente> lCliente = this.clienteService.buscarTodos();		
		List<Produto> lProduto = this.produtoService.buscarTodos();
		
		MaterialCompra mc1 = new MaterialCompra(lMaterial.get(2), 1, 6f, 6f);
		MaterialCompra mc2 = new MaterialCompra(lMaterial.get(1), 3, 15f, 45f);
		MaterialCompra mc3 = new MaterialCompra(lMaterial.get(1), 2, 43f, 86f);
		MaterialCompra mc4 = new MaterialCompra(lMaterial.get(0), 3, 10f, 30f);
		
		List<MaterialCompra> materiais1 = new ArrayList<MaterialCompra>();
		materiais1.add(mc1);		
		
		List<MaterialCompra> materiais2 = new ArrayList<MaterialCompra>();
		materiais2.add(mc2);
				
		List<MaterialCompra> materiais3 = new ArrayList<MaterialCompra>();
		materiais3.add(mc3);		
		
		List<MaterialCompra> materiais4 = new ArrayList<MaterialCompra>();		
		materiais4.add(mc4);	
		
		Compra c1 = new Compra(fornecedores.get(0), funcionarios.get(2), materiais1);
		Compra c2 = new Compra(fornecedores.get(1), funcionarios.get(2), materiais2);
		Compra c3 = new Compra(fornecedores.get(2), funcionarios.get(2), materiais3);
		Compra c4 = new Compra(fornecedores.get(0), funcionarios.get(2), materiais4);		
		
		ProdutoVenda vp1 = new ProdutoVenda(lProduto.get(0), 4, 5f, 20f);
		ProdutoVenda vp2 = new ProdutoVenda(lProduto.get(1), 1, 15f, 15f);
		ProdutoVenda vp3 = new ProdutoVenda(lProduto.get(2), 2, 15f, 30f);
		ProdutoVenda vp4 = new ProdutoVenda(lProduto.get(2), 3, 3f, 9f);
		
		List<ProdutoVenda> lvp1 = new ArrayList<ProdutoVenda>();
		lvp1.add(vp1);
		List<ProdutoVenda> lvp2 = new ArrayList<ProdutoVenda>();
		lvp2.add(vp2);
		List<ProdutoVenda> lvp3 = new ArrayList<ProdutoVenda>();
		lvp3.add(vp3);
		List<ProdutoVenda> lvp4 = new ArrayList<ProdutoVenda>();
		lvp4.add(vp4);
						
		Venda v1 = new Venda(lCliente.get(0), lRepresentante.get(0), lvp1, lAtendimento.get(0));
		Venda v2 = new Venda(lCliente.get(2), lRepresentante.get(0), lvp2, lAtendimento.get(1));
		Venda v3 = new Venda(lCliente.get(1), lRepresentante.get(0), lvp3, lAtendimento.get(2));
		Venda v4 = new Venda(lCliente.get(1), lRepresentante.get(0), lvp4, null);
		
		this.venda1 = new Caixa(TipoCaixa.DESPESA, 150.30f, Utils.parseStringToDate("04/07/2010"), Utils.parseStringToDate("19/07/2010"), false, null, v1, fPagamentos.get(2), null, "Feito..");
		this.venda2 = new Caixa(TipoCaixa.DESPESA, 134.30f, Utils.parseStringToDate("12/07/2011"), Utils.parseStringToDate("12/09/2010"), false, null, v2, fPagamentos.get(2), null, "Feito..");
		this.venda3 = new Caixa(TipoCaixa.DESPESA, 130.30f, Utils.parseStringToDate("08/10/2010"), Utils.parseStringToDate("13/07/2009"), false, null, v3, fPagamentos.get(2), null, "Feito..");
		this.venda4 = new Caixa(TipoCaixa.DESPESA, 165.30f, Utils.parseStringToDate("04/11/2011"), Utils.parseStringToDate("12/07/2011"), false, null, v4, fPagamentos.get(2), null, "Feito..");
				
		this.caixa1 = new Caixa(TipoCaixa.DESPESA, 150.30f, Utils.parseStringToDate("14/07/2011"), Utils.parseStringToDate("12/02/2011"), true,  c1, null, fPagamentos.get(0), null, "Feito..");
		this.caixa2 = new Caixa(TipoCaixa.DESPESA, 300.30f, Utils.parseStringToDate("09/07/2011"), Utils.parseStringToDate("11/04/2010"), false, c2, null, fPagamentos.get(1), null, "Feito..");		
		this.caixa3 = new Caixa(TipoCaixa.DESPESA, 290.30f, Utils.parseStringToDate("14/08/2010"), Utils.parseStringToDate("13/03/2011"), false, c3, null, fPagamentos.get(2), null, "Feito..");
		this.caixa4 = new Caixa(TipoCaixa.DESPESA, 290.30f, Utils.parseStringToDate("04/07/2010"), Utils.parseStringToDate("14/07/2010"), false, c4, null, fPagamentos.get(1), null, "Feito..");
		
		this.caixa5 = new Caixa(TipoCaixa.RECEITA, 150.30f, Utils.parseStringToDate("04/07/2011"), Utils.parseStringToDate("12/07/2010"), false, null, v1, fPagamentos.get(2), null, "Feito..");
		this.caixa6 = new Caixa(TipoCaixa.RECEITA, 300.30f, Utils.parseStringToDate("14/06/2010"), Utils.parseStringToDate("04/10/2011"), false, null, v2, fPagamentos.get(0), null, "Feito..");
		this.caixa7 = new Caixa(TipoCaixa.RECEITA, 250.30f, Utils.parseStringToDate("17/05/2011"), Utils.parseStringToDate("14/09/2011"), true, null,  v3, fPagamentos.get(0), null, "Feito..");
		this.caixa8 = new Caixa(TipoCaixa.RECEITA, 290.30f, Utils.parseStringToDate("07/04/2010"), Utils.parseStringToDate("09/07/2011"), false, null, v4, fPagamentos.get(1), null, "Feito..");
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...");
		
		this.caixa1 = this.caixaService.salvar(this.caixa1);
		this.caixa2 = this.caixaService.salvar(this.caixa2);
		this.caixa3 = this.caixaService.salvar(this.caixa3);
		this.caixa4 = this.caixaService.salvar(this.caixa4);
		
		this.caixa5 = this.caixaService.salvar(this.caixa5);
		this.caixa6 = this.caixaService.salvar(this.caixa6);
		this.caixa7 = this.caixaService.salvar(this.caixa7);
		this.caixa8 = this.caixaService.salvar(this.caixa8);
				
		Assert.assertNotNull(caixa1);
		Assert.assertNotNull(caixa2);
		Assert.assertNotNull(caixa3);
		Assert.assertNotNull(caixa4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Caixa> list = this.caixaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);		
		
		logger.info("Preparing to [DELETE]");		 
		logger.info("Go...");
		this.caixaService.deletar(this.caixa3);		
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.caixaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 7);		
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.caixa3 = this.caixaService.buscarPorId(this.caixa3.getOid());
		Assert.assertNull(this.caixa3);		
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.caixa2 = this.caixaService.buscarPorId(this.caixa2.getOid());
		Assert.assertNotNull(this.caixa2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.caixa1 = this.caixaService.salvar(this.caixa1);
		this.caixa2 = this.caixaService.salvar(this.caixa2);
		this.caixa4 = this.caixaService.salvar(this.caixa4);
		
		Assert.assertNotNull(caixa1);
		Assert.assertNotNull(caixa2);		
		Assert.assertNotNull(caixa5);		
		Assert.assertNotNull(caixa6);
		Assert.assertNotNull(caixa7);
		Assert.assertNotNull(caixa8);
				
		logger.info("End test entity Caixa");
	}
	
	@Test
	public void testeTipoDespesa()throws Exception{
		logger.info("Initializing test entity TipoDespesa");	
		
		this.tipoDespesa1 = new TipoDespesa("clz", "Conta de Luz", "Conta de Luz CELESC.", true);
		this.tipoDespesa2 = new TipoDespesa("aga", "Água", "Água CASAN", false);
		this.tipoDespesa3 = new TipoDespesa("mnm", "Manutenção", "Manutenção máquina", false);
		this.tipoDespesa4 = new TipoDespesa("out", "Outras", "Outras Despesas", false);
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.tipoDespesa1 = this.tipoDespesaService.salvar(this.tipoDespesa1);
		this.tipoDespesa2 = this.tipoDespesaService.salvar(this.tipoDespesa2);
		this.tipoDespesa3 = this.tipoDespesaService.salvar(this.tipoDespesa3);
		this.tipoDespesa4 = this.tipoDespesaService.salvar(this.tipoDespesa4);
		
		Assert.assertNotNull(tipoDespesa1);
		Assert.assertNotNull(tipoDespesa2);
		Assert.assertNotNull(tipoDespesa3);
		Assert.assertNotNull(tipoDespesa4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<TipoDespesa> list = this.tipoDespesaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.tipoDespesaService.deletar(this.tipoDespesa3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.tipoDespesaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.tipoDespesa3 = this.tipoDespesaService.buscarPorId(this.tipoDespesa3.getOid());
		Assert.assertNull(this.tipoDespesa3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.tipoDespesa2 = this.tipoDespesaService.buscarPorId(this.tipoDespesa2.getOid());
		Assert.assertNotNull(this.tipoDespesa2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.tipoDespesa1 = this.tipoDespesaService.salvar(this.tipoDespesa1);
		this.tipoDespesa2 = this.tipoDespesaService.salvar(this.tipoDespesa2);
		this.tipoDespesa4 = this.tipoDespesaService.salvar(this.tipoDespesa4);
		
		Assert.assertNotNull(tipoDespesa1);
		Assert.assertNotNull(tipoDespesa2);		
		Assert.assertNotNull(tipoDespesa4);
		
		logger.info("End test entity tipoDespesa");
	}
	
	@Test
	public void testeDespesa()throws Exception{
		logger.info("Initializing test entity despesa");	
		
		List<FormaPagamento> fPagamentos = this.formaPagamentoService.buscarTodos();
		List<TipoDespesa> lTipoDespesa = this.tipoDespesaService.buscarTodos();		
		
		Despesa despesa1 = new Despesa(lTipoDespesa.get(0), "Despesa com Luz");
		Despesa despesa2 = new Despesa(lTipoDespesa.get(1), "Despesa com água 1");
		Despesa despesa3 = new Despesa(lTipoDespesa.get(1), "Despesa com água 2");
		Despesa despesa4 = new Despesa(lTipoDespesa.get(2), "Despesa com manutenção máquina");
		
		this.despesa1 = new Caixa(TipoCaixa.DESPESA, 189.03f, Utils.parseStringToDate("12/08/2011"), Utils.parseStringToDate("14/02/2011"), false, null, null, fPagamentos.get(0), despesa1, "Feito..");
		this.despesa2 = new Caixa(TipoCaixa.DESPESA, 203.03f, Utils.parseStringToDate("15/07/2011"), Utils.parseStringToDate("11/08/2011"), true, null, null, fPagamentos.get(2), despesa2, "Feito..");
		this.despesa3 = new Caixa(TipoCaixa.DESPESA, 89.03f, Utils.parseStringToDate("14/08/2011"), Utils.parseStringToDate("15/09/2011"), false, null, null, fPagamentos.get(1), despesa3, "Feito..");
		this.despesa4 = new Caixa(TipoCaixa.DESPESA, 19.03f, Utils.parseStringToDate("14/07/2011"), Utils.parseStringToDate("12/08/2011"), true, null, null, fPagamentos.get(1), despesa4, "Feito..");
		
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.despesa1 = this.despesaService.salvar(this.despesa1);
		this.despesa2 = this.despesaService.salvar(this.despesa2);
		this.despesa3 = this.despesaService.salvar(this.despesa3);
		this.despesa4 = this.despesaService.salvar(this.despesa4);
		
		Assert.assertNotNull(despesa1);
		Assert.assertNotNull(despesa2);
		Assert.assertNotNull(despesa3);
		Assert.assertNotNull(despesa4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Caixa> list = this.despesaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.despesaService.deletar(this.despesa3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.despesaService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.despesa3 = this.despesaService.buscarPorId(this.despesa3.getOid());
		Assert.assertNull(this.despesa3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.despesa2 = this.despesaService.buscarPorId(this.despesa2.getOid());
		Assert.assertNotNull(this.despesa2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.despesa1 = this.despesaService.salvar(this.despesa1);
		this.despesa2 = this.despesaService.salvar(this.despesa2);
		this.despesa4 = this.despesaService.salvar(this.despesa4);
		
		Assert.assertNotNull(despesa1);
		Assert.assertNotNull(despesa2);		
		Assert.assertNotNull(despesa4);
		
		logger.info("End test entity despesa");
	}
	
	@Test
	public void testePromocao()throws Exception{
		logger.info("Initializing test entity Promocao");	
		
		List<Funcionario> fFuncionario = this.funcionarioService.buscarTodos();		
		
		this.promocao1 = new Promocao(Utils.parseStringToDate("10/12/2010"), TipoPromocao.AMBOS, "Panos de prato por apenas R$ 10,00", fFuncionario.get(0));
		this.promocao2 = new Promocao(Utils.parseStringToDate("10/09/2011"), TipoPromocao.EMAIL, "Estopa para tirar poeira por apenas os R$ 3,00", fFuncionario.get(1));
		this.promocao3 = new Promocao(Utils.parseStringToDate("16/10/2010"), TipoPromocao.AMBOS, "Novas toalhas de banho tamanho gg para praia, por apenas R$ 35,00", fFuncionario.get(2));
		this.promocao4 = new Promocao(Utils.parseStringToDate("12/12/2009"), TipoPromocao.TWITTER, "Promocao de tolhas de mesa R$ 25,00, primeiros 100 retweets", fFuncionario.get(2));
				
		logger.info("Preparing to [SAVE]");
		logger.info("Go...'");
		this.promocao1 = this.promocaoService.salvar(this.promocao1);
		this.promocao2 = this.promocaoService.salvar(this.promocao2);
		this.promocao3 = this.promocaoService.salvar(this.promocao3);
		this.promocao4 = this.promocaoService.salvar(this.promocao4);
		
		Assert.assertNotNull(promocao1);
		Assert.assertNotNull(promocao2);
		Assert.assertNotNull(promocao3);
		Assert.assertNotNull(promocao4);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		List<Promocao> list = this.promocaoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 4);
		
		logger.info("Preparing to [DELETE]");
		logger.info("Go...");
		this.promocaoService.deletar(this.promocao3);
		
		logger.info("Preparing to [LIST ALL]");	
		logger.info("Go...");
		list = this.promocaoService.buscarTodos();	
		logger.info(" Size entity [" + list.size() + "]");
		Assert.assertFalse(list.size() < 3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.promocao3 = this.promocaoService.buscarPorId(this.promocao3.getOid());
		Assert.assertNull(this.promocao3);
		
		logger.info("Preparing to [FIND BY ID]");
		logger.info("Go...");
		this.promocao2 = this.promocaoService.buscarPorId(this.promocao2.getOid());
		Assert.assertNotNull(this.promocao2);
		
		logger.info("Preparing to [UPDATE]");
		logger.info("Go...");
		this.promocao1 = this.promocaoService.salvar(this.promocao1);
		this.promocao2 = this.promocaoService.salvar(this.promocao2);
		this.promocao4 = this.promocaoService.salvar(this.promocao4);
		
		Assert.assertNotNull(promocao1);
		Assert.assertNotNull(promocao2);		
		Assert.assertNotNull(promocao4);
		
		logger.info("End test entity Promocao");
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public void testFindUserByLogin() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAllUsers() {
		//fail("Not yet implemented");
	}
}
