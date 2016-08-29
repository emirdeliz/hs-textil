package br.com.hs.sistema.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class SegurancaWS {
	private static String algorithm = "DESede";
	private static Key key = null;
	private static Cipher cipher = null;

	private static void setUp() throws Exception {
		key = new SecretKey(){	
			private static final long serialVersionUID = 1L;
	
			@Override
			public String getAlgorithm() {
				// TODO Auto-generated method stub
				return "DESede";
			}
	
			@Override
			public byte[] getEncoded() {
				// TODO Auto-generated method stub				
				return "{kg[a|u2s?kXè;pQt)hlEfof".getBytes();
			}
	
			@Override
			public String getFormat() {
				// TODO Auto-generated method stub
				return "RAW";
			}
		};
		cipher = Cipher.getInstance(algorithm);
	}

	public static String encrypt(String input){
		try{
			if(key == null)
				setUp();
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] inputBytes = input.getBytes();
			return new String(cipher.doFinal(inputBytes));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}

	public static String decrypt(byte[] encryptionBytes){
		try{
			if(key == null)
				setUp();
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
			String recovered = new String(recoveredBytes);
			return recovered;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}
}
