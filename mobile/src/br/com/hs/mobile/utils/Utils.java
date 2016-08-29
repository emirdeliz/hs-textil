package br.com.hs.mobile.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Utils {

	public static Date parseStringToDate(String str) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Float parseStringToFloat(String strValor) {
		final Locale locale = new Locale("pt", "BR");
		NumberFormat nf = NumberFormat.getInstance(locale);
		float ret = 0;

		try {
			ret = nf.parse(strValor.replace("R$", "")).floatValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public static String formatCurrency(float valor) {
		final Locale locale = new Locale("pt", "BR");
		final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		String strValor = nf.format(valor);
		return strValor;
	}

	public static String formatDate(Date date) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}

	public static String MD5(String s) {

		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.update(s.getBytes(), 0, s.length());
		String md5 = new BigInteger(1, m.digest()).toString(16);
		return md5;
	}

	public static ViewGroup.LayoutParams setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null)
			return null;

		int totalHeight = 0;
		int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.AT_MOST);
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
			totalHeight += listItem.getMeasuredHeight();
		}
				
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight	+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
		return params;
	}	
}
