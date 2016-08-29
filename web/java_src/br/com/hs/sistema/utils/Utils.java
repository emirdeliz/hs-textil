package br.com.hs.sistema.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static Date parseStringToDate(String str) {
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
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
}
