package br.com.hs.mobile.acivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import br.com.hs.mobile.adapter.ProdutoEstoqueAdapter;
import br.com.hs.mobile.application.GlobalVar;
import br.com.hs.mobile.service.WebServiceUtil;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.mobile.utils.XStreamCustom;
import br.com.hs.model.entity.Produto;

public class EstoqueActivity extends Activity {
	
	private List<Produto> listProdutos;
	
	private ProdutoEstoqueAdapter produtoEstoqueAdapter;
	
	private EditText txtProduto;
	
	private ListView lvProdutoEstoque;
	
	private Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estoque);
		inicio();
	}
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		menu.add("Voltar");
		menu.getItem(0).setIcon(R.drawable.voltar);
        return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {												
		intent = new Intent(getApplicationContext(),MasterActivity.class);
		startActivity(intent);
		setContentView(R.layout.master);			
		return true;
	}
	
	private void inicio(){
		this.txtProduto = (EditText) findViewById(R.id.txtProdutoEstoque);
		this.txtProduto.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				 filtraProdutos();
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub				
			}
		});
		this.listProdutos = new ArrayList<Produto>();
		this.produtoEstoqueAdapter = new ProdutoEstoqueAdapter(this, this.listProdutos);
		this.lvProdutoEstoque = (ListView) findViewById(R.id.listProdutosEstoque);
		this.lvProdutoEstoque.setAdapter(this.produtoEstoqueAdapter);
		this.buscaProdutos();
	}
	
	@SuppressWarnings("unchecked")
	private void buscaProdutos(){	
				
		this.listProdutos = (ArrayList<Produto>) executaWS("buscaProdutos", null);
		if (this.listProdutos == null) {
			this.listProdutos = new ArrayList<Produto>();
		}				
		this.produtoEstoqueAdapter.setList(this.listProdutos);		
		Utils.setListViewHeightBasedOnChildren(this.lvProdutoEstoque);		
	}
	
	private void filtraProdutos(){
		String filtro = this.txtProduto.getText().toString();
		if(filtro.equals("")){
			this.buscaProdutos();
			return;
		}
			
		List<Produto> result = new ArrayList<Produto>();
		for (Produto p : this.produtoEstoqueAdapter.getList()) {
			if(p.getNome().toLowerCase().contains(filtro.toLowerCase()) || 
					p.getId().toLowerCase().contains(filtro.toLowerCase()))
				result.add(p);
		}
		this.produtoEstoqueAdapter.setList(result);		
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
