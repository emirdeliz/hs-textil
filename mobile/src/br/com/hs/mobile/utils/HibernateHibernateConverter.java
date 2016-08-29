package br.com.hs.mobile.utils;

import java.util.ArrayList;

import org.hibernate.collection.PersistentBag;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class HibernateHibernateConverter extends MapConverter {
	public HibernateHibernateConverter(Mapper mapper) {
		super(mapper);
		// TODO Auto-generated constructor stub
	}

	public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
		return PersistentBag.class == clazz;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void marshal(Object value, HierarchicalStreamWriter writer,MarshallingContext context) {
		PersistentBag bg = (PersistentBag) value;
		ArrayList replacementList = new ArrayList();
		replacementList.addAll(bg);
		context.convertAnother(replacementList);
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		// Should never be triggered
		return null;
	}
}
