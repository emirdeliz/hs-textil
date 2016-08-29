package br.com.hs.mobile.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import br.com.hs.mobile.acivity.R;
import br.com.hs.mobile.utils.Utils;
import br.com.hs.model.entity.ProdutoVenda;

public class ProdutoVendaAdapter extends BaseAdapter implements OnClickListener{
	private Context context;
	private List<ProdutoVenda> listProdutoVenda;
	
	public ProdutoVendaAdapter(Context context,
			List<ProdutoVenda> listProdutoVenda) {
		this.context = context;
		this.listProdutoVenda = listProdutoVenda;	
	}

	public int getCount() {
		return listProdutoVenda.size();
	}

	public Object getItem(int position) {
		return listProdutoVenda.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	public void add(ProdutoVenda pv){
		this.listProdutoVenda.add(pv);
		this.notifyDataSetChanged();		
	}
	
	public List<ProdutoVenda> getList(){
		return this.listProdutoVenda;		
	}
		
	@Override
	public View getView(int position, View v, ViewGroup viewGroup) {
		View convertView = v;		
		ProdutoVenda entry = listProdutoVenda.get(position);	
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.produto_venda_row, null);
		}

		TextView nmProduto = (TextView) convertView.findViewById(R.id.lblNomeProdutoPVRow);
		nmProduto.setText(entry.getProduto().getNome());
		
		TextView qtd = (TextView) convertView.findViewById(R.id.lblQtdPVRow);			
		qtd.setText(entry.getQuantidade().toString());
				
		TextView vlTotal = (TextView) convertView.findViewById(R.id.lblVlTotalItemPVRow);
		vlTotal.setText(Utils.formatCurrency(entry.getValorTotal()));
				
		Button btnRemove = (Button) convertView.findViewById(R.id.btRemoveItemPV);
        btnRemove.setFocusableInTouchMode(false);
        btnRemove.setFocusable(false);
        btnRemove.setOnClickListener(this);
        btnRemove.setTag(entry);
		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ProdutoVenda entry = (ProdutoVenda) v.getTag();
  		this.listProdutoVenda.remove(entry);            		
  		this.notifyDataSetChanged();   			
	}	
}
