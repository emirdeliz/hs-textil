package br.com.hs.mobile.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.hs.mobile.acivity.R;
import br.com.hs.model.entity.Produto;

public class ProdutoEstoqueAdapter extends BaseAdapter{
	private Context context;
	private List<Produto> listProdutos;	
	
	public ProdutoEstoqueAdapter(Context context,
			List<Produto> listProdutos) {
		this.context = context;
		this.listProdutos = listProdutos;	
	}

	public int getCount() {
		return listProdutos.size();
	}

	public Object getItem(int position) {
		return listProdutos.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	public void add(Produto v){
		this.listProdutos.add(v);
		this.notifyDataSetChanged();		
	}
	
	public List<Produto> getList(){
		return this.listProdutos;		
	}
	
	public void setList(List<Produto> listProdutos){			
		this.listProdutos = listProdutos;	  
		this.notifyDataSetChanged();
	}
			
	@Override
	public View getView(int position, View v, ViewGroup viewGroup) {		
		final Produto entry = listProdutos.get(position);			
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View convertView = inflater.inflate(R.layout.produto_estoque_row, null);
			
		TextView nmProduto = (TextView) convertView.findViewById(R.id.lblProdutoEstoqueRow);
		nmProduto.setText(entry.getNome());
						
		TextView qtd = (TextView) convertView.findViewById(R.id.lblQtdProdutoEstoqueRow);
		qtd.setText(entry.getQtdEstoque()!=null?String.valueOf(entry.getQtdEstoque().intValue()):"0");		
		
		return convertView;
	}

}
