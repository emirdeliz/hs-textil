package br.com.hs.mobile.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import br.com.hs.mobile.acivity.R;
import br.com.hs.mobile.callback.Maintenace;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.model.entity.Visita;

public class VisitaAdapter extends BaseAdapter{
	private Context context;
	private List<Visita> listVisitas;
	private Maintenace maintenace;
	
	public VisitaAdapter(Context context,
			List<Visita> listVisitas) {
		this.context = context;
		this.listVisitas = listVisitas;	
	}

	public int getCount() {
		return listVisitas.size();
	}

	public Object getItem(int position) {
		return listVisitas.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	public void add(Visita v){
		this.listVisitas.add(v);
		this.notifyDataSetChanged();		
	}
	
	public List<Visita> getList(){
		return this.listVisitas;		
	}
	
	public void setList(List<Visita> listVisitas){			
		this.listVisitas = listVisitas;	  
		this.notifyDataSetChanged();
	}
	
	public void setMaintenance(Maintenace maintenace){
		this.maintenace = maintenace;
	}
		
	@Override
	public View getView(int position, View v, ViewGroup viewGroup) {		
		final Visita entry = listVisitas.get(position);			
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View convertView = inflater.inflate(R.layout.visita_row, null);
			
		TextView nmCliente = (TextView) convertView.findViewById(R.id.lblClienteVisitaRow);
		nmCliente.setText(entry.getCliente().getNome());
		
		if(entry.getDataVisita()!=null){
			TextView dtRealizacaoVisita = (TextView) convertView.findViewById(R.id.lblDataRealizacaoVisitaRow);			
			dtRealizacaoVisita.setText(Utils.formatDate(entry.getDataVisita()));
		}
				
		TextView dsObservacao = (TextView) convertView.findViewById(R.id.lblObservacaoVisitaRow);
		dsObservacao.setText(entry.getObservacao());
		
		Button btnConfirma = (Button) convertView.findViewById(R.id.btConfirmarVisitaRow);
		Button btnExcluir  = (Button) convertView.findViewById(R.id.btRemoverVisitaRow);	
		Button btnCancelar = (Button) convertView.findViewById(R.id.btCancelarVisitaRow);	
		Button btnEditar   = (Button) convertView.findViewById(R.id.btEditarVisitaRow);	
		
		btnConfirma.setFocusableInTouchMode(false);
		btnConfirma.setFocusable(false);
		btnConfirma.setTag(entry);
		btnConfirma.setOnClickListener(new OnClickListener() {				
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				maintenace.confirmar(entry);
			}
		});			
				
		btnExcluir.setFocusableInTouchMode(false);
		btnExcluir.setFocusable(false);		
		btnExcluir.setTag(entry);
		btnExcluir.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				maintenace.remover(entry);
			}
		});
					
		btnCancelar.setFocusableInTouchMode(false);
		btnCancelar.setFocusable(false);
		btnCancelar.setTag(entry);
		btnCancelar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				maintenace.cancelar(entry);
			}
		});		
					
		btnEditar.setFocusableInTouchMode(false);
		btnEditar.setFocusable(false);		
		btnEditar.setTag(entry);	
		btnEditar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				maintenace.editar(entry);
			}
		});	
		
		if(entry.getDataVisita()!=null){
			LinearLayout ll = (LinearLayout)convertView.findViewById(R.id.llManutencaoRow);
			ll.setVisibility(View.GONE);			
		}	
		
		if(entry.getInativo()){
			btnConfirma.setVisibility(View.GONE);
			btnCancelar.setVisibility(View.GONE);
		}
		return convertView;
	}

}
