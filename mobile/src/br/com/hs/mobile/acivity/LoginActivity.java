package br.com.hs.mobile.acivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.hs.mobile.application.GlobalVar;
import br.com.hs.mobile.service.WebServiceUtil;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.mobile.utils.XStreamCustom;
import br.com.hs.model.entity.Representante;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */

	private Intent intent;
	private Button button;
	private EditText login;
	private EditText password;
	private Representante usuario;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		this.button = (Button) findViewById(R.id.btAcessar);
		this.login = (EditText) findViewById(R.id.txtLogin);
		this.password = (EditText) findViewById(R.id.txtPassword);
		this.intent = new Intent(this, MasterActivity.class);

		this.button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Representante r = autenticar();
				if (r != null) {
					GlobalVar.getInstance().setUsuario(r);
					startActivity(intent);
					setContentView(R.layout.master);
					finish();
				}else{
					mostraMensagem("Usuário ínvalido!");
				}
			}
		});
	}
		
	private Representante autenticar() {

		Resources r = this.getResources();
		String url = r.getString((R.string.url));
		String name_space = r.getString(R.string.name_space);
		String soap_action = r.getString(R.string.soap_action);

		String usuario = this.login.getText().toString();
		String senha = Utils.MD5(this.password.getText().toString());				
		String[] params = { "usur;" + usuario, "pwrd;" + senha };
		
		try {

			XStreamCustom xStream = new XStreamCustom();
			String result = WebServiceUtil.chamaWsJava("", "", "autenticaUsuario", "services",params, soap_action, name_space, url).toString();			
			this.usuario = (Representante) xStream.fromXML(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mostraMensagem("Ocorreu um erro ao acessar o WS da HS. Verifique o status do serviço e se você possui permissão de acesso ao WS.");
			e.printStackTrace();
		}
		return this.usuario;
	}

	private void mostraMensagem(String msg) {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setMessage(msg);
		alertbox.setNeutralButton("OK", null);
		alertbox.show();
	}
}