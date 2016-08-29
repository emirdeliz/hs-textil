package br.com.hs.sistema.utils;

import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.Mapper;

public class HibernateCollectionConverter extends CollectionConverter {
	public HibernateCollectionConverter(Mapper mapper) {
		super(mapper);
	}

	@SuppressWarnings("unchecked")
	public boolean canConvert(Class type) {
		return super.canConvert(type) || type == List.class
				|| type == Set.class;
	}

}