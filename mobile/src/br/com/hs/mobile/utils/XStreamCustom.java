package br.com.hs.mobile.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.Mapper;

public class XStreamCustom extends XStream{
	public XStreamCustom(){
		super(new DomDriver());
		Mapper mapper = this.getMapper();
		this.registerConverter(new HibernateCollectionConverter(mapper));
		this.registerConverter(new HibernateHibernateConverter(mapper));
	}
}
