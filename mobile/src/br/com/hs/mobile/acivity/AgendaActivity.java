package br.com.hs.mobile.acivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import br.com.hs.mobile.adapter.AutoCompleteAdapter;
import br.com.hs.mobile.adapter.VisitaAdapter;
import br.com.hs.mobile.application.GlobalVar;
import br.com.hs.mobile.callback.Maintenace;
import br.com.hs.mobile.service.WebServiceUtil;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.mobile.utils.XStreamCustom;
import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.Visita;

public class AgendaActivity extends Activity {

	private TextView lblVisitaObservacao;

	private RadioGroup rbgStatus;

	private AutoCompleteTextView atc1;

	private DatePicker dtVisita;

	private EditText txtObsVisita;

	private ListView lvVisitas;

	private Intent intent;

	private List<Cliente> listCliente;

	private Cliente cliente;

	private Button btConsultar;

	private VisitaAdapter visitaAdapter;

	private List<Visita> listVisitas;

	private Visita visita;

	private String status = "novo";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agenda);
		inicio();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu); 
    	menu.getItem(1).setTitle(status.equals("novo")?"Novo":"Salvar");
		menu.getItem(1).setIcon(status.equals("novo")?R.drawable.add:R.drawable.salvar);
        return true;
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu){
		if(menu!=null){							
			menu.getItem(1).setTitle(status.equals("novo")?"Novo":"Salvar");
			menu.getItem(1).setIcon(status.equals("novo")?R.drawable.add:R.drawable.salvar);
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getTitle().equals("Voltar")){			
			if (status.equals("novo")) {							
				intent = new Intent(getApplicationContext(),MasterActivity.class);
				startActivity(intent);
				setContentView(R.layout.master);
			} else {				
				lblVisitaObservacao.setText("Visitas:");				
				txtObsVisita.setVisibility(View.GONE);
				lvVisitas.setVisibility(View.VISIBLE);
				btConsultar.setVisibility(View.VISIBLE);				
			}
			status = "novo";
		}else{
			if (status.equals("novo")) {
				status = "salvar";
				lblVisitaObservacao.setText("Observação:");
				txtObsVisita.setVisibility(View.VISIBLE);
				lvVisitas.setVisibility(View.GONE);				
				btConsultar.setVisibility(View.GONE);
			} else {
				salvar(visita);
			}
		}		
		return true;
	}
	
	private void inicio() {		
		this.lblVisitaObservacao = (TextView) findViewById(R.id.lblVisita_observacao);
		this.txtObsVisita = (EditText) findViewById(R.id.txtObservacaoAgenda);
		this.dtVisita = (DatePicker) findViewById(R.id.dtVisita);
		this.btConsultar = (Button) findViewById(R.id.btConsultaAgenda);

		this.btConsultar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buscaVisitas();				
			}
		});
	
		this.atc1 = (AutoCompleteTextView) findViewById(R.id.txtNomeClienteAgenda);
		this.atc1.setAdapter(new AutoCompleteAdapter<Cliente>(this,
				android.R.layout.simple_dropdown_item_1line, buscaClientes()));
		this.atc1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				cliente = listCliente.get(arg1.getId());
			}
		});

		this.rbgStatus = (RadioGroup) findViewById(R.id.rdbStatus);
		this.listVisitas = new ArrayList<Visita>();
		this.visitaAdapter = new VisitaAdapter(this, listVisitas);
		this.visitaAdapter.setMaintenance(new Maintenace() {
			@Override
			public void remover(Object entidade) {
				// TODO Auto-generated method stub
				removerAgenda((Visita) entidade);
			}

			@Override
			public void editar(Object entidade) {
				// TODO Auto-generated method stub
				editarAgenda((Visita) entidade);
			}

			@Override
			public void confirmar(Object entidade) {
				// TODO Auto-generated method stub
				confirmarAgenda((Visita) entidade);
			}

			@Override
			public void cancelar(Object entidade) {
				// TODO Auto-generated method stub
				cancelarAgenda((Visita) entidade);
			}
		});
		this.lvVisitas = (ListView) findViewById(R.id.lvVisitas);
		this.lvVisitas.setAdapter(visitaAdapter);
		this.buscaVisitas();
	}

	@SuppressWarnings("unchecked")
	private void buscaVisitas() {
		Boolean inativo = (this.rbgStatus.getCheckedRadioButtonId() == R.id.rdbStatusCancelada);
		Date dt = new Date((this.dtVisita.getYear() - 1900),
				this.dtVisita.getMonth(), this.dtVisita.getDayOfMonth());
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strR = new XStreamCustom().toXML(GlobalVar.getInstance()
				.getUsuario());

		String[] params = { "dataAgenda;" + formatter.format(dt),
				"representante;" + strR, "inativo;" + inativo.toString() };

		this.listVisitas = (ArrayList<Visita>) executaWS("buscaVisitas", params);
		if (this.listVisitas == null) {
			this.listVisitas = new ArrayList<Visita>();
		}
		this.visitaAdapter.setList(this.listVisitas);
		
		this.lvVisitas.postDelayed(new Runnable() {
			public void run () {
				Utils.setListViewHeightBasedOnChildren(lvVisitas);	
			}
		}
		, 1000);			
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Cliente> buscaClientes() {
		this.listCliente = (List<Cliente>) executaWS("buscaClientes", null);
		if (this.listCliente == null || this.listCliente.size() <= 0) {
			this.mostraMensagem("Não foram encontrados itens com o parâmetro informado. Verifique o cadastro de clientes e a conexão com o aplicativo da HS.");
		}
		return (ArrayList<Cliente>) this.listCliente;
	}

	private void salvar(Visita v) {
		if (!validaAgenda())
			return;

		Boolean inativo = (this.rbgStatus.getCheckedRadioButtonId() == R.id.rdbStatusCancelada);
		Date dt = new Date((this.dtVisita.getYear() - 1900),
				this.dtVisita.getMonth(), (this.dtVisita.getDayOfMonth()));
		if (v == null) {
			v = new Visita();
			v.setDataContato(new Date());
		}

		v.setCliente(this.cliente);
		v.setDataAgenda(dt);
		v.setObservacao(this.txtObsVisita.getText().toString());
		v.setRepresentante(GlobalVar.getInstance().getUsuario());
		v.setInativo(inativo);

		String cS = new XStreamCustom().toXML(v);
		String[] params = { "visita;" + cS };
		String ret = (String) executaWS("atualizarAgenda", params);
		this.mostraMensagem(ret);
		this.limpaDadosAgenda();
	}

	private void confirmarAgenda(final Visita visita) {
		final Context context = this;
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setTitle("Confirmar data visita");
		alertbox.setMessage("Confirmar realização da vista?");
		alertbox.setIcon(android.R.drawable.ic_dialog_alert);
		alertbox.setPositiveButton(android.R.string.yes,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Calendar c = Calendar.getInstance();
						int cyear = c.get(Calendar.YEAR);
						int cmonth = c.get(Calendar.MONTH);
						int cday = c.get(Calendar.DAY_OF_MONTH);

						DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
							// onDateSet method
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								Date dt = new Date(year - 1900, monthOfYear,
										dayOfMonth);
								visita.setDataVisita(dt);
								String cS = new XStreamCustom().toXML(visita);
								String[] params = { "visita;" + cS };
								String ret = (String) executaWS(
										"atualizarAgenda", params);
								mostraMensagem(ret);
								buscaVisitas();
							}
						};
						DatePickerDialog datePickerDialog = new DatePickerDialog(
								context, mDateSetListener, cyear, cmonth, cday);
						datePickerDialog.setTitle("Data visita");
						datePickerDialog.show();
					}
				});
		alertbox.setNegativeButton(android.R.string.no, null);
		alertbox.show();
	}

	private void editarAgenda(final Visita visita) {
		this.txtObsVisita.setText(visita.getObservacao());
		this.atc1.setText(visita.getCliente().getNome());

		int ano = visita.getDataAgenda().getYear() + 1900;
		int mes = visita.getDataAgenda().getMonth();
		int dia = visita.getDataAgenda().getDate();

		this.cliente = visita.getCliente();
		this.dtVisita.init(ano, mes, dia, null);
		this.lblVisitaObservacao.setText("Observação:");
		this.txtObsVisita.setVisibility(View.VISIBLE);
		this.lvVisitas.setVisibility(View.GONE);		
		this.btConsultar.setVisibility(View.GONE);
		this.visita = visita;
		this.status = "salvar";
		
		RadioButton rd = (RadioButton) findViewById((visita.getInativo() ? R.id.rdbStatusCancelada
				: R.id.rdbStatusAtivo));
		rd.setChecked(true);
	}

	private void cancelarAgenda(final Visita v) {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setTitle("Confirmar cancelamento");
		alertbox.setMessage("Confirmar cancelamento?");
		alertbox.setIcon(android.R.drawable.ic_dialog_alert);
		alertbox.setPositiveButton(android.R.string.yes,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						v.setInativo(true);
						String cS = new XStreamCustom().toXML(v);
						String[] params = { "visita;" + cS };
						String ret = (String) executaWS("atualizarAgenda",
								params);
						mostraMensagem(ret);
						buscaVisitas();
					}
				});
		alertbox.setNegativeButton(android.R.string.no, null);
		alertbox.show();
	}

	private void removerAgenda(final Visita v) {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setTitle("Confirmar remoção");
		alertbox.setMessage("Confirmar remoção?");
		alertbox.setIcon(android.R.drawable.ic_dialog_alert);
		alertbox.setPositiveButton(android.R.string.yes,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String cS = new XStreamCustom().toXML(v);
						String[] params = { "visita;" + cS };
						String ret = (String) executaWS("removerAgenda", params);
						mostraMensagem(ret);
						buscaVisitas();
					}
				});
		alertbox.setNegativeButton(android.R.string.no, null);
		alertbox.show();
	}

	private Boolean validaAgenda() {
		if (this.cliente == null) {
			this.mostraMensagem("Favor, informe o cliente.");
			return false;
		}
		return true;
	}

	private void limpaDadosAgenda() {
		this.atc1.setText("");
		this.txtObsVisita.setText("");
		this.lblVisitaObservacao.setText("Visitas:");
		this.status = "novo";		
		this.txtObsVisita.setVisibility(View.GONE);
		this.lvVisitas.setVisibility(View.VISIBLE);
		this.btConsultar.setVisibility(View.VISIBLE);
		this.buscaVisitas();
	}

	private Object executaWS(String method, String[] object) {
		Resources r = this.getResources();
		String url = r.getString((R.string.url));
		String name_space = r.getString(R.string.name_space);
		String soap_action = r.getString(R.string.soap_action);
		Object result = null;

		String usuario = GlobalVar.getInstance().getUsuario().getUsuario();
		String senha = GlobalVar.getInstance().getUsuario().getSenha();

		System.out.println("SENHA: "
				+ GlobalVar.getInstance().getUsuario().getSenha());

		try {
			XStreamCustom xStream = new XStreamCustom();
			String strResult = WebServiceUtil.chamaWsJava(usuario, senha,
					method, "services", object, soap_action, name_space, url)
					.toString();
			result = (Object) xStream.fromXML(strResult);
		} catch (Exception e) {
			// TODO: handle exception
			mostraMensagem("Ocorreu um erro ao acessar o WS da HS. Verifique o status do serviço e se você possui permissão de acesso ao WS.");
			e.printStackTrace();
		}
		return result;
	}

	private void mostraMensagem(String msg) {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setMessage(msg);
		alertbox.setNeutralButton("OK", null);
		alertbox.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {		
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			final Intent intentMaster = new Intent(this, MasterActivity.class);
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
