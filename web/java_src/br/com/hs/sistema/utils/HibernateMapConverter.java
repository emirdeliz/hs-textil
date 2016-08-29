package br.com.hs.sistema.utils;

import org.hibernate.mapping.Map;

import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.mapper.Mapper;


public class HibernateMapConverter extends MapConverter {
	public HibernateMapConverter(Mapper mapper) {
		super(mapper);
	}
	@SuppressWarnings("unchecked")
	public boolean canConvert(Class type) {
		return super.canConvert(type) || type == Map.class;
	}
}
