package br.com.hs.mobile.adapter;

import java.lang.reflect.Method;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

public class AutoCompleteAdapter<E> extends ArrayAdapter<String> {
	private ArrayList<E> mData;
	private ArrayList<String> result;

	public AutoCompleteAdapter(Context context, int textViewResourceId,
			ArrayList<E> mData) {
		super(context, textViewResourceId);
		this.mData = mData;
	}

	@Override
	public int getCount() {
		return result.size();
	}

	@Override
	public String getItem(int index) {
		String data = result.get(index);
		return data.substring(1, data.length());
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final LayoutInflater inflater = LayoutInflater.from(getContext());
		final TextView view = (TextView) inflater.inflate(
				android.R.layout.simple_dropdown_item_1line, parent, false);

		String data = result.get(position);
		int p = Integer.parseInt(data.substring(0,1));
		view.setText(data.substring(1, data.length()));
		view.setId(p);
			
		return view;
	}

	@Override
	public Filter getFilter() {
		Filter myFilter = new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				if (constraint != null) {
					result = new ArrayList<String>();
					try {
						result = filterData(constraint.toString());
					} catch (Exception e) {
					}
					// Now assign the values and count to the FilterResults
					// object
					filterResults.values = result;
					filterResults.count = result.size();
				}
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence contraint,
					FilterResults results) {
				if (results != null && results.count > 0) {
					notifyDataSetChanged();
				} else {
					notifyDataSetInvalidated();
				}
			}
		};
		return myFilter;
	}

	private ArrayList<String> filterData(String constraint) {

		ArrayList<String> result = new ArrayList<String>();

		for (E e : this.mData) {
			try {
				Method method1 = e.getClass().getMethod("getId");
				Method method2 = e.getClass().getMethod("getNome");

				String idObject = (String) method1.invoke(e);
				String nmObject = (String) method2.invoke(e);

				if (idObject.toLowerCase().contains(constraint.toLowerCase())|| nmObject.toLowerCase().contains(constraint.toLowerCase())){
					int p = this.mData.indexOf(e);
					result.add(p+idObject + "-" + nmObject);				
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		return result;
	}
}
