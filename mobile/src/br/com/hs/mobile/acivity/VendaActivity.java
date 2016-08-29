package br.com.hs.mobile.acivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import br.com.hs.mobile.adapter.AutoCompleteAdapter;
import br.com.hs.mobile.adapter.ProdutoVendaAdapter;
import br.com.hs.mobile.application.GlobalVar;
import br.com.hs.mobile.constante.TipoCaixa;
import br.com.hs.mobile.service.WebServiceUtil;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.mobile.utils.XStreamCustom;
import br.com.hs.model.entity.Caixa;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.FormaPagamento;
import br.com.hs.model.entity.Produto;
import br.com.hs.model.entity.ProdutoVenda;
import br.com.hs.model.entity.Venda;

public class VendaActivity extends Activity {
	/** Called when the activity is first created. */
	
	private ProdutoVendaAdapter adapterPV;
		
	private Intent intent;
	
	private AutoCompleteTextView atc1, atc2, atc3;	
	
	private ListView lvPV;
	
	private Button button;
	
	private EditText txtQtd, txtVlTotal, txtNomePV, txtObsVenda;
	
	private DatePicker dtVencimento;
	
	private List<FormaPagamento> listFormaPagamento;
	
	private List<Produto> listProduto;
	
	private List<Cliente> listCliente;
	
	private List<ProdutoVenda> listPV;
	
	private Cliente cliente;
	
	private FormaPagamento formaPagamento;
	
	private Produto produto;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.venda);
		inicio();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        menu.getItem(1).setTitle("Salvar");
		menu.getItem(1).setIcon(R.drawable.salvar);
        return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getTitle().equals("Voltar")){											
			intent = new Intent(getApplicationContext(),MasterActivity.class);
			startActivity(intent);
			setContentView(R.layout.master);			
		}else{			
			if (validaVenda()){					
				AlertDialog.Builder alertbox = new AlertDialog.Builder(this);									
				alertbox.setMessage("Confirmar venda?");
				alertbox.setIcon(android.R.drawable.ic_dialog_alert);
				alertbox.setNegativeButton(android.R.string.no, null);
				alertbox.setPositiveButton(android.R.string.yes,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton) {
							efetivaVenda();
						}
					});							
				alertbox.show();
			}				
		}		
		return true;
	}

	private void inicio() {
				
		this.button = (Button) findViewById(R.id.btAdicionarListPV);
		
		this.button.setOnClickListener((new View.OnClickListener() {
			public void onClick(View v) {
				adicionaProduto();
			}
		}));		
				
		this.atc1 = (AutoCompleteTextView) findViewById(R.id.txtCliente);		
		this.atc1.setAdapter(new AutoCompleteAdapter<Cliente>(this, android.R.layout.simple_dropdown_item_1line, buscaClientes()));
		this.atc1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            	cliente = listCliente.get(arg1.getId());            	
            }
        });

		this.atc2 = (AutoCompleteTextView) findViewById(R.id.txtFormaPagamento);		
		this.atc2.setAdapter(new AutoCompleteAdapter<FormaPagamento>(this, android.R.layout.simple_dropdown_item_1line, buscaFormasPagto()));		
		this.atc2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            	formaPagamento = listFormaPagamento.get(arg1.getId());            	
            }
        });
		
		this.atc3 = (AutoCompleteTextView) findViewById(R.id.txtProdutoPV);		
		this.atc3.setAdapter(new AutoCompleteAdapter<Produto>(this, android.R.layout.simple_dropdown_item_1line, buscaProdutos()));		
		this.atc3.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            	produto = listProduto.get(arg1.getId());            	
            	EditText s = (EditText) findViewById(R.id.txtQtProdutoPV);	
            	
            	if(s.getText().toString().equals(""))
            		return;
            	
            	float qtd = Integer.parseInt(s.getText().toString());
            	txtVlTotal.setText(Utils.formatCurrency(qtd * produto.getValor()));
            }
        });
				
		this.txtQtd = (EditText) findViewById(R.id.txtQtProdutoPV);			
		this.txtQtd.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if(produto==null || s.toString().equals(""))
					return;				
				
				float qtd = Integer.parseInt(s.toString());
				txtVlTotal.setText(Utils.formatCurrency(qtd * produto.getValor()));				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub						
			}
		});
		
		this.dtVencimento = (DatePicker) findViewById(R.id.dtVencimento);	
		this.txtVlTotal = (EditText) findViewById(R.id.txtValorTotalPV);	
		this.txtNomePV = (EditText) findViewById(R.id.txtProdutoPV);	
		this.txtObsVenda = (EditText) findViewById(R.id.txtObservacaoVenda);	
		this.listPV = new ArrayList<ProdutoVenda>();
		this.adapterPV = new ProdutoVendaAdapter(this, listPV);
		this.lvPV = (ListView) findViewById(R.id.lvProdutosPV);
		this.lvPV.setAdapter(adapterPV);		
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Produto> buscaProdutos() {
		this.listProduto = (List<Produto>) executaWS("buscaProdutos", null);		
		if(this.listProduto == null || this.listProduto.size() <=0) {			
			this.mostraMensagem("Não foram encontrados itens com o parâmetro informado. Verifique o cadastro de produtos e a conexão com o aplicativo da HS.");
		}
		return (ArrayList<Produto>) this.listProduto;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Cliente> buscaClientes() {
		this.listCliente = (List<Cliente>) executaWS("buscaClientes", null);
		if(this.listCliente == null || this.listCliente.size() <=0) {			
			this.mostraMensagem("Não foram encontrados itens com o parâmetro informado. Verifique o cadastro de clientes e a conexão com o aplicativo da HS.");
		}
		return (ArrayList<Cliente>) this.listCliente;
	}

	@SuppressWarnings("unchecked")
	private ArrayList<FormaPagamento> buscaFormasPagto() {
		this.listFormaPagamento = (List<FormaPagamento>) executaWS("buscaFormasPagamento", null);	
		if(this.listFormaPagamento == null || this.listFormaPagamento.size() <=0) {			
			this.mostraMensagem("Não foram encontrados itens com o parâmetro informado. Verifique o cadastro de formas de pagamento e a conexão com o aplicativo da HS.");
		}
		return (ArrayList<FormaPagamento>) this.listFormaPagamento;
	}

	private Object executaWS(String method, String[] object) {
		Resources r = this.getResources();
		String url = r.getString((R.string.url));
		String name_space = r.getString(R.string.name_space);
		String soap_action = r.getString(R.string.soap_action);
		Object result = null;
		
		String usuario = GlobalVar.getInstance().getUsuario().getUsuario();
		String senha   = GlobalVar.getInstance().getUsuario().getSenha();
		
		try {
			XStreamCustom xStream = new XStreamCustom();
			String strResult = WebServiceUtil.chamaWsJava(usuario, senha, method, "services", object,
					soap_action, name_space, url).toString();
			result = (Object) xStream.fromXML(strResult);
		}catch (Exception e) {
			// TODO: handle exception
			mostraMensagem("Ocorreu um erro ao acessar o WS da HS. Verifique o status do serviço e se você possui permissão de acesso ao WS.");
			e.printStackTrace();
		} 
		return result;
	}
	
	private void adicionaProduto(){		
				
		EditText qtd = (EditText) findViewById(R.id.txtQtProdutoPV);
		EditText pdt = (EditText) findViewById(R.id.txtProdutoPV);		
		
		if(pdt.getText().toString().equals("")){
			this.mostraMensagem("Favor, informe um produto.");
			return;
		}else if(qtd.getText().toString().equals("")){			
			this.mostraMensagem("Favor, informe a quantidade do produto.");
			return;
		}
		
		final Float qtdNumber = Utils.parseStringToFloat(qtd.getText().toString());
		if(qtdNumber<=0){				
			this.mostraMensagem("Favor, a quantidade informada deve ser maior que 0.");
			return;
		}			
		
		for (ProdutoVenda pv : this.listPV) {
			System.out.println(pv.getProduto().getId() + " " + this.produto.getId());
			if(pv.getProduto().equals(this.produto)){
				this.mostraMensagem("Item já foi adicionado a lista de produtos.");
				return;
			}
		}
						
		if(qtdNumber > this.produto.getQtdEstoque()){				
			AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
			alertbox.setTitle("Confirmar venda");					
			alertbox.setMessage("A quantidade em estoque do produto informado é de apenas: " +this.produto.getQtdEstoque().intValue()+ ". Deseja continuar?.");
			alertbox.setIcon(android.R.drawable.ic_dialog_alert);				
			alertbox.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {							
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					confirmarAdicionarProduto(qtdNumber);
				}										
			});
			alertbox.setNegativeButton(android.R.string.no, null);						
			alertbox.show();			
		}else
			confirmarAdicionarProduto(qtdNumber);			
	}
	
	private void confirmarAdicionarProduto(Float qtd){
				
		float vl = Utils.parseStringToFloat(this.txtVlTotal.getText().toString());
		
		ProdutoVenda pv = new ProdutoVenda();
		pv.setValorTotal(vl);
		pv.setProduto(this.produto);
		pv.setQuantidade(qtd.intValue());
		
		this.produto.setQtdEstoque(this.produto.getQtdEstoque() - qtd);
		pv.setValorUnitario(this.produto.getValor());
		
		this.txtQtd.setText("");
		this.txtNomePV.setText("");
		this.txtVlTotal.setText("R$0,00");
		
		this.adapterPV.add(pv);	
		Utils.setListViewHeightBasedOnChildren(this.lvPV);		
	}
	
	private void efetivaVenda() {		
						
		float vlTotal = 0;
		for (ProdutoVenda pv : this.listPV) {
			vlTotal += pv.getValorTotal();
		}			
		
		Venda v = new Venda();
		v.setCliente(this.cliente);
		v.setRepresentante(GlobalVar.getInstance().getUsuario());
		v.setProdutos(this.listPV);
		
		Caixa c = new Caixa();
		c.setFormaPagamento(this.formaPagamento);
		c.setVenda(v);
		c.setDataVencimento(new Date((this.dtVencimento.getYear()-1900), this.dtVencimento.getMonth(), (this.dtVencimento.getDayOfMonth()+1)));
		c.setValor(vlTotal);
		c.setDataCaixa(new Date());
		c.setObservacao(this.txtObsVenda.getText().toString());
		c.setTipo(TipoCaixa.RECEITA);
				
		String cS = new XStreamCustom().toXML(c);
		String[] params = {"venda;"+cS}; 
		String ret = (String) executaWS("efetuaVenda", params);
		mostraMensagem(ret);
		this.limpaDadosVenda();
	}
	
	private void limpaDadosVenda(){	
		this.atc1.setText("");
		this.atc2.setText(""); 
		this.atc3.setText("");	
		this.txtQtd.setText(""); 
		this.txtVlTotal.setText(""); 
		this.txtNomePV.setText("");
		this.txtObsVenda.setText("");
				
		for (ProdutoVenda pv : this.adapterPV.getList()) {
			this.adapterPV.getList().remove(pv);
			this.adapterPV.notifyDataSetChanged();   
		} 
	}
	
	private Boolean validaVenda() {		
		
		EditText cliente = (EditText) findViewById(R.id.txtCliente);
		EditText formaPagto = (EditText) findViewById(R.id.txtFormaPagamento);

		if (cliente.getText().toString().equals("")) {		
			this.mostraMensagem("Favor, informe o cliente.");			
			return false;
		}

		if (formaPagto.getText().toString().equals("")) {			
			this.mostraMensagem("Favor, informe a forma de pagamento.");			
			return false;
		}

		if (this.adapterPV.getCount() <= 0) {			
			this.mostraMensagem("Favor, informa ao menos um produto.");			
			return false;
		}		
		return true;
	}
	
	private void mostraMensagem(String msg){
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setMessage(msg);
		alertbox.setNeutralButton("OK", null);
		alertbox.show();
	}
	
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
		final Intent intentMaster = new Intent(this, MasterActivity.class);	        
        if(keyCode==KeyEvent.KEYCODE_BACK) {                          
            startActivity(intentMaster);
			setContentView(R.layout.master);
			finish();
        }  
        if (keyCode == KeyEvent.KEYCODE_MENU) {			
			openOptionsMenu();
		}
        return true;  
    } 
	
}