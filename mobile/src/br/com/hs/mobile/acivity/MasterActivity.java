package br.com.hs.mobile.acivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MasterActivity extends Activity {

	private TextView agenda, venda, estoque, serasa;
	
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.master);

		this.agenda = (TextView) findViewById(R.id.btAcessarAgenda);
		this.venda = (TextView) findViewById(R.id.btAcessarVenda);
		this.estoque = (TextView) findViewById(R.id.btAcessarEstoque);
		this.serasa = (TextView) findViewById(R.id.btAcessarSerasa);

		final Intent intentVenda = new Intent(this, VendaActivity.class);
		final Intent intentAgenda = new Intent(this, AgendaActivity.class);
		final Intent intentEstoque = new Intent(this, EstoqueActivity.class);
		final Intent intentSerasa = new Intent(this, SerasaActivity.class);

		venda.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {					
				startActivity(intentVenda);
				setContentView(R.layout.venda);
				finish();				
			}
		});

		agenda.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(intentAgenda);
				setContentView(R.layout.agenda);
				finish();
			}
		});

		estoque.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(intentEstoque);
				setContentView(R.layout.estoque);
				finish();
			}
		});

		serasa.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(intentSerasa);
				setContentView(R.layout.serasa);
				finish();
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
		intent = new Intent(getApplicationContext(),LoginActivity.class);
		startActivity(intent);
		setContentView(R.layout.login);			
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			final Intent intentLogin = new Intent(this, LoginActivity.class);			
			startActivity(intentLogin);
			setContentView(R.layout.login);
		}
		if (keyCode == KeyEvent.KEYCODE_MENU) {			
			openOptionsMenu();
		}
		return true;
	}	
}