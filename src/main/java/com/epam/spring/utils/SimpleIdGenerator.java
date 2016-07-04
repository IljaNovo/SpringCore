package com.epam.spring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleIdGenerator{

	private static Map<DataType, Integer> idOfData = new HashMap<DataType, Integer>();
	private static SimpleIdGenerator elem;
	
	private SimpleIdGenerator() {
	}
	
	public static SimpleIdGenerator instance() {
		if (elem == null) {
			elem = new SimpleIdGenerator();
		}
		return elem;
	}
	
	public static void addListDataTypes(List<DataType> dataTypes) {
		idOfData = new HashMap<DataType, Integer>();
		for (int i = 0; i < dataTypes.size(); ++i) {
			idOfData.put(dataTypes.get(i), 0);
		}
	}
	
	public static int generate(DataType data) {
	    idOfData.put(data, idOfData.get(data) + 1);
	    return idOfData.get(data);
	}

	public static void addDataType(DataType data) {
		if (idOfData.get(data) != null) {
			idOfData.put(data, 0);
		}
	}
}
