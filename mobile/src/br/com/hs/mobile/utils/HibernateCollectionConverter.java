package br.com.hs.mobile.utils;

import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.Mapper;

public class HibernateCollectionConverter extends CollectionConverter {
	public HibernateCollectionConverter(Mapper mapper) {
		super(mapper);
	}

	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return super.canConvert(type) || type == List.class
				|| type == Set.class;
	}

}
