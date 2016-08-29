package br.com.hs.sistema.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamCustom extends XStream{
	public XStreamCustom(){
		super(new DomDriver());	
		this.registerConverter(new DateConverter());		
	}
}
