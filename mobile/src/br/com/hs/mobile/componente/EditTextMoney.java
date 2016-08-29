package br.com.hs.mobile.componente;

import java.text.NumberFormat;
import java.util.Locale;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextMoney extends EditText {

	public EditTextMoney(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		final EditTextMoney ip = this;
		this.addTextChangedListener(new TextWatcher() {
			private String current = "";

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
				
				if (!s.toString().equals(current) && !s.toString().equals("")) {
					String cleanString = s.toString().replaceAll("[R$,.]", "");

					double parsed = Double.parseDouble(cleanString);
					final Locale locale = new Locale("pt","BR");
					
					String formato = NumberFormat.getCurrencyInstance(locale).format((parsed / 100));
					current = formato;

					ip.setText(formato);
					ip.setSelection(formato.length());
				}
				
				/*if (!s.toString().equals(current) && !s.toString().equals("")) {
					Float parsed = Utils.parseStringToFloat(s.toString());					
					String formato = Utils.formatCurrency(parsed);
					current = s.toString();

					ip.setText(formato);
					ip.setSelection(formato.length());
				}
				*/
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
	}
}
