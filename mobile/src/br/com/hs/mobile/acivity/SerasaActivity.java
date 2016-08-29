package br.com.hs.mobile.acivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.hs.mobile.service.WebServiceUtil;

public class SerasaActivity  extends Activity {
	
	private EditText identificador, nome, situacaoDocumento, totalOcorrencias;
	
	private Button btConsultar;
		
	private Intent intent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.serasa);

		this.btConsultar = (Button) findViewById(R.id.btConsultaSerasa);
		this.identificador = (EditText) findViewById(R.id.txtNrIdentificadorSerasa);	
		this.nome = (EditText) findViewById(R.id.txtNomeClienteSerasa);	
		this.situacaoDocumento = (EditText) findViewById(R.id.txtSituacaoDocumentoSerasa);	
		this.totalOcorrencias = (EditText) findViewById(R.id.txtTotalOcorrenciasSerasa);
		
		this.btConsultar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				consultaSerasa();
			}
		});
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
	
	private void consultaSerasa(){
		
		/*			 
	    00027562000
		00002364115
		00002047810
		10441918808
		99234793587
		*/
		
		String url         = "http://www.consultacpf.com/webservices/test-drive/consultacpf.asmx";
		String name_space  = "ConsultaCPF";
		String soap_action = "ConsultaCPF/";
		String method      = "ConsultaDetalhadaSERASA";		
		String usuario     = "hsempresatextil@gmail.com";
		String senha       = "$hs123";
		String documento   =  this.identificador.getText().toString();
		String[] object    = {"EMail;" + usuario, "Senha;" + senha, "Documento;" + documento};
		
		try {			
			String[] result = WebServiceUtil.chamaWsDotNet(method, object, soap_action, name_space, url).split(";");			
			Boolean retornoValido = (result!=null && result[0].indexOf("anyType{}") < 0);
			if(retornoValido){
				mostraDadosSerasa(result[1].split("=")[1], result[4].split("=")[1], result[5].split("=")[1]);
				mostraMensagem("Situação: " + result[4].split("=")[1] + " com  total de ocorrências: " + result[5].split("=")[1] + ".");
			}else{
				mostraMensagem("Não foram encontrados registros para o documento: " + documento + ".");
				mostraDadosSerasa("", "", "");
			}
		}catch (Exception e) {
			// TODO: handle exception
			mostraMensagem("Ocorreu um erro durante a chamada do WS do SERASA: " + e.getMessage());
			e.printStackTrace();
		} 		
	}
	
	private void mostraDadosSerasa(String nome, String situacaoDocumento, String totalOcorrencias){
		this.nome.setText(nome);
		this.situacaoDocumento.setText(situacaoDocumento);
		this.totalOcorrencias.setText(totalOcorrencias);
		
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
