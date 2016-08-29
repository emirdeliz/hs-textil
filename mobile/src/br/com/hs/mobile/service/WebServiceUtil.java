package br.com.hs.mobile.service;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class WebServiceUtil {

	public static Object chamaWsJava(String usuario, String senha,
			String method, String service, String[] params, String soap_action,
			String name_space, String url) throws IOException,
			XmlPullParserException {

		SoapObject request = new SoapObject(name_space, method);
		request.addProperty("usur", usuario);
		request.addProperty("pwrd", senha);

		if (params != null) {
			for (String param : params) {
				System.out.println("Param[0]: " + param.split(";")[0] + " Param[1]: " + param.split(";")[1]);
				request.addProperty(param.split(";")[0], param.split(";")[1]);
			}
		}

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		envelope.dotNet = false;

		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
		androidHttpTransport.debug = true;
		androidHttpTransport.call(soap_action + method, envelope);

		Object result = envelope.getResponse();
		return result;
	}

	public static String chamaWsDotNet(String method, String[] params,
			String soap_action, String name_space, String url)
			throws IOException, XmlPullParserException {
	
		SoapObject request = new SoapObject(name_space, method);

		if (params != null) {
			for (String param : params) {
				System.out.println("Param[0]: " + param.split(";")[0]+ " Param[1]: " + param.split(";")[1]);
				request.addProperty(param.split(";")[0], param.split(";")[1]);
			}
		}

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		envelope.dotNet = true;				

		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
		androidHttpTransport.debug = true;			
		androidHttpTransport.call(soap_action + method, envelope);		
		
		String result = envelope.getResponse().toString();		
		return result;	
	}
}
